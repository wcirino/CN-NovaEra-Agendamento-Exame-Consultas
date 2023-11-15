package com.clinica.entity;

import java.util.Date;
import javax.persistence.Entity;
import com.clinica.dto.BeneficiarioDTO;
import com.clinica.dto.TipoConsultaDTO;
import com.clinica.dto.enums.StatusConsulta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class consulta {

	private Integer idconsulta;
	private Prestador codprestador;
	private Beneficiario codbenef;
	private Date dataconsulta;
	private Date datasolicitacao;
	private TipoConsultaDTO tipoconsulta;
	private String status;
	//private StatusConsulta status;
	
}
