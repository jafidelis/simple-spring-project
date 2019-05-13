package br.com.edward.restfull.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edward.restfull.domain.Carrinho;
import br.com.edward.restfull.domain.ItemCarrinho;
import br.com.edward.restfull.domain.Produto;
import br.com.edward.restfull.service.CarrinhoService;
import br.com.edward.restfull.service.ProdutoService;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

    private static Carrinho carrinho = new Carrinho();
    
    @Autowired
    private ProdutoService produtoService;
    
    @Override
    public Carrinho adicionar(Integer qtd, Long idProduto) {
        
        Produto produto = produtoService.consultar(idProduto);
        if (Objects.nonNull(produto)) {
            produto.removerEstoque(qtd);
            carrinho.addItem(qtd, produto);
        }
        return carrinho;
    }

    @Override
    public Carrinho mostrarTudo() {
        return carrinho;
    }

    @Override
    public ItemCarrinho remover(Long idItemCarrinho) {

        ItemCarrinho item = carrinho.removerItem(idItemCarrinho);
        item.getProduto().addEstoque(item.getQtd());
        return item;
    }

}
