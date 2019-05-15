package br.com.edward.restfull.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.edward.restfull.domain.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ProdutoModel {
    
    private Long id;
    
    @NotNull
    @Length(min = 3, max = 128)
    private String nome;
    
    @NotNull
    private Double preco;
    
    @NotNull
    private Integer qtd;
    
    @NotNull
    private FornecedorModel fornecedor;
    
    public ProdutoModel(Produto domain) {
        this.id = domain.getId();
        this.nome = domain.getNome();
        this.preco = domain.getPreco();
        this.qtd = domain.getQtd();
        this.fornecedor = new FornecedorModel(domain.getFornecedor());
    }
}
