package com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.dto.AgendamentoDTO;

@Repository
public interface AgendamentoRepository extends JpaRepository<AgendamentoDTO, Integer> {

	AgendamentoDTO findByidagendamento(int id);
	AgendamentoDTO save(int id);
	
}
