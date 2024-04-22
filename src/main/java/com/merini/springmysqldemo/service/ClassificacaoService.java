package com.merini.springmysqldemo.service;

import java.util.List;

import com.merini.springmysqldemo.model.Classificacao;

public interface ClassificacaoService 
{
	public String createClassificacao(Classificacao classificacao);
	public Classificacao getClassificacao(Integer idClassificacao);
	public Classificacao getClassificacaoPeloNome(String nomeclassificacao);
	public String updateClassificacao(Classificacao classificacao);
	public String deleteClassificacao(String idClassificacao);
	public List<Classificacao> getAllClassificacao();
	
}
