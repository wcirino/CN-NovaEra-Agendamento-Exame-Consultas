package com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.dto.ExameDTO;

@Repository
public interface ExameRepository extends JpaRepository<ExameDTO,Integer> {

	ExameDTO findByidexame(int id);
	ExameDTO save(int id);

}