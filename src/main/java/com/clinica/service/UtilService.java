package com.clinica.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.clinica.dto.DadosParaEmailDTO;

@Service
public class UtilService {

	public static Date ConvertDate(String dt) throws Exception{
		
		//dt = dt.replaceAll("-", "/");
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd"); 
		Date d = format.parse(dt.replaceAll("-", "/"));
		
		return d;
	}
	public DadosParaEmailDTO dadosEmail(int id) {
		return DadosParaEmailDTO.builder().nome("Teste MicroService")
										  .assunto("Enviando algo clinica")
										  .carteirinha("0000000000000000000000000")
										  .date(null)
										  .email("Teste@teste.com")
										  .msg("Marcação de atendimento")
										  .tipoemail(id).build();
	}
}
