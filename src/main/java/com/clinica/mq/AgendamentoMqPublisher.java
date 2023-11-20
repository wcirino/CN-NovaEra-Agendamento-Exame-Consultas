package com.clinica.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clinica.config.MQConfig;
import com.clinica.dto.AgendamentoDTO;
import com.clinica.dto.AgendamentoMQ;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AgendamentoMqPublisher {

	private final RabbitTemplate rabbitTemplate;
	
	@Autowired
	private MQConfig mqserve;
	
	private static final Logger LOG = LoggerFactory.getLogger(ExameMqPublisher.class);
	
	public void envioAgendamento(AgendamentoDTO agenda)  throws JsonProcessingException{
		AgendamentoMQ agend = this.mapperAgendamento(agenda); 
		String json = this.convertIntoJson(agend);
		LOG.info("Enviando dados !!");
		LOG.info(mqserve.queueAgendamento().getName());
		LOG.info(json);
		rabbitTemplate.convertAndSend(mqserve.queueAgendamento().getName(),json);
		LOG.info("Enviado");
	}
	
	public  String convertIntoJson(AgendamentoMQ exame) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json  = mapper.writeValueAsString(exame);
		return json;
	}
	
	public AgendamentoMQ mapperAgendamento(AgendamentoDTO dto) {
		return AgendamentoMQ
				.builder()
				.idbenef(dto.getIdagendamento())
				.idagendamento(dto.getIdagendamento())
			    .idtipoagendamento(dto.getIdtipoagendamento().getIdtipoagendamento())
				.dataagendamento(dto.getDataconsulta())
				.build();
	}
	
}
