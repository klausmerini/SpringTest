package com.merini.springmysqldemo.service;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.merini.springmysqldemo.model.Classificacao;
import com.merini.springmysqldemo.repository.ClassificacaoRepository;

class ClassificacaoServiceImplTest {

	@Mock
	private ClassificacaoRepository classificacaoRepository;
	private ClassificacaoService classificacaoService;
	AutoCloseable autoCloseable;
	Classificacao classificacao;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		autoCloseable = MockitoAnnotations.openMocks(this);
		classificacaoService = new ClassificacaoServiceImpl(classificacaoRepository);
		classificacao = new Classificacao("Mock it","yeah yeah","",30);
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		autoCloseable.close();
	}

//	@Test
	void testClassificacaoServiceImpl() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateClassificacao() 
	{
			System.out.println("testCreateClassificacao() ");
		mock(Classificacao.class);
		mock(ClassificacaoRepository.class);
		
		when(classificacaoRepository.save(classificacao)).thenReturn(classificacao);
		assertThat(classificacaoService.createClassificacao(classificacao)).isEqualTo("Success");
			System.out.println("testCreateClassificacao() - ok");
	}

	@Test
	void testGetClassificacao() 
	{
			System.out.println("testGetClassificacao() ");
		mock(Classificacao.class);
		mock(ClassificacaoRepository.class);
		
		classificacaoRepository.save(classificacao);
		when(classificacaoRepository.findById(30)).thenReturn(Optional.ofNullable(classificacao));
		assertThat(classificacaoService.getClassificacao(30).getNomeclassificacao())
			.isEqualTo(classificacao.getNomeclassificacao());
			System.out.println("testGetClassificacao() - ok");
	}
	

	@Test
	void testGetClassificacaoByName() 
	{
			System.out.println("testGetClassificacaoByName() ");
		mock(Classificacao.class);
		mock(ClassificacaoRepository.class);

		when(classificacaoRepository.findByNomeclassificacao("Mock it")).thenReturn(
				new ArrayList<Classificacao> (Collections.singleton(classificacao)));
		assertThat(classificacaoService.getClassificacaoPeloNome("Mock it").getNomeclassificacao())
			.isEqualTo(classificacao.getNomeclassificacao());
			System.out.println("testGetClassificacaoByName() - ok");
	}

	@Test
	void testUpdateClassificacao() 
	{
			System.out.println("testUpdateClassificacao() ");
		mock(Classificacao.class);
		mock(ClassificacaoRepository.class);
		
		when(classificacaoRepository.save(classificacao)).thenReturn(classificacao);
		assertThat(classificacaoService.updateClassificacao(classificacao)).isEqualTo("Success");
			System.out.println("testUpdateClassificacao() - ok");
	}

	@Test
	void testDeleteClassificacao() {
			System.out.println("testDeleteClassificacao() ");
		mock(Classificacao.class);
		mock(ClassificacaoRepository.class, Mockito.CALLS_REAL_METHODS);

		doAnswer(Answers.CALLS_REAL_METHODS).when(
				classificacaoRepository).deleteById(any());
				new ArrayList<Classificacao> (Collections.singleton(classificacao));
		assertThat(classificacaoService.deleteClassificacao("1")).isEqualTo("Success");
			System.out.println("testDeleteClassificacao() - ok ");	
	}

	@Test
	void testGetAllClassificacao() 
	{
		System.out.println("testGetAllClassificacao() ");
		mock(Classificacao.class);
		mock(ClassificacaoRepository.class);

		when(classificacaoRepository.findAll()).thenReturn(
				new ArrayList<Classificacao> (Collections.singleton(classificacao)));
		assertThat(classificacaoService.getAllClassificacao().get(0).getDescricao())
			.isEqualTo(classificacao.getDescricao());
			System.out.println("testGetAllClassificacao() - ok "+classificacao.getDescricao());	}

}
