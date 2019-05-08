package br.com.edward.restfull.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarrinhoModel {

    private final List<ItemCarrinhoModel> itens;
    
    public CarrinhoModel() {
        this.itens = new ArrayList<>();
    }

    public List<ItemCarrinhoModel> getItens() {
        return itens;
    }
    
    public Double getTotal() {
        return this.itens.stream().mapToDouble(ItemCarrinhoModel::getTotal).sum();
    }
    
    public void addItem(Integer qtd, ProdutoModel produto) {
        this.itens.add(new ItemCarrinhoModel(qtd, produto));
    }
    
    public ItemCarrinhoModel removerItem(Long id) {
        
        ItemCarrinhoModel item = this.itens.stream().filter(x -> id.equals(x.getId())).findAny().orElse(null);
        if (Objects.nonNull(item)) {
            this.itens.remove(item);
        }
        return item;
    }
}
