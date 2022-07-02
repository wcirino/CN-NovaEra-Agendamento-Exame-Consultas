package com.clinica.service;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.catchThrowable;
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

import com.clinica.dto.tipoExameDTO;
import com.clinica.repository.tipoExameRespository;

@ExtendWith(SpringExtension.class)
public class TipoExameServiceTest {

	@InjectMocks
	tipoExameService service;
	
	@Mock
	tipoExameRespository repository;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void devePesquisaTodosOsexames() throws Exception{
		
		List<tipoExameDTO> lista = this.criandoListObjeto();
		when(repository.findAll()).thenReturn(lista);
		List<tipoExameDTO> tipoagenda = service.findAll_TipoExame();
		
		assertEquals(lista,tipoagenda);
	}
		
	@Test
	public void devePesquisarComSucessoExameID() throws Exception
	{
		int id = 1;
		tipoExameDTO agenda2 = this.criandoObjeto();
		
		when(repository.findByidtipoexame(id)).thenReturn(agenda2);
		tipoExameDTO agenda3 = service.find_tipoExame_id(id);
		
		assertEquals(agenda2,agenda3);
	}
	
	@Test
	public void deveInserirExameComSucesso() throws Exception{
		tipoExameDTO tipoagenda;
		tipoExameDTO tipoagenda2;
		
		tipoagenda2 = this.criandoObjeto();
		tipoagenda = this.criandoObjeto();
		
		tipoagenda.setIdtipoexame(null);
		when(repository.save(tipoagenda)).thenReturn(tipoagenda2);
		tipoExameDTO tipoagenda3 = service.InsertExame(tipoagenda);
		
		assertEquals(tipoagenda3,tipoagenda2);
	}
	
	
	@Test
	public void deveInserirExameErro() throws Exception {
		tipoExameDTO tipoagenda;
		tipoExameDTO tipoagenda2;

		tipoagenda2 = this.criandoObjeto();
		tipoagenda = this.criandoObjeto();

		when(repository.save(tipoagenda)).thenReturn(tipoagenda2);

		tipoagenda2.setIdtipoexame(12);
		Throwable exception = catchThrowable(() -> service.InsertExame(tipoagenda2));

		verify(repository, never()).save(tipoagenda2);
	}
	 
	
	@Test
	public void deveatualizartipoAgendamentoComSucesso() throws Exception{
		tipoExameDTO tipoagenda;
		tipoExameDTO tipoagenda2;
		
		tipoagenda2 = this.criandoObjeto();
		tipoagenda = this.criandoObjeto();
		
		
		when(repository.save(tipoagenda)).thenReturn(tipoagenda2);
		tipoExameDTO tipoagenda3 = service.UpdateExame(tipoagenda);
		
		assertEquals(tipoagenda3,tipoagenda2);
	}
	
	@Test
	public void deveUpdateErro() throws Exception {
		tipoExameDTO tipoagenda;
		tipoExameDTO tipoagenda2;

		tipoagenda2 = this.criandoObjetoIdNull();
		tipoagenda = this.criandoObjetoIdNull();

		when(repository.save(tipoagenda)).thenReturn(tipoagenda2);

		tipoagenda2.setIdtipoexame(12);
		Throwable exception = catchThrowable(() -> service.UpdateExame(tipoagenda2));

		verify(repository, never()).save(tipoagenda2);
	}
	
	@Test
	public void deveUpdateErroDtoNull() throws Exception {
		tipoExameDTO tipoagenda;
		tipoExameDTO tipoagenda2;

		tipoagenda2 = this.criandoObjetoNull();
		tipoagenda = this.criandoObjetoNull();

		when(repository.save(tipoagenda)).thenReturn(tipoagenda2);

//		tipoagenda2.setIdtipoexame(12);
		Throwable exception = catchThrowable(() -> service.UpdateExame(tipoagenda2));

		verify(repository, never()).save(tipoagenda2);
	}
	
	@Test
	public void deveInserirExameErroDtoNull() throws Exception {
		tipoExameDTO tipoagenda;
		tipoExameDTO tipoagenda2;

		tipoagenda2 = this.criandoObjetoNull();
		tipoagenda = this.criandoObjetoNull();

		when(repository.save(tipoagenda)).thenReturn(tipoagenda2);

		Throwable exception = catchThrowable(() -> service.InsertExame(tipoagenda2));

		verify(repository, never()).save(tipoagenda2);
	}
	
	private tipoExameDTO criandoObjeto() {
		return tipoExameDTO.builder()
				.idtipoexame(1)
				.nome_exame("vacina")
				.valor(300)
				.datainsert(null)
				.build();				
	}
	
	private tipoExameDTO criandoObjeto2() {
		return tipoExameDTO.builder()
				.idtipoexame(1)
				.nome_exame("vacina")
				.valor(300)
				.datainsert(null)
				.build();
	}
	
	private tipoExameDTO criandoObjetoIdNull() {
		return tipoExameDTO.builder()
				.idtipoexame(null)
				.nome_exame("vacina")
				.valor(300)
				.datainsert(null)
				.build();
	}
		
	private tipoExameDTO criandoObjetoNull() {
		return null;
	}
	
	
	private List<tipoExameDTO> criandoListObjeto() {
		return asList(
				tipoExameDTO.builder().idtipoexame(1).nome_exame("vacina").valor(300)
		.datainsert(null).build(),
				tipoExameDTO.builder().idtipoexame(1).nome_exame("vacina").valor(300)
		.datainsert(null).build(),
				tipoExameDTO.builder().idtipoexame(1).nome_exame("vacina").valor(300)
		.datainsert(null).build(),
				tipoExameDTO.builder().idtipoexame(1).nome_exame("vacina").valor(300)
		.datainsert(null).build(),
				tipoExameDTO.builder().idtipoexame(1).nome_exame("vacina").valor(300)
		.datainsert(null).build());
	}
	
}
