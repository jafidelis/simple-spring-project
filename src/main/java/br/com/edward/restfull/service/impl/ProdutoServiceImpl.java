package br.com.edward.restfull.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import br.com.edward.restfull.domain.Produto;
import br.com.edward.restfull.model.ProdutoModel;
import br.com.edward.restfull.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private static List<Produto> lista = new ArrayList<>();

    @Override
    public Produto consultar(Long idProduto) {
        return lista.stream().filter(item -> idProduto.equals(item.getId())).findAny().orElse(null);
    }

    @Override
    public Produto cadastrar(ProdutoModel model) {
        
        Produto produto = this.consultar(model.getId());
        if (Objects.isNull(produto)) {
            
            produto = new Produto(model);
            lista.add(produto);
            return produto;
        }
        throw new RuntimeException("Produto já existe");
    }

    @Override
    public List<Produto> mostrarTudo() {
        return lista;
    }

    @Override
    public Produto remover(Long id) {
        Produto produto = this.consultar(id);
        if (Objects.nonNull(produto)) {
            lista.remove(produto);
        }
        return produto;
    }

    @Override
    public Produto alterar(ProdutoModel model) {
        Produto produto = this.consultar(model.getId());
        if (Objects.nonNull(produto)) {
            produto.alterar(model);
        }
        return produto;
    }
}
