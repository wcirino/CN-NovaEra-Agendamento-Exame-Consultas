package com.clinica.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.dto.tipoagendamentoDTO;
import com.clinica.repository.tipoagendamentorepository;

@Service
public class tipoagendamentoService {

	@Autowired
	private tipoagendamentorepository tipoagendamentoproxy;
	
	private static final Logger LOG = LoggerFactory.getLogger(tipoagendamentoService.class);
	
	public List<tipoagendamentoDTO> findAll_TipoAgendamento() throws Exception{
		LOG.info("Iniciando Service tipoagendamento :tipoagendamentoproxy.findAll()");
		Optional<List<tipoagendamentoDTO>> obj = Optional.ofNullable(tipoagendamentoproxy.findAll());
		LOG.info("Fim Service tipoagendamento : tipoagendamentoproxy.findAll()");
		return obj.orElseThrow(() -> new Exception());
	}
	
	public tipoagendamentoDTO find_tipoAgendamento_id(int id) throws Exception{
		LOG.info("Iniciando Service tipoagendamento : tipoagendamentoproxy.findByidtipoagendamento");
		Optional<tipoagendamentoDTO> obj = Optional.ofNullable(tipoagendamentoproxy.findByidtipoagendamento(id));
		LOG.info("Fim Service tipoagendamento : tipoagendamentoproxy.findByidtipoagendamento");
		return obj.orElseThrow(() -> new Exception());
	}
	
	public tipoagendamentoDTO InsertTipoAgendamento(tipoagendamentoDTO dto) throws Exception{
		LOG.info("Iniciando Service tipoagendamento : InsertTipoAgendamento()");
		if(dto == null || dto.getIdtipoagendamento() != null) {
			throw new Exception("A Consulta possui Id");
		}
		else {
			LOG.info("Iniciando Service tipoagendamento : tipoagendamentoproxy.save()");
			tipoagendamentoDTO obj = tipoagendamentoproxy.save(dto);
			LOG.info("Fim Service tipoagendamento : tipoagendamentoproxy.save");
			return obj;
		}
	}
	
	public tipoagendamentoDTO UpdateTipoAgendamento(tipoagendamentoDTO dto) throws Exception{
		// if(book == null || book.getId() == null){
		LOG.info("Iniciando Service tipoagendamento : findAll_TipoAgendamento()");
		if(dto == null || dto.getIdtipoagendamento() == null) {
			throw new Exception(""
					+ "A consulta não possui Id");
		}
		else {
			LOG.info("Iniciando Service tipoagendamento : tipoagendamentoproxy.save()");
			tipoagendamentoDTO obj = tipoagendamentoproxy.save(dto);
			LOG.info("Fim Service tipoagendamento : tipoagendamentoproxy.save()");
			return obj;
		}
	}
	
}
