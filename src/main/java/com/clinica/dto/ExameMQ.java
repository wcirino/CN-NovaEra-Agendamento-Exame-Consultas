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
public class ExameMQ {

	Integer id ;
	Integer idexame;
	Integer idtipoexame;
	Integer idbenef;
	Date dataexame;
	
}
