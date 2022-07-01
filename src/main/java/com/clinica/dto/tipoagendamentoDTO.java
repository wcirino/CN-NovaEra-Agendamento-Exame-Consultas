package com.clinica.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "tipoagendamento")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class tipoagendamentoDTO {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name = "idtipoagendamento")
	private Integer idtipoagendamento; 
	
	@Column(name = "nomeagendamento")
	private String nomeagendamento;
	
	@Column(name = "datacriacao")
	private Date datacriacao;
	
	@Column(name = "statusAgendamento")
	private String statusAgendamento;
	
	@Column(name = "valor")
	private float valor;
	
	@Column(name = "tipo")
	private int tipo;
		
}
