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

import com.clinica.dto.tipoagendamentoDTO;
import com.clinica.service.tipoagendamentoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = tipoagendamentoController.class)
@AutoConfigureMockMvc
public class TipoAgendamentoControllerTest {

    static String root_api = "/api-tipoagendamento";

	@Autowired
	MockMvc mvc;

	@MockBean
	tipoagendamentoService service;
	
	@Test
	public void findAllExame() throws Exception {
		
		tipoagendamentoDTO dto = this.criandoObjeto();
			List<tipoagendamentoDTO> reponseExame =  this.criandoListObjeto();
	        BDDMockito.given(service.findAll_TipoAgendamento()).willReturn(reponseExame);
	        String json = new ObjectMapper().writeValueAsString(dto);

	        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
	                .get(root_api+"/tipo-agendamento")
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
			tipoagendamentoDTO reponseExame =  this.criandoObjeto();
	        BDDMockito.given(service.find_tipoAgendamento_id(id)).willReturn(reponseExame);
	        String json = new ObjectMapper().writeValueAsString(id);

	        //ação - execução
	        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
	                .get(root_api+"/tipo-tipoagendamento-id/1")
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON)
	                .content(json);
	        //resultado
	        mvc
	            .perform(request)
	            .andExpect(status().isOk());
		
	}
	
	private tipoagendamentoDTO criandoObjeto() {
		return tipoagendamentoDTO.builder()
				.idtipoagendamento(1)
				.nomeagendamento("vacina")
				.valor(300)
				.statusAgendamento("1")
				.tipo(1)
				.datacriacao(null)
				.build();				
	}
	
	/*
	 * private tipoagendamentoDTO criandoObjeto2() { return
	 * tipoagendamentoDTO.builder() .idtipoagendamento(1) .nomeagendamento("vacina")
	 * .valor(300) .statusAgendamento("1") .tipo(1) .datacriacao(null) .build(); }
	 * 
	 * private tipoagendamentoDTO criandoObjetoIdNull() { return
	 * tipoagendamentoDTO.builder() .idtipoagendamento(null)
	 * .nomeagendamento("vacina") .valor(300) .statusAgendamento("1") .tipo(1)
	 * .datacriacao(null) .build(); }
	 * 
	 * private tipoagendamentoDTO criandoObjetoNull() { return null; }
	 */
	
	
	private List<tipoagendamentoDTO> criandoListObjeto() {
		return asList(
				tipoagendamentoDTO.builder().idtipoagendamento(1).nomeagendamento("vacina").valor(300)
						.statusAgendamento("1").tipo(1).datacriacao(null).build(),
				tipoagendamentoDTO.builder().idtipoagendamento(1).nomeagendamento("vacina").valor(300)
						.statusAgendamento("1").tipo(1).datacriacao(null).build(),
				tipoagendamentoDTO.builder().idtipoagendamento(1).nomeagendamento("vacina").valor(300)
						.statusAgendamento("1").tipo(1).datacriacao(null).build(),
				tipoagendamentoDTO.builder().idtipoagendamento(1).nomeagendamento("vacina").valor(300)
						.statusAgendamento("1").tipo(1).datacriacao(null).build(),
				tipoagendamentoDTO.builder().idtipoagendamento(1).nomeagendamento("vacina").valor(300)
						.statusAgendamento("1").tipo(1).datacriacao(null).build());
	}
	
}
