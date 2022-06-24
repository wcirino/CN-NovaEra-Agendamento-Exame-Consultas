package com.clinica.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.Before;

import com.clinica.dto.agendamentoDTO;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static java.util.Arrays.asList;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class AgendamentoServiceTest {
	
	@Mock
	agendamentoService service;
	
	String nome;
	
	List<agendamentoDTO> listAgendamento;
	
	agendamentoDTO agendamento;
	
	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		this.nome = "Willyan fernando";
		this.agendamento = this.criandoObjeto();
		this.listAgendamento = this.criandoListObjeto();
	}
	   
	@Test
	public void novoteste() {
		assertTrue(!(this.nome == "Willyan fernando"));
	}
	
	@Test
	public void devePesquisarTodosAgendamento() throws Exception{
		when(service.findAll_agendamento()).thenReturn(this.listAgendamento);
		assertTrue(this.criandoListObjeto().size() > 0);
		
	}
	
	@Test
	public void devePesquisarporIdsucesso() throws Exception{
		int id = 1;
		this.agendamento = this.criandoObjeto();
		when(service.find_Agendamento_id(id)).thenReturn(agendamento);
		assertNotNull(this.agendamento);
	}
	
	@Test
	public void devePesquisarporIdRetornaNull() throws Exception{
		int id = 0;
		when(service.find_Agendamento_id(id)).thenReturn(agendamento);
		assertNull(this.criandoObjetoNull());
	}
	
	@Test
	public void devePesquisarporIdRetornaNullException() throws Exception{
		int id = 0;
		when(service.find_Agendamento_id(id)).thenReturn(agendamento);
		assertNull(this.criandoObjetoNull());
	}
	
	@Test
	public void devePesquisarporIdsucessoNovoteste() throws Exception{
		int id = 1;
		this.agendamento = this.criandoObjeto();
		when(service.find_Agendamento_id(id)).thenReturn(agendamento);
		Optional<agendamentoDTO> agenda = Optional.of(service.find_Agendamento_id(id));
		agendamentoDTO agenda2 = service.find_Agendamento_id(id); 
		assertThat(agenda.isPresent()).isTrue();
	}
	
	//@Test
	public void devePesquisarporIdLancarException() throws Exception{
		int id = 1;
		this.agendamento = this.criandoObjeto();
		when(service.find_Agendamento_id(id)).thenReturn(agendamento);
		Optional<agendamentoDTO> agenda = Optional.of(service.find_Agendamento_id(id));
		
		 //execucao
        Throwable exception = catchThrowable(() -> service.findAll_agendamento());

        //verificacoes
        //assertThat(exception)
          //      .isInstanceOf(Exception.class)
          //      .hasMessage("Isbn já cadastrado.");
        
       // verify(null)
	}
	
	
	
	/*
	 * public agendamentoDTO Insertagendamento(agendamentoDTO dto) throws Exception{
	 * if(!agendamentoproxy.existsById(dto.getIdagendamento())) { agendamentoDTO obj
	 * = agendamentoproxy.save(dto); return obj; } else { throw new
	 * Exception("O agendamento  possui Id"); } }
	 * 
	 * public agendamentoDTO Updategendamento(agendamentoDTO dto) throws Exception{
	 * if(agendamentoproxy.existsById(dto.getIdagendamento())) { agendamentoDTO obj
	 * = agendamentoproxy.save(dto); return obj; } else { throw new
	 * Exception("O agendamento não possui Id"); } }
	 */
	
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
	
	private agendamentoDTO criandoObjetoNull() {
		return null;
	}
	
	
	private List<agendamentoDTO> criandoListObjeto() {
		return asList(agendamentoDTO.builder().idagendamento(1).idbenef(1).idprestador(1).idtipoagendamento(null)
				.dataconsulta(null).datasolicitacao(null).statusAgendamento("1").build(),
				 agendamentoDTO.builder().idagendamento(2).idbenef(2).idprestador(2).idtipoagendamento(null)
				.dataconsulta(null).datasolicitacao(null).statusAgendamento("1").build(),
				agendamentoDTO.builder().idagendamento(3).idbenef(3).idprestador(3).idtipoagendamento(null)
				.dataconsulta(null).datasolicitacao(null).statusAgendamento("1").build(),
				 agendamentoDTO.builder().idagendamento(4).idbenef(4).idprestador(4).idtipoagendamento(null)
				.dataconsulta(null).datasolicitacao(null).statusAgendamento("1").build(),//---------------------
				agendamentoDTO.builder().idagendamento(5).idbenef(5).idprestador(5).idtipoagendamento(null)
				.dataconsulta(null).datasolicitacao(null).statusAgendamento("1").build(),
				 agendamentoDTO.builder().idagendamento(6).idbenef(6).idprestador(6).idtipoagendamento(null)
				.dataconsulta(null).datasolicitacao(null).statusAgendamento("1").build());
	}
	
	

}
