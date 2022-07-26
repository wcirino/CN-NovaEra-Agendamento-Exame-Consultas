package com.clinica.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clinica.dto.ExameDTO;

@Repository
public interface ExameRepository extends JpaRepository<ExameDTO,Integer> {

	ExameDTO findByidexame(int id);
	ExameDTO save(int id);

	@Query(value = "select d from ExameDTO d WHERE d.codbenef = :id and dataconsulta between :stardt and :enddt")
	Page<ExameDTO> findBeneficiarioExamePage(int id,Date stardt, Date enddt,Pageable pageble);

	@Query(value = "select d from ExameDTO d WHERE d.codbenef = :id and dataconsulta between :stardt and :enddt")
	List<ExameDTO> findBeneficiarioExame(int id,Date stardt, Date enddt);
	
	@Query(value = "select d from ExameDTO d WHERE dataconsulta between :stardt and :enddt")
	Page<ExameDTO> findBeneficiarioExameSemIDPage(Date stardt, Date enddt,Pageable pageble);
}