package com.clinica.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clinica.dto.ConsultaDTO;

@Repository
public interface ConsultasRepository extends JpaRepository<ConsultaDTO, Integer> {

	//List<Consultas> findByIdconsulta(int id);
	
	ConsultaDTO findByIdconsulta(int id);
	
	ConsultaDTO save(int id);
	
	List<ConsultaDTO> findBydataconsultaBetween(Date dt1,Date dt2);
	
	@Query(value = "select * from ConsultaDTO as c where  DATE_FORMAT(c.dataconsulta, '%Y-%m-%d') = '2022-02-24'", nativeQuery = true)
	List<ConsultaDTO> BuscaPorData();
	
	@Query(value = "select * from ConsultaDTO as c where  DATE_FORMAT(c.datasolicitacao, '%Y-%m-%d') = '2022-02-21'", nativeQuery = true)
	List<ConsultaDTO> BuscaPorDataSolicitacao();

	@Query(value = "select c from ConsultaDTO c WHERE c.codbenef.idbenef = :id and dataconsulta between :startdt and :enddt")
	Page<ConsultaDTO> findPageBeneficiarioConsutaBetween(int id, Pageable pageble, Date startdt,Date enddt );

	@Query(value = "select c from ConsultaDTO c WHERE c.codbenef.idbenef = :id")
	List<ConsultaDTO> findBeneficiarioConsulta(int id);
	
	@Query(value = "select c from ConsultaDTO c")
	Page<ConsultaDTO> findPageBeneficiarioConsuta(int id, Pageable pageble);
	
	@Transactional
	@Modifying
	@Query(value = "update ConsultaDTO c set c.status = :status where c.idconsulta = :id")
	void DesativarPrestador(@Param("status") String status, @Param("id") int id);
	
	Page<ConsultaDTO> findAll(Specification<ConsultaDTO> spec, Pageable pageable);
	List<ConsultaDTO> findAll(Specification<ConsultaDTO> spec);
	 	
//	@Query(value = "SELECT b from clienteparticularDTO b WHERE b.nome_comp like %:nomeCompleto%")
//	 public List<clienteparticularDTO> buscaPorLike(String nomeCompleto);	
}
