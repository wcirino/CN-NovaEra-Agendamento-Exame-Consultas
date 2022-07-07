package com.clinica.dto;

import java.util.List;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsultaPageDTO {

	private static final long serialVersionUID = 1L;
	private List<ConsultaDTO> lista_consulta;
	private long totalElements;
	private long totalPages;
	private long size;
	private long pageNumber;	
	
}
