package br.com.edward.restfull.model;

import java.util.List;
import java.util.stream.Collectors;

import br.com.edward.restfull.domain.Carrinho;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CarrinhoModel {
    
    private List<ItemCarrinhoModel> itens;
    private Double total;
    
    public CarrinhoModel(Carrinho domain) {
        this.itens = domain.getItens().stream().map(ItemCarrinhoModel::new).collect(Collectors.toList());
        this.total = domain.getTotal();
    }
}
