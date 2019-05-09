package br.com.edward.restfull.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ItemCarrinhoModel {

    private static Long cont = 0L;
    
    private final Long id;
    private Integer qtd;
    private ProdutoModel produto;

    public ItemCarrinhoModel() {
        this.id = ++cont;
    }
    
    public ItemCarrinhoModel(Integer qtd, ProdutoModel produto) {
        this();
        this.qtd = qtd;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }
    
    public Integer getQtd() {
        return qtd;
    }

    public String getNomeProduto() {
        return Objects.nonNull(this.produto) ? this.produto.getNome() : " - ";
    }
    
    @JsonIgnore
    public ProdutoModel getProduto() {
        return produto;
    }

    public Double getTotal() {
        return this.qtd * this.produto.getPreco();
    }
}
