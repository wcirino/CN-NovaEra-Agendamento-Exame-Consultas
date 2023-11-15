package com.clinica.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
//import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.clinica.repository.ExameRepository;
import com.clinica.repository.domain.Specification.ExameSpecifications;
//import com.clinica.config.ModelMapperConfig;
import com.clinica.dto.ExameDTO;
//import com.clinica.entity.exame;
import com.clinica.dto.ExamePageDTO;
import com.clinica.mq.ExameMqPublisher;

@Service
public class ExameService {

	@Autowired
	private ExameRepository proxyExame;
	
	@Autowired 
	private EmailService emailservice;
	
	@Autowired
	private UtilService utilService;
	
	@Autowired
	private ExameMqPublisher exameMqPublisher;
	
	@Autowired
	private ExameSpecifications exameSpecifications;
	
	private static final Logger LOG = LoggerFactory.getLogger(ExameService.class);
	
	public List<ExameDTO> findAll_Exame() throws Exception{
		LOG.info("Iniciando service ExameService : proxyExame.findAll()");
		Optional<List<ExameDTO>> obj = Optional.ofNullable(proxyExame.findAll());
		LOG.info("Fim service ExameService : proxyExame.findAll()");
		return obj.orElseThrow(() -> new Exception());
	}
	
	public ExameDTO find_Exame_id(int id) throws Exception{
		LOG.info("Iniciando service ExameService :find_Exame_id");
		if(id <= 0) {
			throw new Exception();
		}
		LOG.info("Iniciando service ExameService : proxyExame.findByidexame");
		Optional<ExameDTO> obj = Optional.ofNullable(proxyExame.findByidexame(id));
		LOG.info("Fim service ExameService : proxyExame.findByidexame");
		return obj.orElseThrow(() -> new Exception());
	}
	
	public ExameDTO InsertExame(ExameDTO dto) throws Exception{
		LOG.info("Iniciando service ExameService : InsertExame");
		if(dto == null || dto.getIdexame() != null){
			throw new Exception("A Consulta possui Id");
		}
		else {
			LOG.info("Iniciando service ExameService : proxyExame.save");
			ExameDTO obj = proxyExame.save(dto);
			try {
				emailservice.EnviarEmail(utilService.dadosEmail(2));
			}catch (Exception e) {
				// TODO: handle exception
			}finally {
				if(obj != null) {
					exameMqPublisher.envioExame(obj);
					return obj;
				}
			}
			LOG.info("Fim service ExameService : proxyExame.save");
			exameMqPublisher.envioExame(obj);
			return obj;
		}
	}
	
	public ExameDTO UpdateExame(ExameDTO dto) throws Exception{
		LOG.info("Iniando service ExameService : UpdateExame");
		if(dto == null || dto.getIdexame() == null){
			throw new Exception(""
					+ "A consulta não possui Id");
		}
		else {
			LOG.info("Iniciando service ExameService : proxyExame.save()");
			ExameDTO obj = proxyExame.save(dto);
			LOG.info("Fim service ExameService : proxyExame.save()");
			return obj;
		}
	}
	
	public ExamePageDTO findBeneficiarioPageExameService(Pageable pageble,int id,Date startdt,Date enddt) throws Exception {
		LOG.info("iniciando findAll_page_Consultas_Service()");
		Optional<Page<ExameDTO>> obj = Optional.ofNullable(proxyExame.findBeneficiarioExamePage(id,startdt, enddt,pageble));
		obj.orElseThrow(() -> new Exception());
		ExamePageDTO dto = new ExamePageDTO(obj.get().getContent(), obj.get().getTotalElements(),
												  obj.get().getTotalPages(), obj.get().getSize(),
												  obj.get().getNumberOfElements());
		LOG.info("Fim do metodo findAll_page_Consultas_Service");
		return dto;
	}
	
	public ExamePageDTO findBeneficiarioPageSemIdExameervice(Pageable pageble,Date startdt,Date enddt) throws Exception {
		LOG.info("iniciando findAll_page_Consultas_Service()");
		Optional<Page<ExameDTO>> obj = Optional.ofNullable(proxyExame.findBeneficiarioExameSemIDPage(startdt, enddt,pageble));
		obj.orElseThrow(() -> new Exception());
		ExamePageDTO dto = new ExamePageDTO(obj.get().getContent(), obj.get().getTotalElements(),
												  obj.get().getTotalPages(), obj.get().getSize(),
												  obj.get().getNumberOfElements());
		LOG.info("Fim do metodo findAll_page_Consultas_Service");
		return dto;
	}
	
	public List<ExameDTO> findExameBeneficiarioSpecService(String carteirinha,Integer codbenef,String startdt,String enddt,Integer idexame,Integer tipoexame) throws Exception {
		Specification<ExameDTO> spec = ExameSpecifications.criarSpec(carteirinha, codbenef, startdt, enddt, idexame, tipoexame);
		return proxyExame.findAll(spec);
	}
}
