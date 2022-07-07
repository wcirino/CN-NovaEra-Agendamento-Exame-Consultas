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
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "consultas")
public class ConsultaDTO {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name = "idconsulta")
	private Integer idconsulta;
	
	@Column(name = "codprestador")
	private Integer codprestador;
	

	@Column(name = "codbenef")
	private Integer codbenef;
	
	@Column(name = "dataconsulta")
	private Date dataconsulta;
	
	@Column(name = "datasolicitacao")
	private Date datasolicitacao;
	
	@Column(name = "tipoconsulta")
	private Integer tipoconsulta;
	
	@Column(name = "statusConsulta")
	private String status;
	
}
