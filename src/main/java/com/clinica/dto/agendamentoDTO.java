package com.clinica.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "agendamento")
@Entity
public class agendamentoDTO {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name = "idagendamento")
	private int idagendamento;
	
	@Column(name = "idtipoagendamento")
	private int idtipoagendamento;
	
	@Column(name = "idprestador")
	private int idprestador;
	
	@Column(name = "idbenef")
	private int idbenef;
	
	@Column(name = "datasolicitacao")
	private Date datasolicitacao;
	
	@Column(name = "dataconsulta")
	private Date dataconsulta;
	
	@Column(name = "statusAgendamento")
	private String statusAgendamento;
	
}
