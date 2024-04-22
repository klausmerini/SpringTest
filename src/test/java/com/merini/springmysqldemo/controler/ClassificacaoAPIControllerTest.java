package com.merini.springmysqldemo.controler;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
//import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
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
		classificacao1 = new Classificacao("Classific Service test", "test REST controller", "vinho", 1);
		classificacao2 = new Classificacao("Classific Service test again", "teset REST", "verde azulado", 2);

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetClassificacaoDetails() throws Exception 
	{
		when(classificacaoService.getClassificacao(1))
			.thenReturn(classificacao1);
		this.mockMvc.perform(get("/classificacao/1"))
			.andDo(print()).andExpect(status().isOk());
	}

	@Test
	void testGetTodosClassificacaoDetails() throws Exception 
	{
		when(classificacaoService.getAllClassificacao())
			.thenReturn(classificacaoList);
		this.mockMvc.perform(get("/classificacao"))
			.andDo(print()).andExpect(status().isOk());
	}

	@Test
	void testCreateClassificacao() throws Exception 
	{
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(classificacao1);
		
		when(classificacaoService.createClassificacao(classificacao1))
			.thenReturn("Success");
		this.mockMvc.perform(post("/classificacao")
			.contentType(MediaType.APPLICATION_JSON)
			.content(requestJson))
			.andDo(print()).andExpect(status().isOk());
	}

	@Test
	void testUpdateClassificacao() throws Exception 
	{
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(classificacao1);
		
		when(classificacaoService.createClassificacao(classificacao1))
			.thenReturn("Success");
		this.mockMvc.perform(put("/classificacao")
			.contentType(MediaType.APPLICATION_JSON)
			.content(requestJson))
			.andDo(print()).andExpect(status().isOk());
	}

	@Test
	void testDeleteClassificacaoDetails() throws Exception 
	{
		when(classificacaoService.deleteClassificacao("1"))
			.thenReturn("Success");
		this.mockMvc.perform(delete("/classificacao/1"))
			.andDo(print()).andExpect(status().isOk());
	}

}
