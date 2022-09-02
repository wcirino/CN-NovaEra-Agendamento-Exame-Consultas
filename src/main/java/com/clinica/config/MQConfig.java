package com.clinica.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

	@Value("${mq.queues.cn-consulta}")
	private String ConsultaFila;
	
	@Value("${mq.queues.cn-exame}")
	private String ExameFila;
	
	@Value("${mq.queues.cn-agendamento}")
	private String AgendamentoFila;
	
	@Bean
	public Queue queueConsulta() {
		return new Queue(ConsultaFila,true);
	}
	
	@Bean
	public Queue queueExame() {
		return new Queue(ExameFila,true);
	}
	
	@Bean
	public Queue queueAgendamento() {
		return new Queue(AgendamentoFila,true);
	}
	
}
