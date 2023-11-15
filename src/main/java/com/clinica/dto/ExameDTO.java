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
import javax.persistence.OneToOne;
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
@Table(name = "exame")
public class ExameDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name = "idexame")
	private Integer idexame;
	
	@OneToOne(cascade = CascadeType.REMOVE) 
	@JoinColumn(name = "idtipoexame", referencedColumnName="idtipoexame")
	private TipoExameDTO idtipoexame;
	
	@OneToOne(cascade = CascadeType.REMOVE) 
	@JoinColumn(name = "idprestador", referencedColumnName="id_prest")
	private PrestadorDTO idprestador;
	
	@OneToOne(cascade = CascadeType.REMOVE) 
	@JoinColumn(name = "idbenef", referencedColumnName="idbenef")
	private BeneficiarioDTO idbenef;
		
	@Column(name = "datasolicitacao")
	private Date datasolicitacao; 
	
	@Column(name = "dataconsulta")
	private Date dataconsulta;
	
	@Column(name = "statusexame")
	private String statusexame;

	
}
