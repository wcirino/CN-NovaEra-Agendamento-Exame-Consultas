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

import com.clinica.dto.AgendamentoDTO;
import com.clinica.dto.TipoAgendamentoDTO;
import com.clinica.repository.TipoAgendamentorepository;

@ExtendWith(SpringExtension.class)
public class TipoagendamentoServiceTest {

	
	@InjectMocks
	TipoAgendamentoService service;

	@Mock
	TipoAgendamentorepository repository;

	List<TipoAgendamentoDTO> listTipoAgendamento;

	AgendamentoDTO tipoagendamento;
	AgendamentoDTO tipoagendamento2;
	 
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void devePesquisaTodosOsexames() throws Exception{
		
		List<TipoAgendamentoDTO> lista = this.criandoListObjeto();
		when(repository.findAll()).thenReturn(lista);
		List<TipoAgendamentoDTO> tipoagenda = service.findAll_TipoAgendamento();
		
		assertEquals(lista,tipoagenda);
	}
		
	@Test
	public void devePesquisarComSucessoExameID() throws Exception
	{
		int id = 1;
		TipoAgendamentoDTO agenda2 = this.criandoObjeto();
		
		when(repository.findByidtipoagendamento(id)).thenReturn(agenda2);
		TipoAgendamentoDTO agenda3 = service.find_tipoAgendamento_id(id);
		
		assertEquals(agenda2,agenda3);
	}
	
	@Test
	public void deveInserirExameComSucesso() throws Exception{
		TipoAgendamentoDTO tipoagenda;
		TipoAgendamentoDTO tipoagenda2;
		
		tipoagenda2 = this.criandoObjeto();
		tipoagenda = this.criandoObjeto();
		
		tipoagenda.setIdtipoagendamento(null);
		when(repository.save(tipoagenda)).thenReturn(tipoagenda2);
		
		TipoAgendamentoDTO tipoagenda3 = service.InsertTipoAgendamento(tipoagenda);
		
		assertEquals(tipoagenda3,tipoagenda2);
	}
	
	
	@Test
	public void deveInserirExameErro() throws Exception {
		TipoAgendamentoDTO tipoagenda;
		TipoAgendamentoDTO tipoagenda2;

		tipoagenda2 = this.criandoObjeto();
		tipoagenda = this.criandoObjeto();

		when(repository.save(tipoagenda)).thenReturn(tipoagenda2);

		tipoagenda2.setIdtipoagendamento(1);
		Throwable exception = catchThrowable(() -> service.InsertTipoAgendamento(tipoagenda2));

		verify(repository, never()).save(tipoagenda2);
	}
	 
	
	@Test
	public void deveatualizartipoAgendamentoComSucesso() throws Exception{
		TipoAgendamentoDTO tipoagenda;
		TipoAgendamentoDTO tipoagenda2;
		
		tipoagenda2 = this.criandoObjeto();
		tipoagenda = this.criandoObjeto();
		
		
		when(repository.save(tipoagenda)).thenReturn(tipoagenda2);
		TipoAgendamentoDTO tipoagenda3 = service.UpdateTipoAgendamento(tipoagenda2);
		
		assertEquals(tipoagenda3,tipoagenda2);
	}
	
	@Test
	public void deveUpdateErro() throws Exception {
		TipoAgendamentoDTO tipoagenda;
		TipoAgendamentoDTO tipoagenda2;

		tipoagenda2 = this.criandoObjetoIdNull();
		tipoagenda = this.criandoObjetoIdNull();

		when(repository.save(tipoagenda)).thenReturn(tipoagenda2);

		tipoagenda2.setIdtipoagendamento(null);
		Throwable exception = catchThrowable(() -> service.UpdateTipoAgendamento(tipoagenda2));

		verify(repository, never()).save(tipoagenda2);
	}
	
	@Test
	public void deveUpdateErroDtoNull() throws Exception {
		TipoAgendamentoDTO tipoagenda;
		TipoAgendamentoDTO tipoagenda2;

		tipoagenda2 = this.criandoObjetoNull();
		tipoagenda = this.criandoObjetoNull();

		when(repository.save(tipoagenda)).thenReturn(tipoagenda2);

//		tipoagenda2.setIdtipoagendamento(null);
		Throwable exception = catchThrowable(() -> service.UpdateTipoAgendamento(tipoagenda2));

		verify(repository, never()).save(tipoagenda2);
	}
	
	@Test
	public void deveInserirExameErroDtoNull() throws Exception {
		TipoAgendamentoDTO tipoagenda;
		TipoAgendamentoDTO tipoagenda2;

		tipoagenda2 = this.criandoObjetoNull();
		tipoagenda = this.criandoObjetoNull();

		when(repository.save(tipoagenda)).thenReturn(tipoagenda2);

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
	private TipoAgendamentoDTO criandoObjeto() {
		return TipoAgendamentoDTO.builder()
				.idtipoagendamento(1)
				.nomeagendamento("vacina")
				.valor(300)
				.statusAgendamento("1")
				.tipo(1)
				.datacriacao(null)
				.build();				
	}
	
	private TipoAgendamentoDTO criandoObjeto2() {
		return TipoAgendamentoDTO.builder()
				.idtipoagendamento(1)
				.nomeagendamento("vacina")
				.valor(300)
				.statusAgendamento("1")
				.tipo(1)
				.datacriacao(null)
				.build();
	}
	
	private TipoAgendamentoDTO criandoObjetoIdNull() {
		return TipoAgendamentoDTO.builder()
				.idtipoagendamento(null)
				.nomeagendamento("vacina")
				.valor(300)
				.statusAgendamento("1")
				.tipo(1)
				.datacriacao(null)
				.build();
	}
		
	private TipoAgendamentoDTO criandoObjetoNull() {
		return null;
	}
	
	
	private List<TipoAgendamentoDTO> criandoListObjeto() {
		return asList(
				TipoAgendamentoDTO.builder().idtipoagendamento(1).nomeagendamento("vacina").valor(300)
						.statusAgendamento("1").tipo(1).datacriacao(null).build(),
				TipoAgendamentoDTO.builder().idtipoagendamento(1).nomeagendamento("vacina").valor(300)
						.statusAgendamento("1").tipo(1).datacriacao(null).build(),
				TipoAgendamentoDTO.builder().idtipoagendamento(1).nomeagendamento("vacina").valor(300)
						.statusAgendamento("1").tipo(1).datacriacao(null).build(),
				TipoAgendamentoDTO.builder().idtipoagendamento(1).nomeagendamento("vacina").valor(300)
						.statusAgendamento("1").tipo(1).datacriacao(null).build(),
				TipoAgendamentoDTO.builder().idtipoagendamento(1).nomeagendamento("vacina").valor(300)
						.statusAgendamento("1").tipo(1).datacriacao(null).build());
	}
	
}
