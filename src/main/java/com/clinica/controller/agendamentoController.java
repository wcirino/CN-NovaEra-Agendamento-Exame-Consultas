package com.clinica.controller;

import java.util.List;

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

import com.clinica.dto.agendamentoDTO;
import com.clinica.service.agendamentoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Agendamento", description = "agendamentos medicos", tags = {"Agendamentos Medicos EndPoint"})
@RestController
@RequestMapping(value ="api-agendamento")
public class agendamentoController {

	@Autowired
	private agendamentoService agendamentoProxy;
	
	@ApiOperation(value = "Busca todos agendamento")
	@GetMapping(value = "/agendamento")
	public ResponseEntity<?> findAllExame() throws Exception{
		List<agendamentoDTO> agendamento = agendamentoProxy.findAll_agendamento();
		return new ResponseEntity<>(agendamento,HttpStatus.OK);
	}

	@ApiOperation(value = "Busca agendamento por id")
	@GetMapping(value = "/agendamento-id/{id}")
	public ResponseEntity<?> findIDExame(@PathVariable int id) throws Exception{
		agendamentoDTO agendamento = agendamentoProxy.find_Agendamento_id(id);
		return new ResponseEntity<>(agendamento,HttpStatus.OK);
	}
	
	@ApiOperation(value = "inserir agendamento")
	@PostMapping(value = "/agendamento")
	public ResponseEntity<?> InsertExame(@RequestBody agendamentoDTO dto)throws Exception{
		return new  ResponseEntity<>(agendamentoProxy.Insertagendamento(dto),HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "alterar agendamento")
	@PutMapping(value = "/agendamento")
	public  ResponseEntity<?> Updateconsulta(@RequestBody agendamentoDTO dto) throws Exception{
		return new ResponseEntity<>(agendamentoProxy.Updategendamento(dto),HttpStatus.OK);
	}
	
}
