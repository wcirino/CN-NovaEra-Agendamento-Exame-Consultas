package com.clinica.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "consultas")
public class ConsultaDTO {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name = "idconsulta")
	private Integer idconsulta;
	
	@OneToOne(cascade = CascadeType.DETACH) 
	@JoinColumn(name = "codprestador", referencedColumnName="id_prest")
	private PrestadorDTO codprestador;
	
	@OneToOne(cascade = CascadeType.DETACH) 
	@JoinColumn(name = "codbenef", referencedColumnName="codbenef")
	private BeneficiarioDTO codbenef;
	
	@Column(name = "dataconsulta")
	private Date dataconsulta;
	
	@Column(name = "datasolicitacao")
	private Date datasolicitacao;
	
	@OneToOne(cascade = CascadeType.DETACH) 
	@JoinColumn(name = "tipoconsulta", referencedColumnName="idtipoconsulta")
	private TipoConsultaDTO tipoconsulta;
	
	@Column(name = "statusConsulta")
	private  String status;
	
}
