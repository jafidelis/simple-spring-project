package br.com.edward.restfull.domain;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.edward.restfull.model.PessoaModel;
import lombok.Getter;

@Getter

@Entity
@Table(name="pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(name="data_criacao")
    private ZonedDateTime dataCriacao;
    
    @NotNull
    @Column(name="nome", length = 128)
    private String nome;
    
    @NotNull
    @Column(name="idade")
    private Integer idade;
    
    @NotNull
    @Column(name="nacionalidade", length = 128)
    private String nacionalidade;
    
    @NotNull
    @Column(name="documento", length = 14)
    private String documento;

    public Pessoa() {
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
