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
import com.clinica.dto.exameDTO;
import com.clinica.service.exameService;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;

//@Api(value = "Exame", description = "Exame medicas", tags = {"Exame Medico EndPoint"})
@RestController
@RequestMapping(value = "api-exame")
public class exameController {

	@Autowired
	private exameService proxyExame;
	
	//@ApiOperation(value = "Busca todos exames")
	@GetMapping(value = "/exame")
	public ResponseEntity<?> findAllExame() throws Exception{
		List<exameDTO> exame = proxyExame.findAll_Exame();
		return new ResponseEntity<>(exame,HttpStatus.OK);
	}

	//@ApiOperation(value = "Busca exame por id")
	@GetMapping(value = "/exame-id/{id}")
	public ResponseEntity<?> findIDExame(@PathVariable int id) throws Exception{
		exameDTO exame = proxyExame.find_Exame_id(id);
		return new ResponseEntity<>(exame,HttpStatus.OK);
	}
	
	//@ApiOperation(value = "inserir exame")
	@PostMapping(value = "/exame")
	public ResponseEntity<?> InsertExame(@RequestBody exameDTO dto)throws Exception{
		return new  ResponseEntity<>(proxyExame.InsertExame(dto),HttpStatus.CREATED);
	}
	
	//@ApiOperation(value = "alterar exame")
	@PutMapping(value = "/exame")
	public  ResponseEntity<?> Updateconsulta(@RequestBody exameDTO dto) throws Exception{
		return new ResponseEntity<>(proxyExame.UpdateExame(dto),HttpStatus.OK);
	}
}
