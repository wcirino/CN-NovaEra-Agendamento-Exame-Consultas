package com.clinica.entity;

import com.clinica.dto.enums.SexoPrestador;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Prestador {

	private int idPrest;
	private String nome;
	private SexoPrestador sexo;
	
}
