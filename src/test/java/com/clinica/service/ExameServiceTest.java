package com.clinica.service;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.clinica.dto.AgendamentoDTO;
import com.clinica.dto.ExameDTO;
import com.clinica.entity.exame;
import com.clinica.repository.ExameRepository;


@ExtendWith(SpringExtension.class)
public class ExameServiceTest {

	@InjectMocks
	ExameService service;
	
	@Mock
	ExameRepository repository;
	
	List<ExameDTO> listExame; 
	
	ExameDTO exame;
	ExameDTO exame2;
	
	@BeforeEach
	public void setUp() {
		this.listExame = this.criandoListObjeto();; 
	}
	
	@Test
	public void devePesquisaTodosOsexames() throws Exception{
		
		List<ExameDTO> listExame = this.criandoListObjeto();
		when(repository.findAll()).thenReturn(this.listExame);
		List<ExameDTO> exame3 = service.findAll_Exame();
		
		assertEquals(this.listExame,exame3);
	}
	
	@Test
	public void devePesquisaTodosOsexamesLista() throws Exception{
		
		List<ExameDTO> listExame = this.criandoListObjeto();
		
		when(repository.findAll()).thenReturn(this.listExame);
		List<ExameDTO> exame3 = service.findAll_Exame();
		
		assertTrue(exame3.size() > 1);
	}
	
	@Test
	public void devePesquisarComSucessoExameID() throws Exception
	{
		int id = 1;
		ExameDTO exame3;
		this.exame = this.criandoObjeto();
		
		when(repository.findByidexame(id)).thenReturn(this.exame);
		exame3 = service.find_Exame_id(id);
		
		assertEquals(exame3,this.exame);
	}
		
	@Test
	public void devePesquisarComSucessoExameIDZero() throws Exception
	{
		int id = 0;
		ExameDTO exame3;
		this.exame = this.criandoObjeto();
		
		when(repository.findByidexame(id)).thenReturn(this.exame);
		Throwable exception = catchThrowable(() -> service.find_Exame_id(id));
		
		verify(repository,never()).findByidexame(id);
	}
	
	@Test
	public void deveInserirExameComSucesso() throws Exception{
		ExameDTO exame3;
		ExameDTO exame4;
		
		this.exame = this.criandoObjeto();
		exame4 = this.criandoObjeto();
		
		this.exame.setIdexame(null);
		when(repository.save(exame)).thenReturn(exame4);
		exame3 = service.InsertExame(exame);
		
		assertNotNull(exame3);
	}
	
	@Test
	public void deveInserirExameErro() throws Exception{
		ExameDTO exame3;
		ExameDTO exame4;
		
		this.exame = this.criandoObjeto2();
		exame4 = this.criandoObjeto2();
		
		
		when(repository.save(exame)).thenReturn(exame4);
		
		exame.setIdexame(1);
		Throwable exception = catchThrowable(() -> service.InsertExame(exame));
		
		verify(repository,never()).save(exame);
	}
	
	@Test
	public void deveInserirExameErroDtoNull() throws Exception{
		ExameDTO exame3;
		ExameDTO exame4;
		
		this.exame = this.criandoObjetoNull();
		exame4 = this.criandoObjetoNull();
		
		
		when(repository.save(exame)).thenReturn(exame4);
		
		Throwable exception = catchThrowable(() -> service.InsertExame(exame));
		
		verify(repository,never()).save(exame);
	}
	
	
	@Test
	public void deveAtualizarExameComSucesso() throws Exception{
		ExameDTO exame3;
		ExameDTO exame4;
		
		this.exame = this.criandoObjeto();
		exame4 = this.criandoObjeto();
		
		
		when(repository.save(exame)).thenReturn(exame4);
		exame3 = service.UpdateExame(exame);
		
		assertEquals(exame3,exame);
	}
	

	
	@Test
	public void deveAtualizarExameComSucessoNever() throws Exception{
		
		ExameDTO exame3;
		ExameDTO exame4;
		
		this.exame = this.criandoObjeto2();
		exame4 = this.criandoObjeto2();
		
		this.exame.setIdexame(null);
		when(repository.save(exame)).thenReturn(exame4);		
		Throwable exception = catchThrowable(() ->service.UpdateExame(exame));
		
		verify(repository,never()).save(exame);
	}
	
	@Test
	public void deveUpdateExameErroDtoNull() throws Exception{
		ExameDTO exame3;
		ExameDTO exame4;
		
		this.exame = this.criandoObjetoNull();
		exame4 = this.criandoObjetoNull();
		
		
		when(repository.save(exame)).thenReturn(exame4);
		
		Throwable exception = catchThrowable(() -> service.UpdateExame(exame));
		
		verify(repository,never()).save(exame);
	}
			
	private ExameDTO criandoObjeto() {
		return ExameDTO.builder()
				.idexame(1)
				.idtipoexame(null)
				.idprestador(1)
				.idbenef(1)
				.dataconsulta(null)
				.datasolicitacao(null)
				.statusexame(0)
				.build();
	}
	
	private ExameDTO criandoObjeto2() {
		return ExameDTO.builder()
				.idexame(0)
				.idtipoexame(null)
				.idprestador(1)
				.idbenef(1)
				.dataconsulta(null)
				.datasolicitacao(null)
				.statusexame(0)
				.build();
	}
	
	private AgendamentoDTO criandoObjetoIdNull() {
		return AgendamentoDTO.builder()
				.idprestador(1)
				.idtipoagendamento(null)
				.dataconsulta(null)
				.datasolicitacao(null)
				.statusAgendamento("1")
				.build();
	}
	
	private ExameDTO criandoObjetoParametro(int idagen,int idbenef,int idprestador,int status) {
		return ExameDTO.builder()
				.idexame(idagen)
				.idtipoexame(null)
				.idprestador(idprestador)
				.idbenef(idbenef)
				.dataconsulta(null)
				.datasolicitacao(null)
				.statusexame(status)
				.build();
	}
	
	private ExameDTO criandoObjetoNull() {
		return null;
	}
	
	
	private List<ExameDTO> criandoListObjeto() {
		return asList(
				ExameDTO.builder().idexame(1).idtipoexame(null).idprestador(1).idbenef(1).dataconsulta(null)
						.datasolicitacao(null).statusexame(0).build(),
				ExameDTO.builder().idexame(1).idtipoexame(null).idprestador(1).idbenef(1).dataconsulta(null)
						.datasolicitacao(null).statusexame(0).build(),
						ExameDTO.builder().idexame(1).idtipoexame(null).idprestador(1).idbenef(1).dataconsulta(null)
						.datasolicitacao(null).statusexame(0).build(),
						ExameDTO.builder().idexame(1).idtipoexame(null).idprestador(1).idbenef(1).dataconsulta(null)
						.datasolicitacao(null).statusexame(0).build(),
						ExameDTO.builder().idexame(1).idtipoexame(null).idprestador(1).idbenef(1).dataconsulta(null)
						.datasolicitacao(null).statusexame(0).build());
	}
	
}
