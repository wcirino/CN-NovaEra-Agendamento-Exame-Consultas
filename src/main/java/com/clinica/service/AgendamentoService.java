package com.clinica.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.dto.AgendamentoDTO;
import com.clinica.repository.AgendamentoRepository;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoproxy;
	
	private static final Logger LOG = LoggerFactory.getLogger(AgendamentoService.class);
	
	public List<AgendamentoDTO> findAll_agendamento() throws Exception{
		LOG.info("Iniciando Service Agendamento: agendamentoproxy.findAll()");
		Optional<List<AgendamentoDTO>> obj = Optional.ofNullable(agendamentoproxy.findAll());
		LOG.info("Finalizando Service Agendamento: agendamentoproxy.findAll() ");
		return obj.orElseThrow(() -> new Exception("Ocorreu um erro não previsto no sistema, sem agendamento"));
	}
	
	public AgendamentoDTO find_Agendamento_id(int id) throws Exception{
		LOG.info("Iniciando Service Agendamento: agendamentoproxy.findByidagendamento");
		Optional<AgendamentoDTO> obj = Optional.ofNullable(agendamentoproxy.findByidagendamento(id));
		LOG.info("Fim Service Agendamento: findByidagendamento");
		return obj.orElseThrow(() -> new Exception("Ocorreu um erro não previsto no sistema, sem agendamento 2"));
	}
	
	public AgendamentoDTO Insertagendamento(AgendamentoDTO dto) throws Exception{
		LOG.info("Iniciando Service Agendamento: Insertagendamento()");
		if(dto == null || dto.getIdagendamento() != null){
			throw new Exception("O agendamento  possui Id");
		}
		else {
			LOG.info("Iniciando Service Agendamento: agendamentoproxy.save()");
			AgendamentoDTO obj = agendamentoproxy.save(dto);
			LOG.info("Fim Service Agendamento: agendamentoproxy.save");
			return obj;
		}
	}
	
	public AgendamentoDTO Updategendamento(AgendamentoDTO dto) throws Exception{
		LOG.info("Iniciando Service Agendamento: Updategendamento()");
		if(dto == null || dto.getIdagendamento() == null){
			throw new Exception("O agendamento não possui Id");
		}
		else {
			LOG.info("Iniciando Service Agendamento: agendamentoproxy.save()");
			AgendamentoDTO obj = agendamentoproxy.save(dto);
			LOG.info("Iniciando Service Agendamento: agendamentoproxy.save");
			return obj;
		}
	}	
}
