package com.clinica.service;

import java.util.List;
import java.util.Optional;
//import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.repository.ExameRepository;
//import com.clinica.config.ModelMapperConfig;
import com.clinica.dto.ExameDTO;
//import com.clinica.entity.exame;

@Service
public class ExameService {

	@Autowired
	private ExameRepository proxyExame;
	
	private static final Logger LOG = LoggerFactory.getLogger(ExameService.class);
	
	public List<ExameDTO> findAll_Exame() throws Exception{
		LOG.info("Iniciando service ExameService : proxyExame.findAll()");
		Optional<List<ExameDTO>> obj = Optional.ofNullable(proxyExame.findAll());
		LOG.info("Fim service ExameService : proxyExame.findAll()");
		return obj.orElseThrow(() -> new Exception());
	}
	
	public ExameDTO find_Exame_id(int id) throws Exception{
		LOG.info("Iniciando service ExameService :find_Exame_id");
		if(id <= 0) {
			throw new Exception();
		}
		LOG.info("Iniciando service ExameService : proxyExame.findByidexame");
		Optional<ExameDTO> obj = Optional.ofNullable(proxyExame.findByidexame(id));
		LOG.info("Fim service ExameService : proxyExame.findByidexame");
		return obj.orElseThrow(() -> new Exception());
	}
	
	public ExameDTO InsertExame(ExameDTO dto) throws Exception{
		LOG.info("Iniciando service ExameService : InsertExame");
		if(dto == null || dto.getIdexame() != null){
			throw new Exception("A Consulta possui Id");
		}
		else {
			LOG.info("Iniciando service ExameService : proxyExame.save");
			ExameDTO obj = proxyExame.save(dto);
			LOG.info("Fim service ExameService : proxyExame.save");
			return obj;
		}
	}
	
	public ExameDTO UpdateExame(ExameDTO dto) throws Exception{
		LOG.info("Iniando service ExameService : UpdateExame");
		if(dto == null || dto.getIdexame() == null){
			throw new Exception(""
					+ "A consulta não possui Id");
		}
		else {
			LOG.info("Iniciando service ExameService : proxyExame.save()");
			ExameDTO obj = proxyExame.save(dto);
			LOG.info("Fim service ExameService : proxyExame.save()");
			return obj;
		}
	} 
	
}
