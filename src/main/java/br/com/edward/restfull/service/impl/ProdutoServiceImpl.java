package br.com.edward.restfull.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import br.com.edward.restfull.model.ProdutoModel;
import br.com.edward.restfull.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private static List<ProdutoModel> lista = new ArrayList<>();

    @Override
    public ProdutoModel consultar(Long idProduto) {
        return lista.stream().filter(item -> idProduto.equals(item.getId())).findAny().orElse(null);
    }

    @Override
    public ProdutoModel cadastrar(ProdutoModel model) {
        lista.add(model);
        return model;
    }

    @Override
    public List<ProdutoModel> mostrarTudo() {
        return lista;
    }

    @Override
    public ProdutoModel remover(Long id) {
        ProdutoModel produto = this.consultar(id);
        if (Objects.nonNull(produto)) {
            lista.remove(produto);
        }
        return produto;
    }
}
