package com.clinica.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.clinica.dto.enums.Ativo;
import com.clinica.dto.enums.Sexo;

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
	private Integer idbenef;
	
	@NotNull
	@Column(name = "codbenef")
	private Integer codbenef;
		
	@NotBlank
	@Column(name = "nome_comp")
	private String nome_comp;

	@Size(min = 11, max = 20)
	@NotBlank
	@Column(name = "cpfcnpj")
	private String cpfcnpj;

	@Size(min = 11, max = 20)
	@NotBlank
	@Column(name = "RG")
	private String RG;

	@Column(name = "data_nasc")
	private Date data_nasc;

	@Column(name = "idestado")
	private int idestado;

	@Column(name = "cidade")
	private Integer cidade;

	@Size(max = 15)
	@Column(name = "telefone")
	private String telefone;

	@Size(max = 15)
	@Column(name = "celular")
	private String celular;
	
	@Column(name = "carteirinha")
	private String carteirinha;
	
	@Column(name="data_cadas")
	private Date data_cadas;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="sexo")
	private Sexo sexo;
	
	@Column(name="ativo")
	private Ativo ativo;
		
}
