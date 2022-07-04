package com.clinica.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.clinica.dto.agendamentoDTO;
import com.clinica.repository.AgendamentoRepository;


import static org.assertj.core.api.Assertions.catchThrowable;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static java.util.Arrays.asList;

import java.util.List;

@ExtendWith(SpringExtension.class)
public class AgendamentoServiceTest {
	
	@InjectMocks
	agendamentoService service;
	
	@Mock
	AgendamentoRepository repository;
	
	String nome;
	
	List<agendamentoDTO> listAgendamento;
	
	agendamentoDTO agendamento;
	agendamentoDTO agendamento2;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		this.nome = "Willyan fernando";
		this.agendamento = this.criandoObjeto();
		this.listAgendamento = this.criandoListObjeto();
	}
	   
	
	@Test
	public void devePesquisarTodosAgendamento() throws Exception{
		
		when(repository.findAll()).thenReturn(this.listAgendamento);
		List<agendamentoDTO> listAgendamento3 =  service.findAll_agendamento();
		 		
		assertTrue(listAgendamento3.size() > 0);
		
	}
	
	@Test
	public void devePesquisarporIdsucesso() throws Exception{
		int id = 1;
		this.agendamento = this.criandoObjeto();
		
		when(repository.findByidagendamento(id)).thenReturn(agendamento);
		agendamentoDTO agendaDTO = service.find_Agendamento_id(id);
		
		assertEquals(this.agendamento,agendaDTO);
	}
	
	@Test
	public void deveInserirAgendamentoSucesso() throws Exception {
		agendamentoDTO agenda = agendamentoDTO.builder().idagendamento(null)
														.idbenef(9)
														.idprestador(9)
														.idtipoagendamento(null)
														.dataconsulta(null)
														.datasolicitacao(null)
														.statusAgendamento("novo")
														.build();

		when(repository.save(agenda)).thenReturn(agendamentoDTO.builder().idagendamento(null)
				.idbenef(9)
				.idprestador(9)
				.idtipoagendamento(null)
				.dataconsulta(null)
				.datasolicitacao(null)
				.statusAgendamento("novo")
				.build());
		
		service.Insertagendamento(agenda);
		
		agendamentoDTO agenda2 = service.Insertagendamento(agenda);
		assertEquals(agenda2,agenda);
	}
		
	@Test
	public void deveAtualizarAgendamento() throws Exception{

		//cenario
		int id = 1;
		agendamentoDTO agenda = agendamentoDTO.builder().idagendamento(id).build();
		
		//simulação
		agendamentoDTO agenda4 = this.criandoObjeto();
		agendamentoDTO agenda6 = this.criandoObjeto();
		//when(repository.save(agenda)).thenReturn(agenda4);
		
		//ação
		when(repository.save(agenda4)).thenReturn(agenda6);
		
		assertEquals(agenda.getIdagendamento(),agenda4.getIdagendamento());
		
	}
	
	@Test
	public void deveInserirAgendamentoErro() throws Exception{
		agendamentoDTO agenda3;
		agendamentoDTO agenda4;
		
		this.agendamento = this.criandoObjeto2();
		agenda4 = this.criandoObjeto2();
		
		
		when(repository.save(agendamento)).thenReturn(agenda4);
		
		agendamento.setIdagendamento(1);
		Throwable exception = catchThrowable(() -> service.Insertagendamento(agendamento));
		
		verify(repository,never()).save(agendamento);
	}
	
	@Test
	public void deveInserirAgendamentoErroDtoNull() throws Exception{
		agendamentoDTO agenda3;
		agendamentoDTO agenda4;
		
		this.agendamento = this.criandoObjetoNull();
		agenda4 = this.criandoObjetoNull();
		
		
		when(repository.save(agendamento)).thenReturn(agenda4);
		
//		agendamento.setIdagendamento(1);
		Throwable exception = catchThrowable(() -> service.Insertagendamento(agendamento));
		
		verify(repository,never()).save(agendamento);
	}
	
	@Test
	public void deveUpdateAgendamentoErro() throws Exception{
		agendamentoDTO agenda3;
		agendamentoDTO agenda4;
		
		this.agendamento = this.criandoObjeto2();
		agenda4 = this.criandoObjeto2();
		
		
		when(repository.save(agendamento)).thenReturn(agenda4);
		
		//agendamento.setIdagendamento(1);
		Throwable exception = catchThrowable(() -> service.Updategendamento(agendamento));
		
		verify(repository,never()).save(agendamento);
	}
	
	
	@Test
	public void deveUpdateAgendamentoErroDtoNull() throws Exception{
		agendamentoDTO agenda3;
		agendamentoDTO agenda4;
		
		this.agendamento = this.criandoObjetoNull();
		agenda4 = this.criandoObjetoNull();
		
		
		when(repository.save(agendamento)).thenReturn(agenda4);
		
		//agendamento.setIdagendamento(1);
		Throwable exception = catchThrowable(() -> service.Updategendamento(agendamento));
		
		verify(repository,never()).save(agendamento);
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
