package br.com.edward.restfull.model;

import java.time.ZonedDateTime;

public class PessoaModel {

	private ZonedDateTime dataCriacao;
	private String nome;
	private Integer idade;
	private Double peso;
	private String documento;

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

    public Integer getIdade() {
        return idade;
    }

    public Double getPeso() {
        return peso;
    }

    public String getDocumento() {
        return documento;
    }
}
