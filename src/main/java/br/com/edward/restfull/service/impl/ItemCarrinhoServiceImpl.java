package br.com.edward.restfull.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.edward.restfull.domain.Carrinho;
import br.com.edward.restfull.domain.ItemCarrinho;
import br.com.edward.restfull.domain.Produto;
import br.com.edward.restfull.repository.ItemCarrinhoRepository;
import br.com.edward.restfull.service.ItemCarrinhoService;

@Transactional
@Service
public class ItemCarrinhoServiceImpl implements ItemCarrinhoService {

    @Autowired
    private ItemCarrinhoRepository itemCarrinhoRepository;
    
    @Override
    public ItemCarrinho addItem(Integer qtd, Produto produto, Carrinho carrinho) {
        produto.removerEstoque(qtd);
        return itemCarrinhoRepository.save(new ItemCarrinho(qtd, produto, carrinho));
    }

    @Override
    public ItemCarrinho remover(ItemCarrinho item) {
        item.getProduto().addEstoque(item.getQtd());
        itemCarrinhoRepository.delete(item);
        return item;
    }
}
