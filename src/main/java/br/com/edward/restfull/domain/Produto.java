package br.com.edward.restfull.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.edward.restfull.model.ProdutoModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter

@Entity
@Table(name = "produto")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(name="nome", length = 128)
    private String nome;
    
    @NotNull
    @Column(name="preco")
    private Double preco;
    
    @NotNull
    @Column(name="qtd")
    private Integer qtd;

    @NotNull
    @Column(name="codigo_barras")
    private String codigoBarras;

    @NotNull
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;
    
    public Produto(ProdutoModel model, Fornecedor fornecedor) {
        this();
        this.nome = model.getNome();
        this.preco = model.getPreco();
        this.qtd = model.getQtd();
        this.fornecedor = fornecedor;
        this.codigoBarras = model.getCodigoBarras();
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
