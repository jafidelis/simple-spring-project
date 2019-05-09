package br.com.edward.restfull.model;

public class ProdutoModel {

    private static Long cont = 0L;
    
    private final Long id;
    private String nome;
    private Double preco;
    private Integer qtd;

    public ProdutoModel() {
        this.id = ++cont;
        this.qtd = 0;
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

    public Integer getQtd() {
        return qtd;
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
