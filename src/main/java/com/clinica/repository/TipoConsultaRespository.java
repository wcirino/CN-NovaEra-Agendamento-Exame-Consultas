package com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.dto.TipoConsultaDTO;

public interface TipoConsultaRespository extends JpaRepository<TipoConsultaDTO,Integer>{

	TipoConsultaDTO findByidtipoconsulta(int id);
	TipoConsultaDTO save(int id);
	
}
