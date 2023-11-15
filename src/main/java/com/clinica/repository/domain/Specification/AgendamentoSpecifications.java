package com.clinica.repository.domain.Specification;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.clinica.dto.AgendamentoDTO;
import com.clinica.service.UtilService;

@Service
public class AgendamentoSpecifications {

	  public static Specification<AgendamentoDTO> criarSpec(String carteirinha,Integer codbenef,String startdt,String enddt,Integer idagendamento,Integer idtipoagendamento) throws Exception {
			
	        Specification<AgendamentoDTO> spec = Specification.where(null);

	        if (codbenef != null) {
	            spec = spec.and((root, query, criteriaBuilder) ->
	                    criteriaBuilder.equal(root.get("idbenef"), codbenef));
	        }

	        if (idagendamento != null) {
	            spec = spec.and((root, query, criteriaBuilder) ->
	                    criteriaBuilder.equal(root.get("idagendamento"), idagendamento));
	        }

	        if (idtipoagendamento != null) {
	            spec = spec.and((root, query, criteriaBuilder) ->
	                    criteriaBuilder.equal(root.get("idtipoagendamento"), idtipoagendamento));
	        }
	        
	        if (startdt != null && enddt != null) {
	            try {
	        		//Date startdtt = UtilService.ConvertDate(startdt);
	        		//Date enddtt = UtilService.ConvertDate(enddt);
	            	
	            	 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	                 Date startdtt = formatter.parse(startdt);
	                 Date enddtt = formatter.parse(enddt);

	                spec = spec.and((root, query, criteriaBuilder) ->
	                        criteriaBuilder.between(root.get("dataconsulta"), startdtt, enddtt));

	            } catch (ParseException e) {
	                // Lidar com a exceção de parsing, se necessário
	                e.printStackTrace();
	            }
	        } else if (startdt != null && enddt == null) {
	            try {
	        		Date startdtt = UtilService.ConvertDate(startdt);

	                spec = spec.and((root, query, criteriaBuilder) ->
	                        criteriaBuilder.between(root.get("dataconsulta"), startdtt, startdtt));

	            } catch (ParseException e) {
	                // Lidar com a exceção de parsing, se necessário
	                e.printStackTrace();
	            }
	        }

	        return spec;
	    }
	
}
