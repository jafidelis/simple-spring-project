package br.com.edward.restfull.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edward.restfull.model.CarrinhoModel;
import br.com.edward.restfull.model.ItemCarrinhoModel;
import br.com.edward.restfull.model.ProdutoModel;
import br.com.edward.restfull.service.CarrinhoService;
import br.com.edward.restfull.service.ProdutoService;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

    private static CarrinhoModel carrinho = new CarrinhoModel();
    
    @Autowired
    private ProdutoService produtoService;
    
    @Override
    public CarrinhoModel adicionar(Integer qtd, Long idProduto) {
        
        ProdutoModel produto = produtoService.consultar(idProduto);
        if (Objects.nonNull(produto)) {
            produto.removerEstoque(qtd);
            carrinho.addItem(qtd, produto);
        }
        return carrinho;
    }

    @Override
    public CarrinhoModel mostrarTudo() {
        return carrinho;
    }

    @Override
    public ItemCarrinhoModel remover(Long idItemCarrinho) {

        ItemCarrinhoModel item = carrinho.removerItem(idItemCarrinho);
        item.getProduto().addEstoque(item.getQtd());
        return item;
    }

}
