package com.clinica.entity.modalMapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.clinica.config.ModelMapperConfig;
import com.clinica.dto.ExameDTO;
import com.clinica.entity.exame;

public class ExameModalMapper {

	@Autowired
	private ModelMapperConfig modalMapper;
	
	public exame PrestadormodelMapperOne(ExameDTO dto) {
		exame obj = modalMapper.modelMapper().map(dto, exame.class);
		return obj;
	}

	public List<exame> PrestadorModelMapperList(List<ExameDTO> dto) {
		return dto.stream().map(obj -> PrestadormodelMapperOne(obj)).collect(Collectors.toList());
	}
}
