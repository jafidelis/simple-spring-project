package br.com.edward.restfull.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.edward.restfull.domain.Carrinho;
import br.com.edward.restfull.domain.Cliente;
import br.com.edward.restfull.domain.ItemCarrinho;
import br.com.edward.restfull.domain.Produto;
import br.com.edward.restfull.enuns.EnumStatusCarrinho;
import br.com.edward.restfull.repository.CarrinhoRepository;
import br.com.edward.restfull.service.CarrinhoService;
import br.com.edward.restfull.service.ClienteService;
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
    
    @Autowired
    private ClienteService clienteService;
    
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
    public ItemCarrinho remover(Long idItemCarrinho) {

        Carrinho carrinho = this.getCarrinho();
        return itemCarrinhoService.remover(carrinho.removerItem(idItemCarrinho));
    }

    private Carrinho getCarrinho() {

        List<Carrinho> lista = carrinhoRepository.findByStatus(EnumStatusCarrinho.ABERTO);
        if (lista.isEmpty()) {
            return this.carrinhoRepository.save(new Carrinho());
        } else {
            return lista.get(0);
        }
    }

    @Override
    public List<Carrinho> mostrarFechados() {
        return carrinhoRepository.findByStatus(EnumStatusCarrinho.FECHADO);
    }

    @Override
    public List<Carrinho> mostrarAbertos() {
        return carrinhoRepository.findByStatus(EnumStatusCarrinho.ABERTO);
    }

    @Override
    public Carrinho finalizar(Long idCliente) {
        
        Optional<Cliente> cliente = clienteService.consultar(idCliente);
        if (cliente.isPresent()) {
            
            return this.carrinhoRepository.save(this.getCarrinho().finalizar(cliente.get()));
        }
        throw new RuntimeException("Cliente não encontrado");
    }
}
