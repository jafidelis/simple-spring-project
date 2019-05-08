package br.com.edward.restfull.service.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.edward.restfull.model.ProdutoModel;
import br.com.edward.restfull.service.ProdutoService;

public class ProdutoServiceImpl implements ProdutoService {

    private static List<ProdutoModel> lista = new ArrayList<>();

    @Override
    public ProdutoModel consultar(Long idProduto) {
        return lista.stream().filter(item -> idProduto.equals(item.getId())).findAny().orElse(null);
    }
}
