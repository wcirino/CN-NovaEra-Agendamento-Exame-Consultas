package com.clinica.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "exame")
public class exameDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name = "idexame")
	private int idexame; 
	
	@OneToOne(cascade = CascadeType.REMOVE) 
	@JoinColumn(name = "idtipoexame", referencedColumnName="idtipoexame")
	private tipoExameDTO idtipoexame;
	
	@Column(name = "idprestador")
	private int idprestador; 
	
	@Column(name = "idatasolicitacao")
	private Date idatasolicitacao; 
	
	@Column(name = "dataconsulta")
	private Date dataconsulta;

	
}
