package com.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.dto.tipoagendamentoDTO;
import com.clinica.service.tipoagendamentoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "TipoAgendamento", description = "TipoAgendamentos medicos", tags = {"Tipo Agendamentos Medicos EndPoint"})
@RestController
@RequestMapping(value = "/api-tipoagendamento")
public class tipoagendamentoController {
	
	@Autowired
	private tipoagendamentoService tipoAgendamentoproxy;
	
	@ApiOperation(value = "Busca todos TipoAgendamento")
	@GetMapping(value = "/tipo-agendamento")
	public ResponseEntity<?> findAllExame() throws Exception{
		List<tipoagendamentoDTO> tpagenda = tipoAgendamentoproxy.findAll_TipoAgendamento();
		return new ResponseEntity<>(tpagenda,HttpStatus.OK);
	}

	@ApiOperation(value = "Busca  Tipoagendamento")
	@GetMapping(value = "/tipo-tipoagendamento-id/{id}")
	public ResponseEntity<?> findIDExame(@PathVariable int id) throws Exception{
		tipoagendamentoDTO tpagenda = tipoAgendamentoproxy.find_tipoAgendamento_id(id);
		return new ResponseEntity<>(tpagenda,HttpStatus.OK);
	}

}
