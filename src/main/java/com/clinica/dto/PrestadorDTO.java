package com.clinica.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.clinica.dto.enums.Sexo;
import com.clinica.dto.enums.SexoPrestador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="prestador")
public class PrestadorDTO {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_prest")
	private int idPrest;
	
	@Column(name = "codprest")
	private String nome;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "sexo")
	private SexoPrestador sexo;
		
	@Column(name = "cidade")
	private int cidade;
	
	@Column(name = "estados")
	private int estados;
	
	@Column(name = "statusPrest")
	private String statusPrest;	
}
