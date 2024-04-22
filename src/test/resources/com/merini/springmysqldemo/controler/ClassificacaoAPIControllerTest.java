package com.merini.springmysqldemo.controler;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.merini.springmysqldemo.model.Classificacao;
import com.merini.springmysqldemo.service.ClassificacaoService;

@WebMvcTest(ClassificacaoAPIController.class) 
class ClassificacaoAPIControllerTest 
{
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ClassificacaoService classificacaoService;
	Classificacao classificacao1;
	Classificacao classificacao2;
	List<Classificacao >  classificacaoList = new ArrayList<>(); 
	
	@BeforeEach
	void setUp() throws Exception 
	{
		classificacao1 = new Classificacao(null, null, null, null)
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testClassificacaoAPIController() {
		fail("Not yet implemented");
	}

	@Test
	void testGetClassificacaoDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTodosClassificacaoDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateClassificacao() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateClassificacao() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteClassificacaoDetails() {
		fail("Not yet implemented");
	}

}
