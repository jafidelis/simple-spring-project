package br.com.edward.restfull.model;

import br.com.edward.restfull.domain.ItemCarrinho;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ItemCarrinhoModel {
    
    private Long id;
    private Integer qtd;
    private String produto;
    private Double total;
    
    public ItemCarrinhoModel(ItemCarrinho domain) {
        this.id = domain.getId();
        this.qtd = domain.getQtd();
        this.produto = domain.getProduto().getNome();
        this.total = domain.getTotal();
    }
}
