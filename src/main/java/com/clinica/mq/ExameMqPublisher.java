package com.clinica.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clinica.config.MQConfig;
import com.clinica.dto.ExameDTO;
import com.clinica.dto.ExameMQ;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ExameMqPublisher {

	private final RabbitTemplate rabbitTemplate;
	
	@Autowired
	private MQConfig mqserve;
	
	private static final Logger LOG = LoggerFactory.getLogger(ExameMqPublisher.class);
	
	public void envioExame(ExameDTO exame)  throws JsonProcessingException{
		ExameMQ exam = this.mapperExame(exame); 
		String json = this.convertIntoJson(exam);
		LOG.info("Enviando dados !!");
		LOG.info(mqserve.queueConsulta().getName());
		LOG.info(json);
		rabbitTemplate.convertAndSend(mqserve.queueConsulta().getName(),json);
		LOG.info("Enviado");
	}
	
	public  String convertIntoJson(ExameMQ exame) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json  = mapper.writeValueAsString(exame);
		return json;
	}
	
	public ExameMQ mapperExame(ExameDTO dto) {
		return ExameMQ
				.builder()
				.idbenef(dto.getCodbenef())
				.idexame(dto.getIdexame())
			    .idtipoexame(dto.getIdtipoexame().getIdtipoexame())
				.dataconsulta(dto.getDataconsulta())
				.build();
	}
	
}
