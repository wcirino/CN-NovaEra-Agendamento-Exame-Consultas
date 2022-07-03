package com.clinica.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.dto.tipoExameDTO;
import com.clinica.repository.tipoExameRespository;


@Service
public class tipoExameService {

	@Autowired
	private tipoExameRespository proxytipExame;
	
	private static final Logger LOG = LoggerFactory.getLogger(tipoExameService.class);
	
	public List<tipoExameDTO> findAll_TipoExame() throws Exception{
		LOG.info("Iniciando Service TipoExameService: proxytipExame.findAll() ");
		Optional<List<tipoExameDTO>> obj = Optional.ofNullable(proxytipExame.findAll());
		LOG.info("Fim Service TipoExameService: proxytipExame.findAll() ");
		return obj.orElseThrow(() -> new Exception());
	}
	
	public tipoExameDTO find_tipoExame_id(int id) throws Exception{
		LOG.info("Iniciando Service TipoExameService:proxytipExame.findByidtipoexame()");
		Optional<tipoExameDTO> obj = Optional.ofNullable(proxytipExame.findByidtipoexame(id));
		LOG.info("Fim Service TipoExameService: proxytipExame.findByidtipoexame() ");
		return obj.orElseThrow(() -> new Exception());
	}
	
	public tipoExameDTO InsertExame(tipoExameDTO dto) throws Exception{
		LOG.info("Iniciando Service TipoExameService: InsertExame");
		if(dto == null || dto.getIdtipoexame() != null) {
			throw new Exception("A Consulta possui Id");
		}
		else {
			LOG.info("Iniciando Service TipoExameService:");
			tipoExameDTO obj = proxytipExame.save(dto);
			LOG.info("Fim Service TipoExameService: proxytipExame.save()");
			return obj;
		}
	}
	
	public tipoExameDTO UpdateExame(tipoExameDTO dto) throws Exception{
		LOG.info("Iniciando Service TipoExameService: UpdateExame");
		if(dto == null || dto.getIdtipoexame() == null) {
			throw new Exception(""
					+ "A consulta não possui Id Update");
		}
		else {
			LOG.info("Iniciando Service TipoExameService: proxytipExame.save");
			tipoExameDTO obj = proxytipExame.save(dto);
			LOG.info("Fim Service TipoExameService: proxytipExame.save()");
			return obj;
		}
	}
	
}
