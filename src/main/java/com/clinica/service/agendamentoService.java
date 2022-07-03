package com.clinica.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.clinica.config.ModelMapperConfig;
import com.clinica.dto.agendamentoDTO;
import com.clinica.repository.AgendamentoRepository;

@Service
public class agendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoproxy;
	
	/*
	 * @Autowired private ModelMapperConfig modalMapper;
	 */
	
	private static final Logger LOG = LoggerFactory.getLogger(agendamentoService.class);
	
	public List<agendamentoDTO> findAll_agendamento() throws Exception{
		LOG.info("Iniciando Service Agendamento: agendamentoproxy.findAll()");
		Optional<List<agendamentoDTO>> obj = Optional.ofNullable(agendamentoproxy.findAll());
		LOG.info("Finalizando Service Agendamento: agendamentoproxy.findAll() ");
		return obj.orElseThrow(() -> new Exception("Ocorreu um erro não previsto no sistema, sem agendamento"));
	}
	
	public agendamentoDTO find_Agendamento_id(int id) throws Exception{
		LOG.info("Iniciando Service Agendamento: agendamentoproxy.findByidagendamento");
		Optional<agendamentoDTO> obj = Optional.ofNullable(agendamentoproxy.findByidagendamento(id));
		LOG.info("Fim Service Agendamento: findByidagendamento");
		return obj.orElseThrow(() -> new Exception("Ocorreu um erro não previsto no sistema, sem agendamento 2"));
	}
	
	public agendamentoDTO Insertagendamento(agendamentoDTO dto) throws Exception{
		LOG.info("Iniciando Service Agendamento: Insertagendamento()");
		if(dto == null || dto.getIdagendamento() != null){
			throw new Exception("O agendamento  possui Id");
		}
		else {
			LOG.info("Iniciando Service Agendamento: agendamentoproxy.save()");
			agendamentoDTO obj = agendamentoproxy.save(dto);
			LOG.info("Fim Service Agendamento: agendamentoproxy.save");
			return obj;
		}
	}
	
	public agendamentoDTO Updategendamento(agendamentoDTO dto) throws Exception{
		LOG.info("Iniciando Service Agendamento: Updategendamento()");
		if(dto == null || dto.getIdagendamento() == null){
			throw new Exception("O agendamento não possui Id");
		}
		else {
			LOG.info("Iniciando Service Agendamento: agendamentoproxy.save()");
			agendamentoDTO obj = agendamentoproxy.save(dto);
			LOG.info("Iniciando Service Agendamento: agendamentoproxy.save");
			return obj;
		}
	}
	
//	private agenda AgendamentomodelMapperOne(agendamentoDTO dto) {
//		exame obj = modalMapper.modelMapper().map(dto, exame.class);
//		return obj;
//	}
//	
//	private List<exame> AgendamentoModelMapperList(List<exameDTO> dto){	
//		  return dto.stream().map(obj -> PrestadormodelMapperOne(obj)).collect(Collectors.toList());
//	}
	
}
