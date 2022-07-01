package com.clinica.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.repository.exameRepository;
import com.clinica.config.ModelMapperConfig;
import com.clinica.dto.exameDTO;
import com.clinica.entity.exame;

@Service
public class exameService {

	@Autowired
	private exameRepository proxyExame;
	
	@Autowired
	private ModelMapperConfig modalMapper;
	
	public List<exameDTO> findAll_Exame() throws Exception{
		Optional<List<exameDTO>> obj = Optional.ofNullable(proxyExame.findAll());
		return obj.orElseThrow(() -> new Exception());
	}
	
	public exameDTO find_Exame_id(int id) throws Exception{
		if(id <= 0) {
			throw new Exception();
		}
		Optional<exameDTO> obj = Optional.ofNullable(proxyExame.findByidexame(id));
		return obj.orElseThrow(() -> new Exception());
	}
	
	public exameDTO InsertExame(exameDTO dto) throws Exception{
		if(dto == null || dto.getIdexame() != null){
			throw new Exception("A Consulta possui Id");
		}
		else {
			exameDTO obj = proxyExame.save(dto);
			return obj;
		}
	}
	
	public exameDTO UpdateExame(exameDTO dto) throws Exception{
		if(dto == null || dto.getIdexame() == null){
			throw new Exception(""
					+ "A consulta não possui Id");
		}
		else {
			exameDTO obj = proxyExame.save(dto);
			return obj;
		}
	}
	
	private exame PrestadormodelMapperOne(exameDTO dto) {
		exame obj = modalMapper.modelMapper().map(dto, exame.class);
		return obj;
	}
	
	private List<exame> PrestadorModelMapperList(List<exameDTO> dto){	
		  return dto.stream().map(obj -> PrestadormodelMapperOne(obj)).collect(Collectors.toList());
	}
	
}
