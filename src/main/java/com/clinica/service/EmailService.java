package com.clinica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.dto.DadosParaEmailDTO;
import com.clinica.feignClient.EmailfeignClient;

@Service
public class EmailService {

	@Autowired
	private EmailfeignClient service;
	
	public String EnviarEmail(DadosParaEmailDTO dto) throws Exception {
		return service.sendMailMock(dto).getBody();
	}
	
}
