package br.com.edward.restfull.domain;

import java.time.ZonedDateTime;

import br.com.edward.restfull.model.PessoaModel;
import lombok.Getter;

@Getter
public abstract class Pessoa {

    private static Long cont = 0L;
    
    private final Long id;
    private ZonedDateTime dataCriacao;
    private String nome;
    private Integer idade;
    private String nacionalidade;
    private String documento;

    public Pessoa() {
        this.id = ++cont;
        this.dataCriacao = ZonedDateTime.now();
    }

    public Pessoa(PessoaModel model) {
        this();
        this.nome = model.getNome();
        this.idade = model.getIdade();
        this.nacionalidade = model.getNacionalidade();
        this.documento = model.getDocumento();
    }

    public abstract Boolean getDocumentoValido();
}
