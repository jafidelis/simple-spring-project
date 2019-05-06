package br.com.edward.restfull.model;

import java.time.ZonedDateTime;

public class PessoaModel {

	private ZonedDateTime dataCriacao;
	private String nome;

	public PessoaModel() {
		this.dataCriacao = ZonedDateTime.now();
	}
	
	public PessoaModel(String nome) {
		this();
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public ZonedDateTime getDataCriacao() {
		return dataCriacao;
	}
}
