package com.clinica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.config.ModelMapperConfig;
import com.clinica.dto.agendamentoDTO;
import com.clinica.repository.AgendamentoRepository;

@Service
public class agendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoproxy;
	
	@Autowired
	private ModelMapperConfig modalMapper;
	
	public List<agendamentoDTO> findAll_agendamento() throws Exception{
		Optional<List<agendamentoDTO>> obj = Optional.ofNullable(agendamentoproxy.findAll());
		
		return obj.orElseThrow(() -> new Exception("Ocorreu um erro não previsto no sistema, sem agendamento"));
	}
	
	public agendamentoDTO find_Agendamento_id(int id) throws Exception{
		Optional<agendamentoDTO> obj = Optional.ofNullable(agendamentoproxy.findByidagendamento(id));
		return obj.orElseThrow(() -> new Exception("Ocorreu um erro não previsto no sistema, sem agendamento 2"));
	}
	
	public agendamentoDTO Insertagendamento(agendamentoDTO dto) throws Exception{
		if(dto == null || dto.getIdagendamento() != null){
			throw new Exception("O agendamento  possui Id");
		}
		else {
			agendamentoDTO obj = agendamentoproxy.save(dto);
			return obj;
		}
	}
	
	public agendamentoDTO Updategendamento(agendamentoDTO dto) throws Exception{
		if(dto == null || dto.getIdagendamento() == null){
			throw new Exception("O agendamento não possui Id");
		}
		else {
			agendamentoDTO obj = agendamentoproxy.save(dto);
			return obj;
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
