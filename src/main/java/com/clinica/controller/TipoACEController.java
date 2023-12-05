package com.clinica.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.dto.TipoExameDTO;
import com.clinica.repository.TipoConsultaRespository;
import com.clinica.service.TipoExameService;

@RestController
@RequestMapping(value = "/api-tipoExame")
public class TipoACEController {

	@Autowired
	private TipoExameService proxytipoexame;
	
	@Autowired
	private TipoConsultaRespository proxytipoconsulta;

	private static final Logger LOG = LoggerFactory.getLogger(TipoACEController.class);
	
	@GetMapping(value = "/tipo-exame")
	public ResponseEntity<?> findAllExame() throws Exception{
		LOG.info("Iniciando  controller tipoExameController Metodo: findAll_TipoExame");
		List<TipoExameDTO> exame = proxytipoexame.findAll_TipoExame();
		LOG.info("Iniciando  controller tipoExameController Metodo: findAll_TipoExame");
		return new ResponseEntity<>(exame,HttpStatus.OK);
	}

	
	@GetMapping(value = "/tipo-consulta")
	public  ResponseEntity<?> findallconsulta(){
		return new ResponseEntity<>(proxytipoconsulta.findAll() ,HttpStatus.OK);
	}
	
}
