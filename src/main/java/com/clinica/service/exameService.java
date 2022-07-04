package com.clinica.service;

import java.util.List;
import java.util.Optional;
//import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.repository.exameRepository;
//import com.clinica.config.ModelMapperConfig;
import com.clinica.dto.exameDTO;
//import com.clinica.entity.exame;

@Service
public class exameService {

	@Autowired
	private exameRepository proxyExame;
	
	private static final Logger LOG = LoggerFactory.getLogger(exameService.class);
	
	public List<exameDTO> findAll_Exame() throws Exception{
		LOG.info("Iniciando service ExameService : proxyExame.findAll()");
		Optional<List<exameDTO>> obj = Optional.ofNullable(proxyExame.findAll());
		LOG.info("Fim service ExameService : proxyExame.findAll()");
		return obj.orElseThrow(() -> new Exception());
	}
	
	public exameDTO find_Exame_id(int id) throws Exception{
		LOG.info("Iniciando service ExameService :find_Exame_id");
		if(id <= 0) {
			throw new Exception();
		}
		LOG.info("Iniciando service ExameService : proxyExame.findByidexame");
		Optional<exameDTO> obj = Optional.ofNullable(proxyExame.findByidexame(id));
		LOG.info("Fim service ExameService : proxyExame.findByidexame");
		return obj.orElseThrow(() -> new Exception());
	}
	
	public exameDTO InsertExame(exameDTO dto) throws Exception{
		LOG.info("Iniciando service ExameService : InsertExame");
		if(dto == null || dto.getIdexame() != null){
			throw new Exception("A Consulta possui Id");
		}
		else {
			LOG.info("Iniciando service ExameService : proxyExame.save");
			exameDTO obj = proxyExame.save(dto);
			LOG.info("Fim service ExameService : proxyExame.save");
			return obj;
		}
	}
	
	public exameDTO UpdateExame(exameDTO dto) throws Exception{
		LOG.info("Iniando service ExameService : UpdateExame");
		if(dto == null || dto.getIdexame() == null){
			throw new Exception(""
					+ "A consulta não possui Id");
		}
		else {
			LOG.info("Iniciando service ExameService : proxyExame.save()");
			exameDTO obj = proxyExame.save(dto);
			LOG.info("Fim service ExameService : proxyExame.save()");
			return obj;
		}
	} 
	
}
