package com.clinica.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.dto.TipoAgendamentoDTO;
import com.clinica.repository.TipoAgendamentorepository;

@Service
public class TipoAgendamentoService {

	@Autowired
	private TipoAgendamentorepository tipoagendamentoproxy;
	
	private static final Logger LOG = LoggerFactory.getLogger(TipoAgendamentoService.class);
	
	public List<TipoAgendamentoDTO> findAll_TipoAgendamento() throws Exception{
		LOG.info("Iniciando Service tipoagendamento :tipoagendamentoproxy.findAll()");
		Optional<List<TipoAgendamentoDTO>> obj = Optional.ofNullable(tipoagendamentoproxy.findAll());
		LOG.info("Fim Service tipoagendamento : tipoagendamentoproxy.findAll()");
		return obj.orElseThrow(() -> new Exception());
	}
	
	public TipoAgendamentoDTO find_tipoAgendamento_id(int id) throws Exception{
		LOG.info("Iniciando Service tipoagendamento : tipoagendamentoproxy.findByidtipoagendamento");
		Optional<TipoAgendamentoDTO> obj = Optional.ofNullable(tipoagendamentoproxy.findByidtipoagendamento(id));
		LOG.info("Fim Service tipoagendamento : tipoagendamentoproxy.findByidtipoagendamento");
		return obj.orElseThrow(() -> new Exception());
	}
	
	public TipoAgendamentoDTO InsertTipoAgendamento(TipoAgendamentoDTO dto) throws Exception{
		LOG.info("Iniciando Service tipoagendamento : InsertTipoAgendamento()");
		if(dto == null || dto.getIdtipoagendamento() != null) {
			throw new Exception("A Consulta possui Id");
		}
		else {
			LOG.info("Iniciando Service tipoagendamento : tipoagendamentoproxy.save()");
			TipoAgendamentoDTO obj = tipoagendamentoproxy.save(dto);
			LOG.info("Fim Service tipoagendamento : tipoagendamentoproxy.save");
			return obj;
		}
	}
	
	public TipoAgendamentoDTO UpdateTipoAgendamento(TipoAgendamentoDTO dto) throws Exception{
		// if(book == null || book.getId() == null){
		LOG.info("Iniciando Service tipoagendamento : findAll_TipoAgendamento()");
		if(dto == null || dto.getIdtipoagendamento() == null) {
			throw new Exception(""
					+ "A consulta não possui Id");
		}
		else {
			LOG.info("Iniciando Service tipoagendamento : tipoagendamentoproxy.save()");
			TipoAgendamentoDTO obj = tipoagendamentoproxy.save(dto);
			LOG.info("Fim Service tipoagendamento : tipoagendamentoproxy.save()");
			return obj;
		}
	}
	
}
