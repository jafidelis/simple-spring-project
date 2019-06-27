package br.com.edward.restfull.model;

import javax.persistence.Column;
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
    
    private String email;
    
    @Length(min = 3, max = 128)
    private String endereco;
    
    @Length(min = 11, max = 14)
    private String documento;

    private String cidade;

    private String estado;

    private String telefone;

    public PessoaModel(Pessoa domain) {
        this.id = domain.getId();
        this.nome = domain.getNome();
        this.email = domain.getEmail();
        this.endereco = domain.getEndereco();
        this.documento = domain.getDocumento();
        this.estado = domain.getEstado();
        this.cidade = domain.getCidade();
        this.telefone = domain.getTelefone();
    }
}
