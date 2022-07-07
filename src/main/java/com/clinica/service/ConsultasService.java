package com.clinica.service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.clinica.dto.ConsultaDTO;
import com.clinica.dto.ConsultaPageDTO;
import com.clinica.repository.ConsultasRepository;


@Service
public class ConsultasService {

	@Autowired
	private ConsultasRepository consulProxy;
	
	private static final Logger LOG = LoggerFactory.getLogger(ConsultasService.class);

	public List<ConsultaDTO> findAll_Consultas() throws Exception{
		LOG.info("Iniciando findAll_Consultas()");
		Optional<List<ConsultaDTO>> obj = Optional.ofNullable(consulProxy.findAll());
		LOG.info("Fim findAll_Consultas");
		return obj.orElseThrow(() -> new Exception());
	}
		
	
	public ConsultaDTO findconsulta_id(int id) throws Exception{
		LOG.info("Iniciando findconsulta_id()");
		ConsultaDTO c = consulProxy.findByIdconsulta(id);
		Optional<ConsultaDTO> obj = Optional.ofNullable(consulProxy.findByIdconsulta(id));
		LOG.info("Fim findconsulta_id()");
		return obj.orElseThrow(() -> new Exception());
	}
	
	
	public List<ConsultaDTO> find_Consultas_data(Date dt1, Date dt2) throws Exception{
		LOG.info("Iniciando find_Consultas_data()");
		Optional<List<ConsultaDTO>> obj = Optional.ofNullable(consulProxy.findBydataconsultaBetween(dt1, dt2));
		LOG.info("Fim find_Consultas_data()");
		return obj.orElseThrow(() -> new Exception());
	}
	
	public List<ConsultaDTO> find_Consultas_one_date_solicitacao() throws Exception{
		LOG.info("Iniciando find_Consultas_one_date_solicitacao");
		Optional<List<ConsultaDTO>> obj = Optional.ofNullable(consulProxy.BuscaPorDataSolicitacao());
		LOG.info("Fim find_Consultas_one_date_solicitacao");
		return obj.orElseThrow(() -> new Exception());
	}
	
	public List<ConsultaDTO> find_Consultas_one_date() throws Exception{
		LOG.info("Iniciando find_Consultas_one_date()");
		Optional<List<ConsultaDTO>> obj = Optional.ofNullable(consulProxy.BuscaPorData());
		LOG.info("Fim find_Consultas_one_date()");
		return obj.orElseThrow(() -> new Exception());
	}
		
			
	public ConsultaDTO InsertConsulta(ConsultaDTO dto) throws Exception{
		LOG.info("iniciando InsertConsulta()");
		if(dto == null || dto.getIdconsulta() != null ) {
			LOG.info("Inserindo consulta ");
			ConsultaDTO obj = consulProxy.save(dto);
			LOG.info("Fim InsertConsulta()");
			return obj;
		}
		else {
			throw new Exception("A Consulta possui Id");
		}
	}
	
	public ConsultaDTO UpdateConsultas(ConsultaDTO dto) throws Exception{
		LOG.info("Iniciando UpdateConsultas");
		if(dto == null || dto.getIdconsulta() == null) {
			LOG.info("...UpdateConsultas");
			ConsultaDTO obj = consulProxy.save(dto);
			LOG.info("... fim UpdateConsultas");
			return obj;
		}
		else {
			throw new Exception(""
					+ "A consulta não possui Id");
		}
	}
	
	public Date ConvertDate(String dt) throws Exception{
		
		dt = dt.replaceAll("-", "/");
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd"); 
		Date d = format.parse(dt);
		
		return d;
	}

	public ConsultaPageDTO findAll_page_Consultas_Service(Pageable pageble) throws Exception {
		LOG.info("iniciando findAll_page_Consultas_Service()");
		Optional<Page<ConsultaDTO>> obj = Optional.ofNullable(consulProxy.findAll(pageble));
		obj.orElseThrow(() -> new Exception());
		ConsultaPageDTO dto = new ConsultaPageDTO(obj.get().getContent(), obj.get().getTotalElements(),
												  obj.get().getTotalPages(), obj.get().getSize(),
												  obj.get().getNumberOfElements());
		LOG.info("Fim do metodo findAll_page_Consultas_Service");
		return dto;
	}
	
	public Page<ConsultaDTO> findAll_page_Consultas(Pageable pageble) throws Exception {
		LOG.info("iniciando findAll_page_Consultas()");
		findAll_page_Consultas_Service(pageble);
		Optional<Page<ConsultaDTO>> obj = Optional.ofNullable(consulProxy.findAll(pageble));
		LOG.info("Fim findAll_page_Consultas()");
		return obj.orElseThrow(() -> new Exception());
	}
	
	public List<ConsultaDTO> findAll_Consultas(Pageable pageble) throws Exception {
		LOG.info("inciando findAll_Consultas()");
		Optional<List<ConsultaDTO>> obj = Optional.ofNullable(consulProxy.findAll(pageble).getContent());
		LOG.info("Fim findAll_Consultas()");
		return obj.orElseThrow(() -> new Exception());
	}
	
	public String AlterarStatusConsulta(ConsultaDTO dto) throws Exception {
		LOG.info("Iniciando AlterarStatusConsulta");
		consulProxy.DesativarPrestador(dto.getStatus(),dto.getIdconsulta());
		LOG.info("Fim AlterarStatusConsulta");
		return "ok";
	}
	
}
