package com.merini.springmysqldemo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import com.merini.springmysqldemo.model.Classificacao;

public interface ClassificacaoRepository extends JpaRepository<Classificacao, Integer>
{
	List<Classificacao> findByNomeclassificacao(String nomeclassificacao);
	Optional<Classificacao> findById(Integer idclassificacao);
	
}