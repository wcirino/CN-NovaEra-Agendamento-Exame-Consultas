package com.clinica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.dto.exameDTO;
import com.clinica.dto.tipoExameDTO;
import com.clinica.repository.tipoExameRespository;


@Service
public class tipoExameService {

	@Autowired
	private tipoExameRespository proxytipExame;
	
	public List<tipoExameDTO> findAll_TipoExame() throws Exception{
		Optional<List<tipoExameDTO>> obj = Optional.ofNullable(proxytipExame.findAll());
		return obj.orElseThrow(() -> new Exception());
	}
	
	public tipoExameDTO find_tipoExame_id(int id) throws Exception{
		Optional<tipoExameDTO> obj = Optional.ofNullable(proxytipExame.findByidtipoexame(id));
		return obj.orElseThrow(() -> new Exception());
	}
	
	public tipoExameDTO InsertExame(tipoExameDTO dto) throws Exception{
		if(dto == null || dto.getIdtipoexame() != null) {
			throw new Exception("A Consulta possui Id");
		}
		else {
			tipoExameDTO obj = proxytipExame.save(dto);
			return obj;
		}
	}
	
	public tipoExameDTO UpdateExame(tipoExameDTO dto) throws Exception{
		if(dto == null || dto.getIdtipoexame() == null) {
			throw new Exception(""
					+ "A consulta não possui Id Update");
		}
		else {
			tipoExameDTO obj = proxytipExame.save(dto);
			return obj;
		}
	}
	
}
