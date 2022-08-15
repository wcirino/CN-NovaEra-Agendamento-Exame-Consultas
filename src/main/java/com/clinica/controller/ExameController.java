package com.clinica.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.clinica.dto.ExameDTO;
import com.clinica.dto.ExamePageDTO;
import com.clinica.service.ExameService;
import com.clinica.service.UtilService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;

@Api(value = "Exame", description = "Exame medicas", tags = {"Exame Medico EndPoint"})
@RestController
@RequestMapping(value = "/api-exame")
public class ExameController {

	@Autowired
	private ExameService proxyExame;
	
	@Autowired
	private UtilService utilservice;
	
	private static final Logger LOG = LoggerFactory.getLogger(ExameController.class);
	
	@ApiOperation(value = "Busca todos exames")
	@GetMapping(value = "/exame")
	public ResponseEntity<?> findAllExame() throws Exception{
		LOG.info("Iniciando  controller Exame Metodo: FindAll_Exame");
		List<ExameDTO> exame = proxyExame.findAll_Exame();
		LOG.info("Iniciando  controller agendamento Metodo: ");
		return new ResponseEntity<>(exame,HttpStatus.OK);
	}

	@ApiOperation(value = "Busca exame por id")
	@GetMapping(value = "/exame-id/{id}")
	public ResponseEntity<?> findIDExame(@PathVariable int id) throws Exception{
		LOG.info("Iniciando  controller Exame Metodo: Find_Exame_id");
		ExameDTO exame = proxyExame.find_Exame_id(id);
		LOG.info("Iniciando  controller agendamento Metodo: ");
		return new ResponseEntity<>(exame,HttpStatus.OK);
	}
	
	@ApiOperation(value = "inserir exame")
	@PostMapping(value = "/exame")
	public ResponseEntity<?> InsertExame(@RequestBody ExameDTO dto)throws Exception{
		LOG.info("Iniciando  controller Exame Metodo: Insert Exame");
		return new  ResponseEntity<>(proxyExame.InsertExame(dto),HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "alterar exame")
	@PutMapping(value = "/exame")
	public  ResponseEntity<?> Updateconsulta(@RequestBody ExameDTO dto) throws Exception{
		LOG.info("Iniciando  controller Exame Metodo: Update Exame");
		return new ResponseEntity<>(proxyExame.UpdateExame(dto),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Teste")
	@GetMapping(value = "/test")
	public ResponseEntity<?> sendhello() {
		return new ResponseEntity<>("Olá mundo Deu Certo, Eureka funcionando",HttpStatus.OK);
	}
	
	@ApiOperation(value ="Consulta paginada com beneficiario e sem id all")
	@GetMapping(value = "/exame-beneficiario-page/")
	public ResponseEntity<?> findBeneficiarioExameComIdDataSolicitacao_page(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam int id,
			@RequestParam String startdt,
			@RequestParam String enddt
	) throws Exception{
		
		String direction = "desc";
        Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
        LOG.info("exame paginada com beneficiario e seu id all");
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "codbenef"));
		
		Date startdtt = utilservice.ConvertDate(startdt);
		Date enddtt = utilservice.ConvertDate(enddt);
		
		ExamePageDTO consult = proxyExame.findBeneficiarioPageExameService(pageable, id, startdtt, enddtt);
		LOG.info("fim exame paginada com beneficiario e seu id all");
		return new ResponseEntity<>(consult,HttpStatus.OK);
	}
	
	@ApiOperation(value ="exame paginada com beneficiario e seu id all")
	@GetMapping(value = "/exame-beneficiario-dt-page/")
	public ResponseEntity<?> findBeneficiarioConsultaSemIdDataSolicitacao_page(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam String startdt,
			@RequestParam String enddt
	) throws Exception{
		
		String direction = "desc";
        Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
        LOG.info("exame paginada com beneficiario e sem id all");
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "codbenef"));
		
		Date startdtt = utilservice.ConvertDate(startdt);
		Date enddtt = utilservice.ConvertDate(enddt);
		
		ExamePageDTO consult = proxyExame.findBeneficiarioPageSemIdExameervice(pageable, startdtt, enddtt);
		LOG.info("fim Consulta paginada com beneficiario e sem id all");
		return new ResponseEntity<>(consult,HttpStatus.OK);
	}
}
