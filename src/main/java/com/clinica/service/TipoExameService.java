package com.clinica.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.dto.TipoExameDTO;
import com.clinica.repository.TipoExameRespository;


@Service
public class TipoExameService {

	@Autowired
	private TipoExameRespository proxytipExame;
	
	private static final Logger LOG = LoggerFactory.getLogger(TipoExameService.class);
	
	public List<TipoExameDTO> findAll_TipoExame() throws Exception{
		LOG.info("Iniciando Service TipoExameService: proxytipExame.findAll() ");
		Optional<List<TipoExameDTO>> obj = Optional.ofNullable(proxytipExame.findAll());
		LOG.info("Fim Service TipoExameService: proxytipExame.findAll() ");
		return obj.orElseThrow(() -> new Exception());
	}
	
	public TipoExameDTO find_tipoExame_id(int id) throws Exception{
		LOG.info("Iniciando Service TipoExameService:proxytipExame.findByidtipoexame()");
		Optional<TipoExameDTO> obj = Optional.ofNullable(proxytipExame.findByidtipoexame(id));
		LOG.info("Fim Service TipoExameService: proxytipExame.findByidtipoexame() ");
		return obj.orElseThrow(() -> new Exception());
	}
	
	public TipoExameDTO InsertExame(TipoExameDTO dto) throws Exception{
		LOG.info("Iniciando Service TipoExameService: InsertExame");
		if(dto == null || dto.getIdtipoexame() != null) {
			throw new Exception("A Consulta possui Id");
		}
		else {
			LOG.info("Iniciando Service TipoExameService:");
			TipoExameDTO obj = proxytipExame.save(dto);
			LOG.info("Fim Service TipoExameService: proxytipExame.save()");
			return obj;
		}
	}
	
	public TipoExameDTO UpdateExame(TipoExameDTO dto) throws Exception{
		LOG.info("Iniciando Service TipoExameService: UpdateExame");
		if(dto == null || dto.getIdtipoexame() == null) {
			throw new Exception(""
					+ "A consulta não possui Id Update");
		}
		else {
			LOG.info("Iniciando Service TipoExameService: proxytipExame.save");
			TipoExameDTO obj = proxytipExame.save(dto);
			LOG.info("Fim Service TipoExameService: proxytipExame.save()");
			return obj;
		}
	}
	
}
