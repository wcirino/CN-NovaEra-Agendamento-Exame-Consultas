package com.clinica.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.config.ModelMapperConfig;
import com.clinica.dto.agendamentoDTO;
import com.clinica.dto.exameDTO;
import com.clinica.entity.exame;
import com.clinica.repository.AgendamentoRepository;

@Service
public class agendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoproxy;
	
	@Autowired
	private ModelMapperConfig modalMapper;
	
	public List<agendamentoDTO> findAll_agendamento() throws Exception{
		Optional<List<agendamentoDTO>> obj = Optional.ofNullable(agendamentoproxy.findAll());
		return obj.orElseThrow(() -> new Exception());
	}
	
	public agendamentoDTO find_Agendamento_id(int id) throws Exception{
		Optional<agendamentoDTO> obj = Optional.ofNullable(agendamentoproxy.findByidagendamento(id));
		return obj.orElseThrow(() -> new Exception());
	}
	
	public agendamentoDTO Insertagendamento(agendamentoDTO dto) throws Exception{
		if(!agendamentoproxy.existsById(dto.getIdagendamento())) {
			agendamentoDTO obj = agendamentoproxy.save(dto);
			return obj;
		}
		else {
			throw new Exception("O agendamento  possui Id");
		}
	}
	
	public agendamentoDTO Updategendamento(agendamentoDTO dto) throws Exception{
		if(agendamentoproxy.existsById(dto.getIdagendamento())) {
			agendamentoDTO obj = agendamentoproxy.save(dto);
			return obj;
		}
		else {
			throw new Exception("O agendamento não possui Id");
		}
	}
	
//	private agenda AgendamentomodelMapperOne(agendamentoDTO dto) {
//		exame obj = modalMapper.modelMapper().map(dto, exame.class);
//		return obj;
//	}
//	
//	private List<exame> AgendamentoModelMapperList(List<exameDTO> dto){	
//		  return dto.stream().map(obj -> PrestadormodelMapperOne(obj)).collect(Collectors.toList());
//	}
	
}
