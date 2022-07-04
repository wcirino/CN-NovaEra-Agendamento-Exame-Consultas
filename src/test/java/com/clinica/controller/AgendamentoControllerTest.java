package com.clinica.controller;

import static java.util.Arrays.asList;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.clinica.dto.agendamentoDTO;
import com.clinica.service.agendamentoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = agendamentoController.class)
@AutoConfigureMockMvc
public class AgendamentoControllerTest {

    static String root_api = "/api-agendamento";

	@Autowired
	MockMvc mvc;

	@MockBean
	agendamentoService service;
	
	@Test
	public void findAllExame() throws Exception {
		
			agendamentoDTO dto = this.criandoObjeto();
			List<agendamentoDTO> reponseExame =  this.criandoListObjeto();
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
			agendamentoDTO reponseExame =  this.criandoObjeto();
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
			agendamentoDTO dto = this.criandoObjeto2();
			agendamentoDTO reponseExame =  this.criandoObjeto2();
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
			agendamentoDTO dto = this.criandoObjeto();
			agendamentoDTO reponseExame =  this.criandoObjeto();
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
	
	private agendamentoDTO criandoObjeto() {
		return agendamentoDTO.builder()
				.idagendamento(1)
				.idbenef(1)
				.idprestador(1)
				.idtipoagendamento(null)
				.dataconsulta(null)
				.datasolicitacao(null)
				.statusAgendamento("1")
				.build();
	}
	
	private agendamentoDTO criandoObjeto2() {
		return agendamentoDTO.builder()
				.idagendamento(null)
				.idbenef(1)
				.idprestador(1)
				.idtipoagendamento(null)
				.dataconsulta(null)
				.datasolicitacao(null)
				.statusAgendamento("1")
				.build();
	}
	
	/*
	 * private agendamentoDTO criandoObjetoIdNull() { return
	 * agendamentoDTO.builder() .idbenef(1) .idprestador(1) .idtipoagendamento(null)
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
	
	
	private List<agendamentoDTO> criandoListObjeto() {
		return asList(agendamentoDTO.builder().idagendamento(1).idbenef(1).idprestador(1).idtipoagendamento(null)
				.dataconsulta(null).datasolicitacao(null).statusAgendamento("1").build(),
				 agendamentoDTO.builder().idagendamento(2).idbenef(2).idprestador(2).idtipoagendamento(null)
				.dataconsulta(null).datasolicitacao(null).statusAgendamento("1").build(),
				agendamentoDTO.builder().idagendamento(3).idbenef(3).idprestador(3).idtipoagendamento(null)
				.dataconsulta(null).datasolicitacao(null).statusAgendamento("1").build(),
				 agendamentoDTO.builder().idagendamento(4).idbenef(4).idprestador(4).idtipoagendamento(null)
				.dataconsulta(null).datasolicitacao(null).statusAgendamento("1").build(),
				agendamentoDTO.builder().idagendamento(5).idbenef(5).idprestador(5).idtipoagendamento(null)
				.dataconsulta(null).datasolicitacao(null).statusAgendamento("1").build(),
				 agendamentoDTO.builder().idagendamento(6).idbenef(6).idprestador(6).idtipoagendamento(null)
				.dataconsulta(null).datasolicitacao(null).statusAgendamento("1").build());
	}
	
}
