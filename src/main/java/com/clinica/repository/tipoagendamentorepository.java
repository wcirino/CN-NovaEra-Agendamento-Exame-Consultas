package com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.clinica.dto.tipoagendamentoDTO;

@Repository
public interface tipoagendamentorepository extends JpaRepository<tipoagendamentoDTO, Integer> {
	
	tipoagendamentoDTO findByidtipoagendamento(int id);
	tipoagendamentoDTO save(int id);

}
