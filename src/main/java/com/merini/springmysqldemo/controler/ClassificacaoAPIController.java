package com.merini.springmysqldemo.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.merini.springmysqldemo.model.Classificacao;
import com.merini.springmysqldemo.service.ClassificacaoService;


@RestController
@RequestMapping("/classificacao")
public class ClassificacaoAPIController 
{
	ClassificacaoService classificacaoService;	
	
	public ClassificacaoAPIController(ClassificacaoService classificacaoService) 
	{		
		this.classificacaoService = classificacaoService;
	}

	@GetMapping("{idClassificacao}")
	public Classificacao getClassificacaoDetails(@PathVariable ("idClassificacao") String idClassificacao)
	{
		System.out.println(idClassificacao);	
		return classificacaoService.getClassificacao(Integer.valueOf(idClassificacao));		
	}
	
	@GetMapping()
	public List<Classificacao> getTodosClassificacaoDetails()
	{		
		return classificacaoService.getAllClassificacao();//nomesClassificacoes;		
	}
	
	@PostMapping
	public String createClassificacao(@RequestBody Classificacao classificacao)
	{
		classificacaoService.createClassificacao(classificacao);
		return "Criação bem sucedida! ";//+resultado;		
	}	
	
	@PutMapping
	public String updateClassificacao(@RequestBody Classificacao classificacao)
	{
		classificacaoService.updateClassificacao(classificacao);
		return "Classificacao atualizada com sucesso";
		
	}
	
	@DeleteMapping("{idClassificacao}")
	public String deleteClassificacaoDetails(@PathVariable("idClassificacao") String idClassificacao)
	{
		classificacaoService.deleteClassificacao(idClassificacao);
		return "Classificacao deleted Succefully";
	}
}


/*


@RestController
@RequestMapping("/classificacao")
public class ClassificacaoAPIService 
{
	private Classificacao classificacao;
	
	@GetMapping("{idClassificacao}")
	public Classificacao getClassificacaoDetails(String idClassificacao)
	{
		Classificacao classificacao = new Classificacao("Comercial","testando o componente","cinza", 7);
		return classificacao ;		
	}
	
	@PostMapping
	public String createClassificacao(@RequestBody Classificacao classificacao)
	{
		this.classificacao=classificacao;
		return "Criação bem sucedida!";		
	}	
	
	@PutMapping
	public String updateClassificacao(Classificacao classificacao)
	{
		this.classificacao	= classificacao;
		return "Classificacao atualizada com sucesso";
		
	}
	
	@DeleteMapping("{idClassificacao}")
	public String deleteClassificacaoDetails(String idClassificacao)
	{
		this.classificacao=null;
		return "Classificacao deleted Succefully";
	}
	
}	

*/