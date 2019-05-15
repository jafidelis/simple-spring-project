package br.com.edward.restfull.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.edward.restfull.domain.Carrinho;
import br.com.edward.restfull.domain.ItemCarrinho;
import br.com.edward.restfull.domain.Produto;
import br.com.edward.restfull.repository.CarrinhoRepository;
import br.com.edward.restfull.service.CarrinhoService;
import br.com.edward.restfull.service.ItemCarrinhoService;
import br.com.edward.restfull.service.ProdutoService;

@Transactional
@Service
public class CarrinhoServiceImpl implements CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;
    
    @Autowired
    private ProdutoService produtoService;
    
    @Autowired
    private ItemCarrinhoService itemCarrinhoService;
    
    @Override
    public Carrinho adicionar(Integer qtd, Long idProduto) {
        
        Produto produto = produtoService.consultar(idProduto);
        if (Objects.nonNull(produto)) {
            
            Carrinho carrinho = this.getCarrinho();
            carrinho.addItem(itemCarrinhoService.addItem(qtd, produto, carrinho));
            return this.carrinhoRepository.save(carrinho);
        }
        throw new RuntimeException("Produto não encontrado");
    }

    @Override
    public Carrinho mostrarTudo() {
        return this.getCarrinho();
    }

    @Override
    public ItemCarrinho remover(Long idItemCarrinho) {

        Carrinho carrinho = this.getCarrinho();
        ItemCarrinho item = carrinho.removerItem(idItemCarrinho);
        item.getProduto().addEstoque(item.getQtd());
        this.carrinhoRepository.save(carrinho);
        return item;
    }

    private Carrinho getCarrinho() {

        List<Carrinho> lista = carrinhoRepository.findAll();
        if (lista.isEmpty()) {
            return this.carrinhoRepository.save(new Carrinho());
        } else {
            return lista.get(0);
        }
    }
}
