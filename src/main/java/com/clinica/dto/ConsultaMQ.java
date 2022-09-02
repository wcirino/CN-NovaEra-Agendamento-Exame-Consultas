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
public class ConsultaMQ {

	Integer id ;
	Integer idconsulta;
	Integer idtipoconsulta;
	Integer idbenef;
	Date dataconsulta;
	
}