package com.clinica.service;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.clinica.dto.agendamentoDTO;
import com.clinica.dto.exameDTO;
import com.clinica.repository.exameRepository;


@ExtendWith(SpringExtension.class)
public class ExameServiceTest {

	@Mock
	exameService service;
	
	@Mock
	exameRepository repository;
	
	List<exameDTO> listExame; 
	
	exameDTO exame;
	exameDTO exame2;
	
	@BeforeEach
	public void setUp() {
		this.listExame = this.criandoListObjeto();; 
	}
	
	@Test
	public void devePesquisaTodosOsexames() throws Exception{
		
		//this.exame = this.criandoObjeto();
		when(service.findAll_Exame()).thenReturn(this.listExame);
		List<exameDTO> exame3 = service.findAll_Exame();
		
		assertEquals(this.listExame,exame3);
	}
	
	@Test
	public void devePesquisaTodosOsexamesLista() throws Exception{
		
		//this.exame = this.criandoObjeto();
		when(service.findAll_Exame()).thenReturn(this.listExame);
		List<exameDTO> exame3 = service.findAll_Exame();
		
		assertTrue(exame3.size() > 1);
	}
	
	@Test
	public void devePesquisaTodosOsexamesLista2() throws Exception{
		
		//this.exame = this.criandoObjeto();
		when(service.findAll_Exame()).thenReturn(this.listExame);
		List<exameDTO> exame3 = service.findAll_Exame();
		
		assertEquals(exame3,this.listExame);
	}
	
	@Test
	public void devePesquisarComSucessoExameID() throws Exception
	{
		int id = 1;
		exameDTO exame3;
		this.exame = this.criandoObjeto();
		when(service.find_Exame_id(id)).thenReturn(this.exame);
		exame3 = service.find_Exame_id(id);
		
		assertEquals(exame3,this.exame);
	}
		
	@Test
	public void devePesquisarComRetornaNullExameID() throws Exception
	{
		int id = 1;
		exameDTO exame3;
		this.exame = this.criandoObjetoNull();
		when(service.find_Exame_id(id)).thenReturn(this.exame);
		exame3 = service.find_Exame_id(id);
		
		assertNull(exame3);
		verify(repository,never()).findByidexame(id);
	}
	
	@Test
	public void deveInserirExameComSucesso() throws Exception{
		exameDTO exame3;
		exameDTO exame4;
		
		this.exame = this.criandoObjeto();
		exame4 = this.criandoObjeto();
		
		
		when(service.InsertExame(exame)).thenReturn(exame4);
		exame3 = service.InsertExame(exame);
		
		assertEquals(exame3,exame);
	}
	
	@Test
	public void deveInserirExameComSucessoNull() throws Exception{
		exameDTO exame3;
		exameDTO exame4;
		
		this.exame = this.criandoObjetoNull();
		exame4 = this.criandoObjetoNull();
		
		
		when(service.InsertExame(exame)).thenReturn(exame4);
		exame3 = service.InsertExame(exame);
		
		assertEquals(exame4,exame);
	}
	
	@Test
	public void deveInserirExameComSucessoNever() throws Exception{
		exameDTO exame3;
		exameDTO exame4;
		
		this.exame = this.criandoObjetoNull();
		exame4 = this.criandoObjetoNull();
		
		
		when(service.InsertExame(exame)).thenReturn(exame4);
		exame3 = service.InsertExame(exame);
		
		verify(repository,never()).save(exame);
	}
	
	@Test
	public void deveAtualizarExameComSucesso() throws Exception{
		exameDTO exame3;
		exameDTO exame4;
		
		this.exame = this.criandoObjeto();
		exame4 = this.criandoObjeto();
		
		
		when(service.UpdateExame(exame)).thenReturn(exame4);
		exame3 = service.UpdateExame(exame);
		
		assertEquals(exame3,exame);
	}
	
	@Test
	public void deveAtualizarExameComSucessoNull() throws Exception{
		exameDTO exame3;
		exameDTO exame4;
		
		this.exame = this.criandoObjetoNull();
		exame4 = this.criandoObjetoNull();
		
		
		when(service.UpdateExame(exame)).thenReturn(exame4);
		exame3 = service.InsertExame(exame);
		
		assertEquals(exame4,exame);
	}
	
	@Test
	public void deveAtualizarExameComSucessoNever() throws Exception{
		exameDTO exame3;
		exameDTO exame4;
		
		this.exame = this.criandoObjetoNull();
		exame4 = this.criandoObjetoNull();
		
		
		when(service.UpdateExame(exame)).thenReturn(exame4);
		exame3 = service.InsertExame(exame);
		
		verify(repository,never()).save(exame);
	}
	
	private exameDTO criandoObjeto() {
		return exameDTO.builder()
				.idexame(1)
				.idtipoexame(null)
				.idprestador(1)
				.idbenef(1)
				.dataconsulta(null)
				.datasolicitacao(null)
				.statusexame(0)
				.build();
	}
	
	private agendamentoDTO criandoObjetoIdNull() {
		return agendamentoDTO.builder()
				.idprestador(1)
				.idtipoagendamento(null)
				.dataconsulta(null)
				.datasolicitacao(null)
				.statusAgendamento("1")
				.build();
	}
	
	private exameDTO criandoObjetoParametro(int idagen,int idbenef,int idprestador,int status) {
		return exameDTO.builder()
				.idexame(idagen)
				.idtipoexame(null)
				.idprestador(idprestador)
				.idbenef(idbenef)
				.dataconsulta(null)
				.datasolicitacao(null)
				.statusexame(status)
				.build();
	}
	
	private exameDTO criandoObjetoNull() {
		return null;
	}
	
	
	private List<exameDTO> criandoListObjeto() {
		return asList(
				exameDTO.builder().idexame(1).idtipoexame(null).idprestador(1).idbenef(1).dataconsulta(null)
						.datasolicitacao(null).statusexame(0).build(),
				exameDTO.builder().idexame(1).idtipoexame(null).idprestador(1).idbenef(1).dataconsulta(null)
						.datasolicitacao(null).statusexame(0).build(),
						exameDTO.builder().idexame(1).idtipoexame(null).idprestador(1).idbenef(1).dataconsulta(null)
						.datasolicitacao(null).statusexame(0).build(),
						exameDTO.builder().idexame(1).idtipoexame(null).idprestador(1).idbenef(1).dataconsulta(null)
						.datasolicitacao(null).statusexame(0).build(),
						exameDTO.builder().idexame(1).idtipoexame(null).idprestador(1).idbenef(1).dataconsulta(null)
						.datasolicitacao(null).statusexame(0).build());
	}
	
}
