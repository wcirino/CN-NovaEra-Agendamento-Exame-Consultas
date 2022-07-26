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

import com.clinica.dto.ExameDTO;
import com.clinica.service.ExameService;
import com.fasterxml.jackson.databind.ObjectMapper;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ExameController.class)
@AutoConfigureMockMvc
public class ExameControllerTest {

    static String root_api = "/api-exame";

	@Autowired
	MockMvc mvc;

	@MockBean
	ExameService service;

	@Test
	public void findAllExame() throws Exception {
		
			ExameDTO dto = this.criandoObjeto();
			List<ExameDTO> reponseExame =  this.criandoListObjeto();
	        BDDMockito.given(service.findAll_Exame()).willReturn(reponseExame);
	        String json = new ObjectMapper().writeValueAsString(dto);

	        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
	                .get(root_api+"/exame")
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
			ExameDTO reponseExame =  this.criandoObjeto();
	        BDDMockito.given(service.find_Exame_id(id)).willReturn(reponseExame);
	        String json = new ObjectMapper().writeValueAsString(id);

	        //ação - execução
	        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
	                .get(root_api+"/exame-id/1")
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
			ExameDTO dto = this.criandoObjeto2();
			ExameDTO reponseExame =  this.criandoObjeto2();
	        BDDMockito.given(service.InsertExame(dto)).willReturn(reponseExame);
	        String json = new ObjectMapper().writeValueAsString(dto);

	        //ação - execução
	        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
	                .post(root_api+"/exame")
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
			ExameDTO dto = this.criandoObjeto();
			ExameDTO reponseExame =  this.criandoObjeto();
	        BDDMockito.given(service.UpdateExame(dto)).willReturn(reponseExame);
	        String json = new ObjectMapper().writeValueAsString(dto);

	        //ação - execução
	        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
	                .put(root_api+"/exame")
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON)
	                .content(json);
	        //resultado
	        mvc
	            .perform(request)
	            .andExpect(status().isOk());
		
	}
	
	private ExameDTO criandoObjeto() {
		return ExameDTO.builder()
				.idexame(1)
				.idtipoexame(null)
				.idprestador(1)
				.codbenef(1)
				.dataconsulta(null)
				.datasolicitacao(null)
				.statusexame(0)
				.build();
	}
	
	private ExameDTO criandoObjeto2() {
		return ExameDTO.builder()
				.idexame(null)
				.idtipoexame(null)
				.idprestador(1)
				.codbenef(1)
				.dataconsulta(null)
				.datasolicitacao(null)
				.statusexame(0)
				.build();
	}
	
	/*
	 * private agendamentoDTO criandoObjetoIdNull() { return
	 * agendamentoDTO.builder() .idprestador(1) .idtipoagendamento(null)
	 * .dataconsulta(null) .datasolicitacao(null) .statusAgendamento("1") .build();
	 * }
	 * 
	 * private exameDTO criandoObjetoParametro(int idagen,int idbenef,int
	 * idprestador,int status) { return exameDTO.builder() .idexame(idagen)
	 * .idtipoexame(null) .idprestador(idprestador) .idbenef(idbenef)
	 * .dataconsulta(null) .datasolicitacao(null) .statusexame(status) .build(); }
	 * 
	 * private exameDTO criandoObjetoNull() { return null; }
	 */
	
	
	private List<ExameDTO> criandoListObjeto() {
		return asList(
				ExameDTO.builder().idexame(1).idtipoexame(null).idprestador(1).codbenef(1).dataconsulta(null)
						.datasolicitacao(null).statusexame(0).build(),
				ExameDTO.builder().idexame(1).idtipoexame(null).idprestador(1).codbenef(1).dataconsulta(null)
						.datasolicitacao(null).statusexame(0).build(),
						ExameDTO.builder().idexame(1).idtipoexame(null).idprestador(1).codbenef(1).dataconsulta(null)
						.datasolicitacao(null).statusexame(0).build(),
						ExameDTO.builder().idexame(1).idtipoexame(null).idprestador(1).codbenef(1).dataconsulta(null)
						.datasolicitacao(null).statusexame(0).build(),
						ExameDTO.builder().idexame(1).idtipoexame(null).idprestador(1).codbenef(1).dataconsulta(null)
						.datasolicitacao(null).statusexame(0).build());
	}
	
	/*
	 * @LocalServerPort private int port;
	 * 
	 * @Test void contextLoads() { assertFalse(Boolean.FALSE); }
	 */

	/*
	 * @BeforeEach public void setUp() {
	 * RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	 * RestAssured.port = port; RestAssured.basePath = "/api-exame"; }
	 * 
	 * @Test public void deveBuscarExameSucesso() {
	 * given().accept(ContentType.JSON).when().get("/exame-id/2").then().statusCode(
	 * HttpStatus.OK.value()); }
	 * 
	 * @Test public void deveBuscarTodosOsExamesSucess() {
	 * given().accept(ContentType.JSON).when().get("/exame").then().statusCode(
	 * HttpStatus.OK.value()); }
	 * 
	 */
}
