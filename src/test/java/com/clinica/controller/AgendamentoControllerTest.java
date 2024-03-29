package com.clinica.controller;

import static java.util.Arrays.asList;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.clinica.dto.AgendamentoDTO;
import com.clinica.dto.BeneficiarioDTO;
import com.clinica.dto.PrestadorDTO;
import com.clinica.service.AgendamentoService;
import com.clinica.service.UtilService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AgendamentoController.class)
@AutoConfigureMockMvc
public class AgendamentoControllerTest {

    static String root_api = "/api-agendamento";

	@Autowired
	MockMvc mvc;

	@MockBean
	AgendamentoService service;
	
	@MockBean
	UtilService util;

	@Test
	public void findAllExame() throws Exception {
		
			AgendamentoDTO dto = this.criandoObjeto();
			List<AgendamentoDTO> reponseExame =  this.criandoListObjeto();
	        BDDMockito.given(service.findAll_agendamento()).willReturn(reponseExame);
	        String json = new ObjectMapper().writeValueAsString(dto);

	        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
	                .get(root_api+"/agendamento-all")
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON)
	                .content(json);

	        mvc
	            .perform(request)
	            .andExpect(status().isOk());
		
	}
	
	@Test
	public void findIDExame() throws Exception {
		
			//cenario
			int id = 1;
			AgendamentoDTO reponseExame =  this.criandoObjeto();
	        BDDMockito.given(service.find_Agendamento_id(id)).willReturn(reponseExame);
	        String json = new ObjectMapper().writeValueAsString(id);

	        //ação - execução
	        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
	                .get(root_api+"/agendamento-id/1")
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON)
	                .content(json);
	        //resultado
	        mvc
	            .perform(request)
	            .andExpect(status().isOk());
		
	}
	
	@Test
	public void InsertExame() throws Exception {
		
			//cenario
			AgendamentoDTO dto = this.criandoObjeto2();
			AgendamentoDTO reponseExame =  this.criandoObjeto2();
	        BDDMockito.given(service.Insertagendamento(dto)).willReturn(reponseExame);
	        String json = new ObjectMapper().writeValueAsString(dto);

	        //ação - execução
	        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
	                .post(root_api+"/agendamento")
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON)
	                .content(json);
	        //resultado
	        mvc
	            .perform(request)
	            .andExpect(status().isCreated());
		
	}
	
	@Test
	public void UpdateExame() throws Exception {
		
			//cenario
			AgendamentoDTO dto = this.criandoObjeto();
			AgendamentoDTO reponseExame =  this.criandoObjeto();
	        BDDMockito.given(service.Updategendamento(dto)).willReturn(reponseExame);
	        String json = new ObjectMapper().writeValueAsString(dto);

	        //ação - execução
	        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
	                .put(root_api+"/agendamento")
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON)
	                .content(json);
	        //resultado
	        mvc
	            .perform(request)
	            .andExpect(status().isOk());
		
	}
	
	private AgendamentoDTO criandoObjeto() {
		
		PrestadorDTO p = new PrestadorDTO();
		p.setIdPrest(1);
		
		BeneficiarioDTO b = new BeneficiarioDTO();
		b.setIdbenef(1);
		
		return AgendamentoDTO.builder()
				.idagendamento(1)
				.idbenef(b)
				.prestador(p)
				.idtipoagendamento(null)
				.dataconsulta(null)
				.datasolicitacao(null)
				.statusAgendamento("1")
				.build();
	}
	
	private AgendamentoDTO criandoObjeto2() {
		
		PrestadorDTO p = new PrestadorDTO();
		p.setIdPrest(1);
		
		BeneficiarioDTO b = new BeneficiarioDTO();
		b.setIdbenef(1);
		
		return AgendamentoDTO.builder()
				.idagendamento(null)
				.idbenef(b)
				.prestador(p)
				.idtipoagendamento(null)
				.dataconsulta(null)
				.datasolicitacao(null)
				.statusAgendamento("1")
				.build();
	}
	
	/*
	 * private agendamentoDTO criandoObjetoIdNull() { return
	 * agendamentoDTO.builder() .idbenef(1) .prestador(p) .idtipoagendamento(null)
	 * .dataconsulta(null) .datasolicitacao(null) .statusAgendamento("1") .build();
	 * }
	 */
	
	/*
	 * private agendamentoDTO criandoObjetoParametro(int idagen,int idbenef,int
	 * idprestador,String status) { return agendamentoDTO.builder()
	 * .idagendamento(idagen) .idbenef(idbenef) .idprestador(idprestador)
	 * .idtipoagendamento(null) .dataconsulta(null) .datasolicitacao(null)
	 * .statusAgendamento(status) .build(); }
	 * 
	 * private agendamentoDTO criandoObjetoNull() { return null; }
	 */
	
	
	private List<AgendamentoDTO> criandoListObjeto() {
		
		PrestadorDTO p = new PrestadorDTO();
		p.setIdPrest(1);
		
		BeneficiarioDTO b = new BeneficiarioDTO();
		b.setIdbenef(1);
		
		return asList(AgendamentoDTO.builder().idagendamento(1).idbenef(b).prestador(p).idtipoagendamento(null)
				.dataconsulta(null).datasolicitacao(null).statusAgendamento("1").build(),
				 AgendamentoDTO.builder().idagendamento(2).idbenef(b).prestador(p).idtipoagendamento(null)
				.dataconsulta(null).datasolicitacao(null).statusAgendamento("1").build(),
				AgendamentoDTO.builder().idagendamento(3).idbenef(b).prestador(p).idtipoagendamento(null)
				.dataconsulta(null).datasolicitacao(null).statusAgendamento("1").build(),
				 AgendamentoDTO.builder().idagendamento(4).idbenef(b).prestador(p).idtipoagendamento(null)
				.dataconsulta(null).datasolicitacao(null).statusAgendamento("1").build(),
				AgendamentoDTO.builder().idagendamento(5).idbenef(b).prestador(p).idtipoagendamento(null)
				.dataconsulta(null).datasolicitacao(null).statusAgendamento("1").build(),
				 AgendamentoDTO.builder().idagendamento(6).idbenef(b).prestador(p).idtipoagendamento(null)
				.dataconsulta(null).datasolicitacao(null).statusAgendamento("1").build());
	}
	
}
