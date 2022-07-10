package com.clinica.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private int idPrest;
	
	@Column(name = "codprest")
	private String nome;
	
	@Column(name = "sexo")
	private int sexo;
		
	@Column(name = "cidade")
	private int cidade;
	
	@Column(name = "estados")
	private int estados;
	
	@Column(name = "statusPrest")
	private String statusPrest;	
}
