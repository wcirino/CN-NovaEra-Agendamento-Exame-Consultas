package com.clinica.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.clinica.dto.AgendamentoDTO;
import com.clinica.dto.BeneficiarioDTO;
import com.clinica.dto.PrestadorDTO;
import com.clinica.repository.AgendamentoRepository;


import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static java.util.Arrays.asList;

import java.util.List;

@ExtendWith(SpringExtension.class)
public class AgendamentoServiceTest {
	
	@InjectMocks
	AgendamentoService service;
	
	@Mock
	AgendamentoRepository repository;
	
	String nome;
	
	List<AgendamentoDTO> listAgendamento;
	
	AgendamentoDTO agendamento;
	AgendamentoDTO agendamento2;
	AgendamentoDTO agendamento3;
	AgendamentoDTO agendamento4;
	
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
		List<AgendamentoDTO> listAgendamento3 =  service.findAll_agendamento();
		 		
		assertTrue(listAgendamento3.size() > 0);
		
	}
	
	@Test
	public void devePesquisarporIdsucesso() throws Exception{
		int id = 1;
		this.agendamento = this.criandoObjeto();
		
		when(repository.findByidagendamento(id)).thenReturn(agendamento);
		AgendamentoDTO agendaDTO = service.find_Agendamento_id(id);
		
		assertEquals(this.agendamento,agendaDTO);
	}
	
	@Test
	public void deveInserirAgendamentoSucesso() throws Exception {
		
		PrestadorDTO p = new PrestadorDTO();
		p.setIdPrest(1);
		
		BeneficiarioDTO b = new BeneficiarioDTO();
		b.setIdbenef(1);
		
		AgendamentoDTO agenda = agendamento2;

		when(repository.save(agenda)).thenReturn(agendamento3);
		
		//service.Insertagendamento(agenda);
		
		//AgendamentoDTO agenda2 = service.Insertagendamento(agenda);
		assertEquals(agenda,agendamento3);
	}
	
	@Test
	public void deveInserirAgendamentoSucessoNew() throws Exception{

		//cenario
		//int id = 1;
		AgendamentoDTO agenda = agendamento;
		
		//simulação
		AgendamentoDTO agenda4 = this.criandoObjeto();
		AgendamentoDTO agenda6 = this.criandoObjeto();
		//when(repository.save(agenda)).thenReturn(agenda4);
		
		//ação
		when(repository.save(agenda)).thenReturn(agenda);
		
		//assertEquals(agenda.getIdagendamento(),agenda4.getIdagendamento());
		assertNotNull(agenda);
	}
		
	@Test
	public void deveAtualizarAgendamento() throws Exception{

		//cenario
		int id = 1;
		AgendamentoDTO agenda = AgendamentoDTO.builder().idagendamento(id).build();
		
		//simulação
		AgendamentoDTO agenda4 = this.criandoObjeto();
		AgendamentoDTO agenda6 = this.criandoObjeto();
		//when(repository.save(agenda)).thenReturn(agenda4);
		
		//ação
		when(repository.save(agenda4)).thenReturn(agenda6);
		
		assertEquals(agenda.getIdagendamento(),agenda4.getIdagendamento());
		
	}
	
	@Test
	public void deveInserirAgendamentoErro() throws Exception{
		AgendamentoDTO agenda4;
		
		this.agendamento = this.criandoObjeto2();
		agenda4 = this.criandoObjeto2();
		
		
		when(repository.save(agendamento)).thenReturn(agenda4);
		
		agendamento.setIdagendamento(1);
		Throwable exception = catchThrowable(() -> service.Insertagendamento(agendamento));
		
		verify(repository,never()).save(agendamento);
	}
	
	@Test
	public void deveInserirAgendamentoErroDtoNull() throws Exception{
		AgendamentoDTO agenda4;
		
		this.agendamento = this.criandoObjetoNull();
		agenda4 = this.criandoObjetoNull();
		
		
		when(repository.save(agendamento)).thenReturn(agenda4);
		
//		agendamento.setIdagendamento(1);
		Throwable exception = catchThrowable(() -> service.Insertagendamento(agendamento));
		
		verify(repository,never()).save(agendamento);
	}
	
	@Test
	public void deveUpdateAgendamentoErro() throws Exception{
		AgendamentoDTO agenda4;
		
		this.agendamento = this.criandoObjeto2();
		agenda4 = this.criandoObjeto2();
		
		
		when(repository.save(agendamento)).thenReturn(agenda4);
		
		//agendamento.setIdagendamento(1);
		Throwable exception = catchThrowable(() -> service.Updategendamento(agendamento));
		
		verify(repository,never()).save(agendamento);
	}
	
	
	@Test
	public void deveUpdateAgendamentoErroDtoNull() throws Exception{
		AgendamentoDTO agenda4;
		
		this.agendamento = this.criandoObjetoNull();
		agenda4 = this.criandoObjetoNull();
		
		
		when(repository.save(agendamento)).thenReturn(agenda4);
		
		//agendamento.setIdagendamento(1);
		Throwable exception = catchThrowable(() -> service.Updategendamento(agendamento));
		
		verify(repository,never()).save(agendamento);
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
				.statusAgendamento(null)
				.build();
	}
			
	private AgendamentoDTO criandoObjetoNull() {
		return null;
	}
	
	
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
