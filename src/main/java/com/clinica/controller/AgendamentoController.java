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

import com.clinica.dto.AgendamentoDTO;
import com.clinica.service.AgendamentoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Agendamento", description = "agendamentos medicos", tags = {"Agendamentos Medicos EndPoint"})
@RestController
@RequestMapping(value ="/api-agendamento")
public class AgendamentoController {

	@Autowired
	private AgendamentoService agendamentoProxy;
	
	private static final Logger LOG = LoggerFactory.getLogger(AgendamentoController.class);
	
	@ApiOperation(value = "Busca todos agendamento")
	@GetMapping(value = "/agendamento-all")
	public ResponseEntity<?> findAllAgendamento() throws Exception{
		LOG.info("Iniciando  controller agendamento Metodo: findAll_agendamento");
		List<AgendamentoDTO> agendamento = agendamentoProxy.findAll_agendamento();
		LOG.info("Fim da chamada endpoint agendamento  : FindAll_agendamento");
		return new ResponseEntity<>(agendamento,HttpStatus.OK);
	}

	@ApiOperation(value = "Busca agendamento por id")
	@GetMapping(value = "/agendamento-id/{id}")
	public ResponseEntity<?> findIDAgendamento(@PathVariable int id) throws Exception{
		LOG.info("Iniciando  controller agendamento Metodo: findID ");
		AgendamentoDTO agendamento = agendamentoProxy.find_Agendamento_id(id);
		LOG.info("Iniciando  controller agendamento Metodo: ");
		return new ResponseEntity<>(agendamento,HttpStatus.OK);
	}
	
	@ApiOperation(value = "inserir agendamento")
	@PostMapping(value = "/agendamento")
	public ResponseEntity<?> InsertAgendamento(@RequestBody AgendamentoDTO dto)throws Exception{
		LOG.info("Iniciando  controller agendamento Metodo: inseriragendamento");
		return new  ResponseEntity<>(agendamentoProxy.Insertagendamento(dto),HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "alterar agendamento")
	@PutMapping(value = "/agendamento")
	public  ResponseEntity<?> Updateconsulta(@RequestBody AgendamentoDTO dto) throws Exception{
		LOG.info("Iniciando  controller agendamento Metodo: Updateagendamento");
		return new ResponseEntity<>(agendamentoProxy.Updategendamento(dto),HttpStatus.OK);
	}
	
}
