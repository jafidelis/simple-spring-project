package br.com.edward.restfull.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.edward.restfull.domain.Produto;
import br.com.edward.restfull.model.ProdutoModel;
import br.com.edward.restfull.repository.ProdutoRepository;
import br.com.edward.restfull.service.ProdutoService;

@Transactional
@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Override
    public Produto consultar(Long idProduto) {
        return produtoRepository.findById(idProduto).orElse(null);
    }

    @Override
    public Produto cadastrar(ProdutoModel model) {
        
        return produtoRepository.save(new Produto(model));
    }

    @Override
    public List<Produto> mostrarTudo() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto remover(Long id) {
        Produto produto = this.consultar(id);
        if (Objects.nonNull(produto)) {
            produtoRepository.delete(produto);
        }
        return produto;
    }

    @Override
    public Produto alterar(ProdutoModel model) {
        Produto produto = this.consultar(model.getId());
        if (Objects.nonNull(produto)) {
            produto.alterar(model);
            return produtoRepository.save(produto);
        }
        return produto;
    }
}
