package com.clinica.service;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.clinica.dto.agendamentoDTO;
import com.clinica.dto.exameDTO;
import com.clinica.dto.tipoagendamentoDTO;
import com.clinica.repository.tipoagendamentorepository;

@ExtendWith(SpringExtension.class)
public class TipoagendamentoTest {

	
	@InjectMocks
	tipoagendamentoService service;

	@Mock
	tipoagendamentorepository repository;

	List<tipoagendamentoDTO> listTipoAgendamento;

	agendamentoDTO tipoagendamento;
	agendamentoDTO tipoagendamento2;
	 
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void devePesquisaTodosOsexames() throws Exception{
		
		List<tipoagendamentoDTO> lista = this.criandoListObjeto();
		when(repository.findAll()).thenReturn(lista);
		List<tipoagendamentoDTO> tipoagenda = service.findAll_TipoAgendamento();
		
		assertEquals(lista,tipoagenda);
	}
		
	@Test
	public void devePesquisarComSucessoExameID() throws Exception
	{
		int id = 1;
		tipoagendamentoDTO agenda2 = this.criandoObjeto();
		
		when(repository.findByidtipoagendamento(id)).thenReturn(agenda2);
		tipoagendamentoDTO agenda3 = service.find_tipoAgendamento_id(id);
		
		assertEquals(agenda2,agenda3);
	}
	
	@Test
	public void deveInserirExameComSucesso() throws Exception{
		tipoagendamentoDTO tipoagenda;
		tipoagendamentoDTO tipoagenda2;
		
		tipoagenda2 = this.criandoObjeto();
		tipoagenda = this.criandoObjeto();
		
		
		when(repository.save(tipoagenda)).thenReturn(tipoagenda2);
		tipoagendamentoDTO tipoagenda3 = service.InsertTipoAgendamento(tipoagenda2);
		
		assertEquals(tipoagenda3,tipoagenda2);
	}
	
	
	@Test
	public void deveInserirExameErro() throws Exception {
		tipoagendamentoDTO tipoagenda;
		tipoagendamentoDTO tipoagenda2;

		tipoagenda2 = this.criandoObjeto();
		tipoagenda = this.criandoObjeto();

		when(repository.save(tipoagenda)).thenReturn(tipoagenda2);

		tipoagenda2.setIdtipoagendamento(null);
		Throwable exception = catchThrowable(() -> service.InsertTipoAgendamento(tipoagenda2));

		verify(repository, never()).save(tipoagenda2);
	}
	 
	
	@Test
	public void deveatualizartipoAgendamentoComSucesso() throws Exception{
		tipoagendamentoDTO tipoagenda;
		tipoagendamentoDTO tipoagenda2;
		
		tipoagenda2 = this.criandoObjeto();
		tipoagenda = this.criandoObjeto();
		
		
		when(repository.save(tipoagenda)).thenReturn(tipoagenda2);
		tipoagendamentoDTO tipoagenda3 = service.UpdateTipoAgendamento(tipoagenda2);
		
		assertEquals(tipoagenda3,tipoagenda2);
	}
	
	@Test
	public void deveUpdateErro() throws Exception {
		tipoagendamentoDTO tipoagenda;
		tipoagendamentoDTO tipoagenda2;

		tipoagenda2 = this.criandoObjetoIdNull();
		tipoagenda = this.criandoObjetoIdNull();

		when(repository.save(tipoagenda)).thenReturn(tipoagenda2);

		tipoagenda2.setIdtipoagendamento(null);
		Throwable exception = catchThrowable(() -> service.InsertTipoAgendamento(tipoagenda2));

		verify(repository, never()).save(tipoagenda2);
	}
	
	/*
	 * Book book = new Book();
	 * 
	 * org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
	 * () -> service.update(book));
	 * 
	 * Mockito.verify( repository, Mockito.never() ).save(book);
	 */	
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
	
	private tipoagendamentoDTO criandoObjeto2() {
		return tipoagendamentoDTO.builder()
				.idtipoagendamento(1)
				.nomeagendamento("vacina")
				.valor(300)
				.statusAgendamento("1")
				.tipo(1)
				.datacriacao(null)
				.build();
	}
	
	private tipoagendamentoDTO criandoObjetoIdNull() {
		return tipoagendamentoDTO.builder()
				.idtipoagendamento(null)
				.nomeagendamento("vacina")
				.valor(300)
				.statusAgendamento("1")
				.tipo(1)
				.datacriacao(null)
				.build();
	}
		
	private tipoagendamentoDTO criandoObjetoNull() {
		return null;
	}
	
	
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
