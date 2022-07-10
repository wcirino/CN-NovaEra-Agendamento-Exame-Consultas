package com.clinica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.dto.PrestadorDTO;
import com.clinica.repository.PrestadorRepository;

@Service
public class PrestadorService {

	@Autowired
	PrestadorRepository prestProxy;
		
	public List<PrestadorDTO> findAll_Prestador() throws Exception{
		Optional<List<PrestadorDTO>> obj = Optional.ofNullable(prestProxy.findAll());
		return obj.orElseThrow(() -> new Exception());
	}
		
	public List<PrestadorDTO> find_prestador_id(int id) throws Exception{
		Optional<List<PrestadorDTO>> obj = Optional.ofNullable(prestProxy.findByidPrest(id));
		return obj.orElseThrow(() -> new Exception());
	}
}
