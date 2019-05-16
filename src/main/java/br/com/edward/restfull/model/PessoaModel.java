package br.com.edward.restfull.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.edward.restfull.domain.Pessoa;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PessoaModel {

    private Long id;
    
    @NotNull
    @Length(min = 3, max = 128)
    private String nome;
    
    @NotNull
    private Integer idade;
    
    @NotNull
    @Length(min = 3, max = 128)
    private String nacionalidade;
    
    @NotNull
    @Length(min = 11, max = 14)
    private String documento;

    public PessoaModel(Pessoa domain) {
        this.id = domain.getId();
        this.nome = domain.getNome();
        this.idade = domain.getIdade();
        this.nacionalidade = domain.getNacionalidade();
        this.documento = domain.getDocumento();
    }
}
