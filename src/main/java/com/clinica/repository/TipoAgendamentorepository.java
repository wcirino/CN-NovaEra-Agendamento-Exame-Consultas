package com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.clinica.dto.TipoAgendamentoDTO;

@Repository
public interface TipoAgendamentorepository extends JpaRepository<TipoAgendamentoDTO, Integer> {
	
	TipoAgendamentoDTO findByidtipoagendamento(int id);
	TipoAgendamentoDTO save(int id);

}
