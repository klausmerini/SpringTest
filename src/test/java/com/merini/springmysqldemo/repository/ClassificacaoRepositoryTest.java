package com.merini.springmysqldemo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.merini.springmysqldemo.model.Classificacao;

@DataJpaTest
public class ClassificacaoRepositoryTest 
{
	
	@Autowired
	private ClassificacaoRepository classificacaoRepository;
	Classificacao classificacao;
	
	@BeforeEach
	void setUp(){
		classificacao = new Classificacao("rodando teste jpa","","", 300);
		classificacaoRepository.save(classificacao);
	}
	
	@AfterEach
	void tearDown(){
		classificacao = null;
		classificacaoRepository.deleteAll();;
	}
	
	@Test
	void testFindByNomeClassificacao(){
		List<Classificacao> classificacoes = classificacaoRepository.findByNomeclassificacao("rodando teste jpa");
		assertThat(classificacoes.get(0).getNomeclassificacao()).isEqualTo(classificacao.getNomeclassificacao());
	}
	
	@Test
	void testFindByNomeClassificacaoNotFound(){
		List<Classificacao> classificacoes = classificacaoRepository.findByNomeclassificacao("rodando teste nome errrrrr");
		assertThat(classificacoes.isEmpty()).isTrue();
	}
	
	
}
