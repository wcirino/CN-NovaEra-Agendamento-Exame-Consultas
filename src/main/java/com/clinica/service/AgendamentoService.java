package com.clinica.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.clinica.dto.AgendamentoDTO;
import com.clinica.dto.AgendamentoPageDTO;
import com.clinica.repository.AgendamentoRepository;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoproxy;
	
	private static final Logger LOG = LoggerFactory.getLogger(AgendamentoService.class);
	
	@Autowired 
	private EmailService emailservice;
	
	@Autowired
	private UtilService utilService;
	
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
			try {
				emailservice.EnviarEmail(utilService.dadosEmail(1));
			}catch (Exception e) {
				// TODO: handle exception
			}finally {
				if(obj != null)
					return obj;
			}
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
	
	public AgendamentoPageDTO findBeneficiarioPageExameService(Pageable pageble,int id,Date startdt,Date enddt) throws Exception {
		LOG.info("iniciando findAll_page_Consultas_Service()");
		Optional<Page<AgendamentoDTO>> obj = Optional.ofNullable(agendamentoproxy.findBeneficiarioagendamentoPage(id,startdt, enddt,pageble));
		obj.orElseThrow(() -> new Exception());
		AgendamentoPageDTO dto = new AgendamentoPageDTO(obj.get().getContent(), obj.get().getTotalElements(),
												  obj.get().getTotalPages(), obj.get().getSize(),
												  obj.get().getNumberOfElements());
		LOG.info("Fim do metodo findAll_page_Consultas_Service");
		return dto;
	}
	
	public AgendamentoPageDTO findBeneficiarioPageSemIdExameervice(Pageable pageble,Date startdt,Date enddt) throws Exception {
		LOG.info("iniciando findAll_page_Consultas_Service()");
		Optional<Page<AgendamentoDTO>> obj = Optional.ofNullable(agendamentoproxy.findBeneficiarioagendamentoSemIDPage(startdt, enddt,pageble));
		obj.orElseThrow(() -> new Exception());
		AgendamentoPageDTO dto = new AgendamentoPageDTO(obj.get().getContent(), obj.get().getTotalElements(),
												  obj.get().getTotalPages(), obj.get().getSize(),
												  obj.get().getNumberOfElements());
		LOG.info("Fim do metodo findAll_page_Consultas_Service");
		return dto;
	}
}
