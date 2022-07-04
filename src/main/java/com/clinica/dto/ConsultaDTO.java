package com.clinica.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="consultas")
public class ConsultaDTO {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name = "idconsulta")
	private int idconsulta;
	
	@Column(name = "codprestador")
	private int codprestador;
	

	@Column(name = "codbenef")
	private int codbenef;
	
	@Column(name = "dataconsulta")
	private Date dataconsulta;
	
	@Column(name = "datasolicitacao")
	private Date datasolicitacao;
	
	@Column(name = "tipoconsulta")
	private int tipoconsulta;
	
	@Column(name = "statusConsulta")
	private String status;
	
}
