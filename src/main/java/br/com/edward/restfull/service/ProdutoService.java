package br.com.edward.restfull.service;

import java.util.List;

import br.com.edward.restfull.model.ProdutoModel;

public interface ProdutoService {

    ProdutoModel consultar(Long idProduto);
    ProdutoModel cadastrar(ProdutoModel model);
    List<ProdutoModel> mostrarTudo();
    ProdutoModel remover(Long id);
    ProdutoModel alterar(ProdutoModel model);
}
