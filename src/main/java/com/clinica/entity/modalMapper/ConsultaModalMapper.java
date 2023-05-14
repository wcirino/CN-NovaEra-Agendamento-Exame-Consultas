package com.clinica.entity.modalMapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clinica.config.ModelMapperConfig;
import com.clinica.dto.ConsultaDTO;
import com.clinica.entity.consulta;

@Component
public class ConsultaModalMapper {

	@Autowired
	private ModelMapperConfig modalMapper;

	public consulta consultamodelMapperOne(ConsultaDTO dto) {
		consulta obj = modalMapper.modelMapper().map(dto, consulta.class);
		return obj;
	}

	public List<consulta> consultaModelMapperList(List<ConsultaDTO> dto) {
		return dto.stream().map(obj -> consultamodelMapperOne(obj)).collect(Collectors.toList());

	}
}