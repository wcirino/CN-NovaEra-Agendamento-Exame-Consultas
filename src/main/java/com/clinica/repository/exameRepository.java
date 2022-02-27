package com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.dto.exameDTO;

@Repository
public interface exameRepository extends JpaRepository<exameDTO,Integer> {

	exameDTO findByidtipoexame(int id);
	exameDTO save(int id);

}