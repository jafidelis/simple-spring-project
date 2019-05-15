package br.com.edward.restfull.model;

import br.com.edward.restfull.domain.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ProdutoModel {
    
    private Long id;
    private String nome;
    private Double preco;
    private Integer qtd;
    private FornecedorModel fornecedor;
    
    public ProdutoModel(Produto domain) {
        this.id = domain.getId();
        this.nome = domain.getNome();
        this.preco = domain.getPreco();
        this.qtd = domain.getQtd();
        this.fornecedor = new FornecedorModel(domain.getFornecedor());
    }
}
