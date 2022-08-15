package com.clinica.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosParaEmailDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String carteirinha;
	private String email;
	private Date date;
	private String assunto;
	private String msg;
	private int tipoemail;
	
}