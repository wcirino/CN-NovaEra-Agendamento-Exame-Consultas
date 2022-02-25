package com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.clinica.dto.tipoExameDTO;

@Repository
public interface tipoExameRespository extends JpaRepository<tipoExameDTO, Integer> {

	tipoExameDTO findByidtipoexame(int id);
	tipoExameDTO save(int id);
	
}
