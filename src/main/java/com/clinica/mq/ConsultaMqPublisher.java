package com.clinica.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clinica.config.MQConfig;
import com.clinica.dto.ConsultaDTO;
import com.clinica.dto.ConsultaMQ;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ConsultaMqPublisher {

	private final RabbitTemplate rabbitTemplate;
	
	@Autowired
	private MQConfig mqserve;
	
	private static final Logger LOG = LoggerFactory.getLogger(ConsultaMqPublisher.class);
	
	public void envioConsulta(ConsultaDTO consulta)  throws JsonProcessingException{
		ConsultaMQ consult = this.mapperConsulta(consulta); 
		String json = this.convertIntoJson(consult);
		LOG.info("Enviando dados !!");
		LOG.info(mqserve.queueConsulta().getName());
		LOG.info(json);
		rabbitTemplate.convertAndSend(mqserve.queueConsulta().getName(),json);
		LOG.info("Enviado");
	}
	
	public  String convertIntoJson(ConsultaMQ consulta) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json  = mapper.writeValueAsString(consulta);
		return json;
	}
	
	public ConsultaMQ mapperConsulta(ConsultaDTO dto) {
		return ConsultaMQ
				.builder()
				.idbenef(dto.getCodbenef().getIdbenef())
				.idconsulta(dto.getIdconsulta())
				.idtipoconsulta(dto.getTipoconsulta().getIdtipoconsulta())
				.dataconsulta(dto.getDataconsulta())
				.build();
	}
}
