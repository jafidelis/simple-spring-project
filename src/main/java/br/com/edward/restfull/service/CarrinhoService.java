package br.com.edward.restfull.service;

import br.com.edward.restfull.domain.Carrinho;
import br.com.edward.restfull.domain.ItemCarrinho;

public interface CarrinhoService {

    Carrinho adicionar(Integer qtd, Long idProduto);
    Carrinho mostrarTudo();
    ItemCarrinho remover(Long idItemCarrinho);
}
