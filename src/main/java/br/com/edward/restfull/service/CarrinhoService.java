package br.com.edward.restfull.service;

import java.util.List;

import br.com.edward.restfull.domain.Carrinho;
import br.com.edward.restfull.domain.ItemCarrinho;

public interface CarrinhoService {

    Carrinho adicionar(Integer qtd, Long idProduto);
    ItemCarrinho remover(Long idItemCarrinho);
    List<Carrinho> mostrarFechados();
    List<Carrinho> mostrarAbertos();
    Carrinho finalizar(Long idCliente);
}
