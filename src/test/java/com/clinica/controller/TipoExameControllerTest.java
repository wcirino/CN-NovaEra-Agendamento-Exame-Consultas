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

import com.clinica.dto.TipoExameDTO;
import com.clinica.service.TipoExameService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = TipoExameController.class)
@AutoConfigureMockMvc
public class TipoExameControllerTest {

    static String root_api = "/api-tipoExame";

	@Autowired
	MockMvc mvc;

	@MockBean
	TipoExameService service;
	
	@Test
	public void findAllExame() throws Exception {
		
		TipoExameDTO dto = this.criandoObjeto();
			List<TipoExameDTO> reponseExame =  this.criandoListObjeto();
	        BDDMockito.given(service.findAll_TipoExame()).willReturn(reponseExame);
	        String json = new ObjectMapper().writeValueAsString(dto);

	        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
	                .get(root_api+"/tipo-exame")
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
			TipoExameDTO reponseExame =  this.criandoObjeto();
	        BDDMockito.given(service.find_tipoExame_id(id)).willReturn(reponseExame);
	        String json = new ObjectMapper().writeValueAsString(id);

	        //ação - execução
	        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
	                .get(root_api+"/tipo-exame-id/1")
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
		TipoExameDTO dto = this.criandoObjeto2();
		TipoExameDTO reponseExame =  this.criandoObjeto2();
	        BDDMockito.given(service.InsertExame(dto)).willReturn(reponseExame);
	        String json = new ObjectMapper().writeValueAsString(dto);

	        //ação - execução
	        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
	                .post(root_api+"/tipo-exame")
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
		TipoExameDTO dto = this.criandoObjeto();
		TipoExameDTO reponseExame =  this.criandoObjeto();
	        BDDMockito.given(service.UpdateExame(dto)).willReturn(reponseExame);
	        String json = new ObjectMapper().writeValueAsString(dto);

	        //ação - execução
	        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
	                .put(root_api+"/tipo-exame")
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON)
	                .content(json);
	        //resultado
	        mvc
	            .perform(request)
	            .andExpect(status().isOk());
		
	}
	
	private TipoExameDTO criandoObjeto() {
		return TipoExameDTO.builder()
				.idtipoexame(1)
				.nome_exame("vacina")
				.valor(300)
				.datainsert(null)
				.build();				
	}
	
	private TipoExameDTO criandoObjeto2() {
		return TipoExameDTO.builder()
				.idtipoexame(1)
				.nome_exame("vacina")
				.valor(300)
				.datainsert(null)
				.build();
	}
	
	/*
	 * private tipoExameDTO criandoObjetoIdNull() { return tipoExameDTO.builder()
	 * .idtipoexame(null) .nome_exame("vacina") .valor(300) .datainsert(null)
	 * .build(); }
	 * 
	 * private tipoExameDTO criandoObjetoNull() { return null; }
	 */
	
	
	private List<TipoExameDTO> criandoListObjeto() {
		return asList(
				TipoExameDTO.builder().idtipoexame(1).nome_exame("vacina").valor(300)
		.datainsert(null).build(),
				TipoExameDTO.builder().idtipoexame(1).nome_exame("vacina").valor(300)
		.datainsert(null).build(),
				TipoExameDTO.builder().idtipoexame(1).nome_exame("vacina").valor(300)
		.datainsert(null).build(),
				TipoExameDTO.builder().idtipoexame(1).nome_exame("vacina").valor(300)
		.datainsert(null).build(),
				TipoExameDTO.builder().idtipoexame(1).nome_exame("vacina").valor(300)
		.datainsert(null).build());
	}
	
}
