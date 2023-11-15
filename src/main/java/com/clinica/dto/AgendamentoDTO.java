package com.clinica.dto;

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
@Table(name = "agendamento")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgendamentoDTO {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name = "idagendamento")
	private Integer idagendamento;
	
	@OneToOne(cascade = CascadeType.REMOVE) 
	@JoinColumn(name = "idtipoagendamento", referencedColumnName="idtipoagendamento")
	private TipoAgendamentoDTO idtipoagendamento;
	
	@OneToOne(cascade = CascadeType.REMOVE) 
	@JoinColumn(name = "idprestador", referencedColumnName="id_prest")
	private PrestadorDTO prestador;
	
	@OneToOne(cascade = CascadeType.REMOVE) 
	@JoinColumn(name = "idbenef", referencedColumnName="idbenef")
	private BeneficiarioDTO idbenef;
	
	@Column(name = "datasolicitacao")
	private Date datasolicitacao;
	
	@Column(name = "dataconsulta")
	private Date dataconsulta;
	
	@Column(name = "statusAgendamento")
	private String statusAgendamento;
	
}
