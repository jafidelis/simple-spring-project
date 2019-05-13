package br.com.edward.restfull.model;

import br.com.edward.restfull.domain.Pessoa;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PessoaModel {

    private Long id;
    private String nome;
    private Integer idade;
    private String nacionalidade;
    private String documento;

    public PessoaModel(Pessoa domain) {
        this.id = domain.getId();
        this.nome = domain.getNome();
        this.idade = domain.getIdade();
        this.nacionalidade = domain.getNacionalidade();
        this.documento = domain.getDocumento();
    }
}
