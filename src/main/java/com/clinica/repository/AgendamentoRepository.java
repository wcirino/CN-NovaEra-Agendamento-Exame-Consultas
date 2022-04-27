package com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.dto.agendamentoDTO;

@Repository
public interface AgendamentoRepository extends JpaRepository<agendamentoDTO, Integer> {

	agendamentoDTO findByidagendamento(int id);
	agendamentoDTO save(int id);
	
}
