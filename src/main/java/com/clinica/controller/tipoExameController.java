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

import com.clinica.dto.tipoExameDTO;
import com.clinica.service.tipoExameService;

@RestController
@RequestMapping(value = "/api-tipoExame")
public class tipoExameController {

	@Autowired
	private tipoExameService proxytipoexame;
	
	private static final Logger LOG = LoggerFactory.getLogger(tipoExameController.class);
	
	@GetMapping(value = "/tipo-exame")
	public ResponseEntity<?> findAllExame() throws Exception{
		LOG.info("Iniciando  controller tipoExameController Metodo: findAll_TipoExame");
		List<tipoExameDTO> exame = proxytipoexame.findAll_TipoExame();
		LOG.info("Iniciando  controller tipoExameController Metodo: findAll_TipoExame");
		return new ResponseEntity<>(exame,HttpStatus.OK);
	}

	@GetMapping(value = "/tipo-exame-id/{id}")
	public ResponseEntity<?> findIDExame(@PathVariable int id) throws Exception{
		LOG.info("Iniciando  controller tipoExameController Metodo: findAll_TipoExame");
		tipoExameDTO exame = proxytipoexame.find_tipoExame_id(id);
		LOG.info("Iniciando  controller tipoExameController Metodo: findAll_TipoExame");
		return new ResponseEntity<>(exame,HttpStatus.OK);
	}
	
	@PostMapping(value = "/tipo-exame")
	public ResponseEntity<?> InsertExame(@RequestBody tipoExameDTO dto)throws Exception{
		LOG.info("Iniciando  controller tipoExameController Metodo: findAll_TipoExame");
		return new  ResponseEntity<>(proxytipoexame.InsertExame(dto),HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/tipo-exame")
	public  ResponseEntity<?> UpdateExame(@RequestBody tipoExameDTO dto) throws Exception{
		LOG.info("Iniciando  controller tipoExameController Metodo: findAll_TipoExame");
		return new ResponseEntity<>(proxytipoexame.UpdateExame(dto),HttpStatus.OK);
	}
	
}
