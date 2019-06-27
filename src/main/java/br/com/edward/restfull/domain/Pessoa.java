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

    @Column(name="documento", length = 14)
    private String documento;
    
    @Column(name="email")
    private String email;

    @Column(name="endereco", length = 128)
    private String endereco;

    @Column(name="cidade", length = 128)
    private String cidade;

    @Column(name="estado", length = 60)
    private String estado;

    @Column(name="telefone", length = 20)
    private String telefone;

    public Pessoa() {
        this.dataCriacao = ZonedDateTime.now();
    }

    public Pessoa(PessoaModel model) {
        this();
        this.id = model.getId();
        this.nome = model.getNome();
        this.email = model.getEmail();
        this.endereco = model.getEndereco();
        this.documento = model.getDocumento();
        this.estado = model.getEstado();
        this.cidade = model.getCidade();
        this.telefone = model.getTelefone();
    }

    public abstract Boolean getDocumentoValido();
}
