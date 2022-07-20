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
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "beneficiario")
public class BeneficiarioDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name = "idbenef")
	private int idbenef;
		
	@Column(name = "nome_comp")
	private String nome_comp;

	@Column(name = "cpfcnpj")
	private String cpfcnpj;

	@Column(name = "RG")
	private String RG;

	@Column(name = "data_nasc")
	private Date data_nasc;

	@Column(name = "idestado")
	private int idestado;

	@Column(name = "cidade")
	private Integer cidade;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "celular")
	private String celular;
	
	@Column(name = "carteirinha")
	private String carteirinha;
	
	@Column(name="data_cadas")
	private Date data_cadas;
	
	@Column(name="sexo")
	private int sexo;
	
	@Column(name="ativo")
	private String ativo;
		
}
