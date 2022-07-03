package com.clinica.entity.modalMapper;

/*import java.util.List;
import java.util.stream.Collectors;*/

import org.springframework.beans.factory.annotation.Autowired;

import com.clinica.config.ModelMapperConfig;
/*import com.clinica.dto.agendamentoDTO;
import com.clinica.dto.exameDTO;
import com.clinica.entity.exame;*/


public class AgendamentoService {

	@Autowired
	private ModelMapperConfig modalMapper;
	
	public void modalMapperteste() {
		modalMapper.getClass();
	}
	
	/*
	 * private agenda AgendamentomodelMapperOne(agendamentoDTO dto) { exame obj =
	 * modalMapper.modelMapper().map(dto, exame.class); return obj; }
	 * 
	 * private List<exame> AgendamentoModelMapperList(List<exameDTO> dto){ return
	 * dto.stream().map(obj ->
	 * PrestadormodelMapperOne(obj)).collect(Collectors.toList()); }
	 */
	
}
