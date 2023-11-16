package com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.dto.TipoConsultaDTO;

@Repository
public interface TipoConsultaRespository extends JpaRepository<TipoConsultaDTO,Integer>{

	TipoConsultaDTO findByidtipoconsulta(int id);
	TipoConsultaDTO save(int id);
	
}
