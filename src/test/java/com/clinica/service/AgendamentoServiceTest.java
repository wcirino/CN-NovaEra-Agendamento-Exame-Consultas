package com.clinica.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.Before;

import com.clinica.dto.agendamentoDTO;
import com.clinica.repository.AgendamentoRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;
import static java.util.Arrays.asList;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class AgendamentoServiceTest {
	
	@Mock
	agendamentoService service;
	
	@Mock
	AgendamentoRepository repository;
	
	String nome;
	
	List<agendamentoDTO> listAgendamento;
	
	agendamentoDTO agendamento;
	agendamentoDTO agendamento2;
	
	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		this.nome = "Willyan fernando";
		this.agendamento = this.criandoObjeto();
		this.listAgendamento = this.criandoListObjeto();
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
	
	@Test
	public void deveInserirAgendamentoSucesso() throws Exception {
		agendamentoDTO agenda = agendamentoDTO.builder().idagendamento(0)
														.idbenef(9)
														.idprestador(9)
														.idtipoagendamento(null)
														.dataconsulta(null)
														.datasolicitacao(null)
														.statusAgendamento("novo")
														.build();

		when(repository.save(agenda)).thenReturn(agendamentoDTO.builder().idagendamento(99)
				.idbenef(9)
				.idprestador(9)
				.idtipoagendamento(null)
				.dataconsulta(null)
				.datasolicitacao(null)
				.statusAgendamento("novo")
				.build());
		
		when(service.Insertagendamento(agenda)).thenReturn(agendamentoDTO.builder().idagendamento(99)
				.idbenef(9)
				.idprestador(9)
				.idtipoagendamento(null)
				.dataconsulta(null)
				.datasolicitacao(null)
				.statusAgendamento("novo")
				.build());
		
		agendamentoDTO agenda2 = service.Insertagendamento(agenda);
		assertNotEquals(agenda2,agenda);
	}
	
	@Test
	public void naoDeveInserirAgendamento() throws Exception{
		int id = 1;
		
		this.agendamento = this.criandoObjetoNull();
		this.agendamento2 = this.criandoObjetoIdNull();
		
		when(service.Insertagendamento(agendamento)).thenReturn(agendamento);
		
        //execucao
        Throwable exception = catchThrowable(() -> service.Insertagendamento(agendamento));

        verify(repository,never()).save(agendamento);
	}
	
	
	@Test
	public void naoDeveAtualizaragendamento() throws Exception{

		this.agendamento = this.criandoObjetoNull();
		when(service.Updategendamento(agendamento)).thenReturn(agendamento);
		
        //execucao
        Throwable exception = catchThrowable(() -> service.Updategendamento(agendamento));

        verify(repository,never()).save(agendamento);
	}
	
	@Test
	public void deveAtualizarAgendamento() throws Exception{

		//cenario
		int id = 1;
		agendamentoDTO agenda = agendamentoDTO.builder().idagendamento(id).build();
		
		//simulação
		agendamentoDTO agenda4 = this.criandoObjeto();
		//when(repository.save(agenda)).thenReturn(agenda4);
		
		//ação
		when(service.Updategendamento(agenda)).thenReturn(agenda4);
		
		agendamentoDTO agenda5 = service.Updategendamento(agenda);
		
		assertEquals(agenda.getIdagendamento(),agenda4.getIdagendamento());
		
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
	
	private agendamentoDTO criandoObjetoIdNull() {
		return agendamentoDTO.builder()
				.idbenef(1)
				.idprestador(1)
				.idtipoagendamento(null)
				.dataconsulta(null)
				.datasolicitacao(null)
				.statusAgendamento("1")
				.build();
	}
	
	private agendamentoDTO criandoObjetoParametro(int idagen,int idbenef,int idprestador,String status) {
		return agendamentoDTO.builder()
				.idagendamento(idagen)
				.idbenef(idbenef)
				.idprestador(idprestador)
				.idtipoagendamento(null)
				.dataconsulta(null)
				.datasolicitacao(null)
				.statusAgendamento(status)
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
				.dataconsulta(null).datasolicitacao(null).statusAgendamento("1").build(),
				agendamentoDTO.builder().idagendamento(5).idbenef(5).idprestador(5).idtipoagendamento(null)
				.dataconsulta(null).datasolicitacao(null).statusAgendamento("1").build(),
				 agendamentoDTO.builder().idagendamento(6).idbenef(6).idprestador(6).idtipoagendamento(null)
				.dataconsulta(null).datasolicitacao(null).statusAgendamento("1").build());
	}
	
	

}
