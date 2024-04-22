package com.merini.springmysqldemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.merini.springmysqldemo.model.Classificacao;
import com.merini.springmysqldemo.repository.ClassificacaoRepository;

@Service
public class ClassificacaoServiceImpl implements ClassificacaoService
{
	ClassificacaoRepository classificacaoRepository;

	public ClassificacaoServiceImpl(ClassificacaoRepository classificacaoRepository) {
		super();
		this.classificacaoRepository = classificacaoRepository;
	}

	@Override
	public String createClassificacao(Classificacao classificacao) {
		Classificacao classificacaoRetorno = classificacaoRepository.save(classificacao);
		
		return "Success";
	}

	@Override
	public Classificacao getClassificacao(Integer idClassificacao) {
			System.out.println("idclassificacao - "+idClassificacao);
		return classificacaoRepository.findById(idClassificacao).get();
	}

	@Override
	public String updateClassificacao(Classificacao classificacao) {
		classificacaoRepository.save(classificacao);
		return "Success";
	}

	@Override
	public String deleteClassificacao(String idClassificacao) {
		classificacaoRepository.deleteById(Integer.valueOf(idClassificacao));
		return "Success";
	}

	@Override
	public List<Classificacao> getAllClassificacao() {
		return classificacaoRepository.findAll();
	}

	@Override
	public Classificacao getClassificacaoPeloNome(String nomeclassificacao) {
		// TODO Auto-generated method stub
		return classificacaoRepository.findByNomeclassificacao(nomeclassificacao).get(0);
	}

}
