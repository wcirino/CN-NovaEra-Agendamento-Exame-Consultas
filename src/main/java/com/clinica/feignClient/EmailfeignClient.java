package com.clinica.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.clinica.dto.DadosParaEmailDTO;

@Component
@FeignClient(contextId = "email", value = "cn-eml", path ="/api-enviando")
public interface EmailfeignClient {

	@PostMapping(value = "/enviar-email-mock")
	public ResponseEntity<String> sendMailMock(@RequestBody DadosParaEmailDTO obj);
	
	
}
