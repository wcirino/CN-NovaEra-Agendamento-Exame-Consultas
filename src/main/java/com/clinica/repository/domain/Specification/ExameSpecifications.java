package com.clinica.repository.domain.Specification;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.clinica.dto.ConsultaDTO;
import com.clinica.dto.ExameDTO;
import com.clinica.service.UtilService;

@Service
public class ExameSpecifications {

	  public static Specification<ExameDTO> criarSpec(String carteirinha,Integer codbenef,String startdt,String enddt,Integer idexame,Integer tipoexame) throws Exception {
			
	        Specification<ExameDTO> spec = Specification.where(null);

	        if (codbenef != null) {
	            spec = spec.and((root, query, criteriaBuilder) ->
	                    criteriaBuilder.equal(root.get("idbenef"), codbenef));
	        }

	        if (idexame != null) {
	            spec = spec.and((root, query, criteriaBuilder) ->
	                    criteriaBuilder.equal(root.get("idexame"), idexame));
	        }

	        if (tipoexame != null) {
	            spec = spec.and((root, query, criteriaBuilder) ->
	                    criteriaBuilder.equal(root.get("idtipoexame"), tipoexame));
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
