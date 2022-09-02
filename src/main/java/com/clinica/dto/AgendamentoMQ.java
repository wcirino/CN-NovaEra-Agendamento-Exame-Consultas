package com.clinica.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgendamentoMQ {

	Integer id ;
	Integer idagendamento;
	Integer idtipoagendamento;
	Integer idbenef;
	Date dataconsulta;
	
}
