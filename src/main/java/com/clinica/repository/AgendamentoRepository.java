package com.clinica.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clinica.dto.AgendamentoDTO;

@Repository
public interface AgendamentoRepository extends JpaRepository<AgendamentoDTO, Integer> {

	AgendamentoDTO findByidagendamento(int id);
	AgendamentoDTO save(int id);
	
	@Query(value = "select a from AgendamentoDTO a WHERE a.idbenef = :id and a.dataconsulta between :stardt and :enddt")
	Page<AgendamentoDTO> findBeneficiarioagendamentoPage(int id,Date stardt, Date enddt,Pageable pageble);
	
	@Query(value = "select a from AgendamentoDTO a WHERE a.dataconsulta between :stardt and :enddt")
	Page<AgendamentoDTO> findBeneficiarioagendamentoSemIDPage(Date stardt, Date enddt,Pageable pageble);	
	
	Page<AgendamentoDTO> findAll(Specification<AgendamentoDTO> spec, Pageable pageable);
	Page<AgendamentoDTO> findAll(Pageable pageable);
	List<AgendamentoDTO> findAll(Specification<AgendamentoDTO> spec);
}
