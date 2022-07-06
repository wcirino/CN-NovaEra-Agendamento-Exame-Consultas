package com.clinica.dto;

import java.io.Serializable;
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
@Table(name = "tipoexame")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoExameDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name = "idtipoexame")
	private Integer idtipoexame; 
	
	@Column(name = "nome_exame")
	private String nome_exame;

	@Column(name = "datainsert")
	private Date datainsert;
	
	@Column(name = "valor")
	private float valor;

}
