package com.clinica.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExamePageDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<ExameDTO> lista_consulta;
	private long totalElements;
	private long totalPages;
	private long size;
	private long pageNumber;	
	
}
