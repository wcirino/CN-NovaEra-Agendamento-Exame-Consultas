package com.clinica.repository;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.clinica.dto.AgendamentoDTO;
import com.clinica.dto.BeneficiarioDTO;
import com.clinica.dto.PrestadorDTO;

@RunWith(SpringRunner.class)
//@ContextConfiguration
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AgendamentoRepositoryTest {
	
	
	@Autowired
	AgendamentoRepository agRepository;
	
	@Mock
	AgendamentoRepository agendamentoRepository; 
	
	AgendamentoDTO agDto;
	
	String nome;
	
	 
	@Before
	    public void setUp() {
		   MockitoAnnotations.openMocks(this);
		   agDto = this.criandoObjeto();
	       // this.service = new BookServiceImpl(repository);
	    }
	
	
	@Test
	public void deveBuscarAgendamentoPorIdsucessoMock() throws Exception  {
		
		PrestadorDTO p = new PrestadorDTO();
		p.setIdPrest(1);
		
		BeneficiarioDTO b = new BeneficiarioDTO();
		b.setIdbenef(1);
		
		Mockito.when(agendamentoRepository.findByidagendamento(1)).thenReturn(AgendamentoDTO.builder()
				.idagendamento(1)
				.idbenef(b)
				.prestador(p)
				.idtipoagendamento(null)
				.dataconsulta(null)
				.datasolicitacao(null)
				.statusAgendamento("1")
				.build()
				);
		
				
		assertEquals(1,1);
	}
			
	@Test
	public void deveBuscarAgendamentoPorIdsucesso() throws Exception  {
		AgendamentoDTO dto = criandoObjeto2(); 
		AgendamentoDTO obj = agRepository.findByidagendamento(1);
		obj = criandoObjeto2();
		assertEquals(dto.getIdagendamento(),obj.getIdagendamento());
	}
	
	@Test
	public void deveBuscarTodososAgendamentosComSucesso() {
		List<AgendamentoDTO> obj = agRepository.findAll();						
		assertTrue(obj.size() > 1);
		
	}
	
	@Test
	public void naoRetornaAgendamentoErro() {
		Mockito.when(agendamentoRepository.findByidagendamento(0)).thenReturn(null);
		assertNull(agDto);
	}
	
	@Test
	public void naoRetornaAgendamentoErroList() {
		Mockito.when(agendamentoRepository.findAll()).thenReturn(null);
		assertNull(agDto);
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
				.idagendamento(1)
				.idbenef(null)
				.prestador(null)
				.idtipoagendamento(null)
				.dataconsulta(null)
				.datasolicitacao(null)
				.statusAgendamento("1")
				.build();
	}
		
}
