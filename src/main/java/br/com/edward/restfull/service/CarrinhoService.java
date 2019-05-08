package br.com.edward.restfull.service;

import br.com.edward.restfull.model.CarrinhoModel;
import br.com.edward.restfull.model.ItemCarrinhoModel;

public interface CarrinhoService {

    CarrinhoModel adicionar(Integer qtd, Long idProduto);
    CarrinhoModel mostrarTudo();
    ItemCarrinhoModel remover(Long idItemCarrinho);
}
