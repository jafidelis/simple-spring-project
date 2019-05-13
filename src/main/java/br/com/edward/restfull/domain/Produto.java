package br.com.edward.restfull.domain;

import br.com.edward.restfull.model.ProdutoModel;
import lombok.Getter;

@Getter
public class Produto {
   
    private static Long cont = 0L;
    
    private final Long id;
    private String nome;
    private Double preco;
    private Integer qtd;

    public Produto() {
        this.id = ++cont;
        this.qtd = 0;
    }
    
    public Produto(ProdutoModel model) {
        this();
        this.nome = model.getNome();
        this.preco = model.getPreco();
        this.qtd = model.getQtd();
    }

    public void addEstoque(Integer qtd) {
        this.qtd += qtd;
    }
    
    public void removerEstoque(Integer qtd) {
        
        if (this.qtd >= qtd) {
            this.qtd -= qtd;
        } else {
            throw new RuntimeException("Erro ao remover qtd do estoque");
        }
    }

    public void alterar(ProdutoModel model) {
        
        this.nome = model.getNome();
        this.preco = model.getPreco();
        this.qtd = model.getQtd();
    }
}
