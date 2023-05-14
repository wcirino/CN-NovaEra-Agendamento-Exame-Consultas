package com.clinica.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.dto.ConsultaDTO;
import com.clinica.dto.ConsultaPageDTO;
import com.clinica.entity.consulta;
import com.clinica.service.ConsultasService;
import com.clinica.service.UtilService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Consultas", description = "Consultas medicas", tags = {"Consultas EndPoint"})
@RestController
@RequestMapping(value = "/api-consulta")
public class ConsultaController {

	@Autowired
	ConsultasService proxyConsult;
	
	@Autowired
	private UtilService utilService;
	
	private static final Logger LOG = LoggerFactory.getLogger(ConsultaController.class);
	
	@ApiOperation(value = "Busca todas as consultas")
	@GetMapping(value = "/consulta-all")
	public ResponseEntity<List<consulta>> findAllConsultas() throws Exception{
		LOG.info("iniciando metodo findAll");
		List<consulta> consult = proxyConsult.findAll_Consultas();
		LOG.info("Fim do metodo FindALL");
		return new ResponseEntity<>(consult,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Busca consulta por id")
	@GetMapping(value = "/consulta-id/{id}")
	public ResponseEntity<?> findIDConsultas(@PathVariable int id) throws Exception{
		LOG.info("Iniciando find com id");
		consulta consult = proxyConsult.findconsulta_id(id);
		LOG.info("Fim find id");
		return new ResponseEntity<>(consult,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Busca todas as consultas por data da consulta")
	@GetMapping(value = "/consulta-data-consulta/")
	public ResponseEntity<?> findDataone() throws Exception{
		LOG.info("Iniciando metodo");
		List<ConsultaDTO> consult = proxyConsult.find_Consultas_one_date();
		LOG.info("Fim do metodo");
		return new ResponseEntity<>(consult,HttpStatus.OK);
	}
	@ApiOperation(value = "Busca todas as consultas por data da solicitação")
	@GetMapping(value = "/consulta-data-solicitacao/")
	public ResponseEntity<?> findDataoneSolicitacao() throws Exception{
		LOG.info("Iniciando");
		List<ConsultaDTO> consult = proxyConsult.find_Consultas_one_date_solicitacao();
		LOG.info("Fim");
		return new ResponseEntity<>(consult,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Busca todas as consultas entre datas between")
	@GetMapping(value = "/consulta-data-between/{data1}/{data2}")
	public ResponseEntity<?> find_Consultas_between(@PathVariable String data1,@PathVariable String data2) throws Exception{
				
		Date d1 = proxyConsult.ConvertDate(data1);
		Date d2 = proxyConsult.ConvertDate(data2);
		LOG.info("Busca todas as consultas entre datas between");
		List<ConsultaDTO> consult = proxyConsult.find_Consultas_data(d1, d2);
		LOG.info("Fim Busca todas as consultas entre datas between");
		return new ResponseEntity<>(consult,HttpStatus.OK);
	}
	
	
	@ApiOperation(value ="Consulta paginada all")
	@GetMapping(value = "/consulta-all-page/")
	public ResponseEntity<?> findDataoneSolicitacao_page(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit
	) throws Exception{
		
		String direction = "desc";
        Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
        LOG.info("iniciando Consulta paginada all");
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "codbenef"));
		
		List<ConsultaDTO> consult = proxyConsult.findAll_Consultas(pageable);
		LOG.info("Fim Consulta paginada all");
		return new ResponseEntity<>(consult,HttpStatus.OK);
	}
	
	@ApiOperation(value ="Consulta paginada all sem lista com page")
	@GetMapping(value = "/consulta-all-page-/")
	public ResponseEntity<?> findConsulta_page(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit
	) throws Exception{
		
		String direction = "desc";
		Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		LOG.info("Consulta paginada all sem lista com page");
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "codbenef"));
		
		Page<ConsultaDTO> consult = proxyConsult.findAll_page_Consultas(pageable);
		LOG.info("fim Consulta paginada all sem lista com page");
		return new ResponseEntity<>(consult,HttpStatus.OK);
	}
	
	@ApiOperation(value ="Consulta paginada all sem lista com page(DTO)")
	@GetMapping(value = "/consulta-all-page-dto/")
	public ResponseEntity<?> findConsulta_page_dto(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit
	) throws Exception{
		
		String direction = "desc";
		Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		LOG.info("Inicio Consulta paginada all sem lista com page(DTO)");
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "codbenef"));
		
		ConsultaPageDTO consult = proxyConsult.findAll_page_Consultas_Service(pageable);
		LOG.info("fim Consulta paginada all sem lista com page(DTO)");
		return new ResponseEntity<>(consult,HttpStatus.OK);
	}
	
	@ApiOperation(value = "inserir consultas")
	@PostMapping(value = "/consulta")
	public ResponseEntity<?> InsertBeneficiario(@RequestBody ConsultaDTO dto)throws Exception{
		LOG.info("iniciando Insert consulta");
		return new  ResponseEntity<>(proxyConsult.InsertConsulta(dto),HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "alterar consulta")
	@PutMapping(value = "/consulta")
	public  ResponseEntity<?> Updateconsulta(@RequestBody ConsultaDTO dto) throws Exception{
		LOG.info("update da consulta");
		return new ResponseEntity<>(proxyConsult.UpdateConsultas(dto),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Alterar Status consulta")
	@PostMapping(value = "/consulta-status-consulta")
	public ResponseEntity<?> alterarStatusConsulta(@RequestBody ConsultaDTO dto)throws Exception{
		LOG.info("alterar status da consulta");
		return new  ResponseEntity<>(proxyConsult.AlterarStatusConsulta(dto),HttpStatus.CREATED);
	}
	
	@ApiOperation(value ="Consulta beneficiario paginado pelo id")
	@GetMapping(value = "/consulta-beneficiario-id-page/")
	public ResponseEntity<?> findBeneficiarioConsultaSolicitacao_page(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam int id
	) throws Exception{
		
		String direction = "desc";
        Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
        LOG.info("iniciando Consulta paginada all");
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "codbenef"));
		
		ConsultaPageDTO consult = proxyConsult.findBeneficiarioPageConsultasService(pageable,id);
		LOG.info("fim Consulta paginada all");
		return new ResponseEntity<>(consult,HttpStatus.OK);
	}
	
	@ApiOperation(value ="Consulta paginada com beneficiario e seu id all")
	@GetMapping(value = "/consulta-beneficiario-dt-page/")
	public ResponseEntity<?> findBeneficiarioConsultaComIdDataSolicitacao_page(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam int id,
			@RequestParam String startdt,
			@RequestParam String enddt
	) throws Exception{
		
		String direction = "desc";
        Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
        LOG.info("Consulta paginada com beneficiario e seu id all");
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "codbenef"));
		
		Date startdtt = utilService.ConvertDate(startdt);
		Date enddtt = utilService.ConvertDate(enddt);
		
		ConsultaPageDTO consult = proxyConsult.findBeneficiarioPageConsultasComIDService(pageable, id, startdtt, enddtt);
		LOG.info("fim Consulta paginada com beneficiario e seu id all");
		return new ResponseEntity<>(consult,HttpStatus.OK);
	}
	
}
