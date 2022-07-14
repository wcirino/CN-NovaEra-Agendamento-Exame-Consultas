package com.clinica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.config.ModelMapperConfig;
import com.clinica.dto.BeneficiarioDTO;
import com.clinica.repository.BeneficiarioRepository;


@Service
public class BeneficiarioService {

	@Autowired
	private BeneficiarioRepository proxyBenef;
		
	@Autowired
	private ModelMapperConfig modelMapper;
	
//	private ModelMapper m = new ModelMapper();
	
	/*
	 * public benefConsultaDTO find_beneficiario_id_dto(int id) throws Exception{
	 * Optional<benefConsultaDTO> obj =
	 * Optional.ofNullable(beneficiariomodelMapperOne(proxyBenef.findByIdbenef(id)))
	 * ; return obj.orElseThrow(() -> new Exception()); }
	 */
	
	public BeneficiarioDTO find_beneficiario_id(int id) throws Exception{
		Optional<BeneficiarioDTO> obj = Optional.ofNullable(proxyBenef.findByIdbenef(id));
		return obj.orElseThrow(() -> new Exception());
	}
	
	public List<BeneficiarioDTO> findAll_beneficiario() throws Exception{
		Optional<List<BeneficiarioDTO>> obj = Optional.ofNullable(proxyBenef.findAll());
		return obj.orElseThrow(() -> new Exception());
	}
					
	/*
	 * private benefConsultaDTO beneficiariomodelMapperOne(Beneficiario dto) {
	 * benefConsultaDTO consult = m.map(dto, benefConsultaDTO.class); return
	 * consult; }
	 * 
	 * private List<benefConsultaDTO> beneficiarioModelMapperList(List<Beneficiario>
	 * dto){ return dto.stream().map(obj ->
	 * beneficiariomodelMapperOne(obj)).collect(Collectors.toList()); }
	 */
	
}