package com.clinica.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.clinica.dto.BeneficiarioDTO;
import com.clinica.service.BeneficiarioService;

@Component
public class BeneficiarioMqSubscriber {

	@Autowired
	private BeneficiarioService service;
	
	private static final Logger LOG = LoggerFactory.getLogger(BeneficiarioMqSubscriber.class);
	
	
	@RabbitListener(queues = "${mq.queues.cn-beneficiario}")
	public void recebendoBeneficiario(@Payload String payload) throws Exception {
		LOG.info("recebendo dados dados beneficiario!!");
		ObjectMapper mapper = new ObjectMapper();
		//ConsultaDTO dados = mapper.readValue(payload, ConsultaDTO.class);
		BeneficiarioDTO dados = mapper.readValue(payload, BeneficiarioDTO.class);
		service.insertBenef(dados);
		LOG.info(dados.toString());
	}
	
	@RabbitListener(queues = "${mq.queues.cn-beneficiario-alter}")
	public void recebendoBeneficiarioAlter(@Payload String payload) throws Exception {
		LOG.info("recebendo dados dados beneficiario-alter!!");
		ObjectMapper mapper = new ObjectMapper();
		//ConsultaDTO dados = mapper.readValue(payload, ConsultaDTO.class);
		BeneficiarioDTO dados = mapper.readValue(payload, BeneficiarioDTO.class);
		service.UpdateBenef(dados);
		LOG.info(dados.toString());
	}
	
}
