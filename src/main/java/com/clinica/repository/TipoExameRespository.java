package com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.clinica.dto.TipoExameDTO;

@Repository
public interface TipoExameRespository extends JpaRepository<TipoExameDTO, Integer> {

	TipoExameDTO findByidtipoexame(int id);
	TipoExameDTO save(int id);
	
}
