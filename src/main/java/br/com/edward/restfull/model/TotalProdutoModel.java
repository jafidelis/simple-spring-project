package br.com.edward.restfull.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TotalProdutoModel {

    private Double valorMedio;
    private Integer totalEstoque;
    private Integer qtdProdutos;
    
    public TotalProdutoModel(Double valorMedio, Integer totalEstoque, Integer qtdProdutos) {
        this.valorMedio = valorMedio;
        this.totalEstoque = totalEstoque;
        this.qtdProdutos = qtdProdutos;
    }
}
