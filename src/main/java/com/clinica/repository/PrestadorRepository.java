package com.clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.dto.PrestadorDTO;

@Repository
public interface PrestadorRepository extends JpaRepository<PrestadorDTO, Integer>{

	List<PrestadorDTO> findByidPrest(int id);
	PrestadorDTO save(int id);	
}
