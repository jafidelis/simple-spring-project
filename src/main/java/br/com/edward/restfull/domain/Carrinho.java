package br.com.edward.restfull.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Getter;

@Getter
public class Carrinho {

    private final List<ItemCarrinho> itens;
    
    public Carrinho() {
        this.itens = new ArrayList<>();
    }
    
    public Double getTotal() {
        return this.itens.stream().mapToDouble(ItemCarrinho::getTotal).sum();
    }
    
    public void addItem(Integer qtd, Produto produto) {
        this.itens.add(new ItemCarrinho(qtd, produto));
    }
    
    public ItemCarrinho removerItem(Long id) {
        
        ItemCarrinho item = this.itens.stream().filter(x -> id.equals(x.getId())).findAny().orElse(null);
        if (Objects.nonNull(item)) {
            this.itens.remove(item);
        }
        return item;
    }
}
