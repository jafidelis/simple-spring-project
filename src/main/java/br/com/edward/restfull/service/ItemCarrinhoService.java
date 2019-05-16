package br.com.edward.restfull.service;

import br.com.edward.restfull.domain.Carrinho;
import br.com.edward.restfull.domain.ItemCarrinho;
import br.com.edward.restfull.domain.Produto;

public interface ItemCarrinhoService {

    ItemCarrinho addItem(Integer qtd, Produto produto, Carrinho carrinho);
    ItemCarrinho remover(ItemCarrinho removerItem);
}
