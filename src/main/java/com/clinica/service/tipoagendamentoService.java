package com.clinica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.dto.tipoagendamentoDTO;
import com.clinica.repository.tipoagendamentorepository;

@Service
public class tipoagendamentoService {

	@Autowired
	private tipoagendamentorepository tipoagendamentoproxy;
	
	public List<tipoagendamentoDTO> findAll_TipoAgendamento() throws Exception{
		Optional<List<tipoagendamentoDTO>> obj = Optional.ofNullable(tipoagendamentoproxy.findAll());
		return obj.orElseThrow(() -> new Exception());
	}
	
	public tipoagendamentoDTO find_tipoAgendamento_id(int id) throws Exception{
		Optional<tipoagendamentoDTO> obj = Optional.ofNullable(tipoagendamentoproxy.findByidtipoagendamento(id));
		return obj.orElseThrow(() -> new Exception());
	}
	
	public tipoagendamentoDTO InsertTipoAgendamento(tipoagendamentoDTO dto) throws Exception{
		if(!tipoagendamentoproxy.existsById(dto.getIdtipoagendamento())) {
			tipoagendamentoDTO obj = tipoagendamentoproxy.save(dto);
			return obj;
		}
		else {
			throw new Exception("A Consulta possui Id");
		}
	}
	
	public tipoagendamentoDTO UpdateTipoAgendamento(tipoagendamentoDTO dto) throws Exception{
		if(tipoagendamentoproxy.existsById(dto.getIdtipoagendamento())) {
			tipoagendamentoDTO obj = tipoagendamentoproxy.save(dto);
			return obj;
		}
		else {
			throw new Exception(""
					+ "A consulta não possui Id");
		}
	}
	
}
