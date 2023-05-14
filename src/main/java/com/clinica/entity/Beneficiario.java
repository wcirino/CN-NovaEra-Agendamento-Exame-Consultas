package com.clinica.entity;

import com.clinica.dto.enums.Ativo;
import com.clinica.dto.enums.Sexo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Beneficiario {

	private int idbenef;
	private String nome_comp;
	private String cpfcnpj;
	private String RG;
	private int idestado;
	private Integer cidade;
	private String celular;
	private String carteirinha;
	private Sexo sexo;
	private Ativo ativo;

}
