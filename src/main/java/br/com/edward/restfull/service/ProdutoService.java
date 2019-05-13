package br.com.edward.restfull.service;

import java.util.List;

import br.com.edward.restfull.domain.Produto;
import br.com.edward.restfull.model.ProdutoModel;

public interface ProdutoService {

    Produto consultar(Long idProduto);
    Produto cadastrar(ProdutoModel model);
    List<Produto> mostrarTudo();
    Produto remover(Long id);
    Produto alterar(ProdutoModel model);
}
