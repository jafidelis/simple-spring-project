package br.com.edward.restfull.model;

public class ProdutoModel {

    private static Long cont = 0L;
    
    private final Long id;
    private String nome;
    private Double preco;

    public ProdutoModel() {
        this.id = ++cont;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }
}
