package br.com.edward.restfull.controller;

import java.util.Objects;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.edward.restfull.model.CarrinhoModel;
import br.com.edward.restfull.model.ItemCarrinhoModel;
import br.com.edward.restfull.model.ProdutoModel;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    private static CarrinhoModel carrinho = new CarrinhoModel();
    
    @PostMapping("/adicionar")
    public CarrinhoModel param(@RequestParam Integer qtd, @RequestParam Long id) {
        
        ProdutoModel produto = ProdutoController.lista.stream().filter(item -> id.equals(item.getId())).findAny().orElse(null);
        if (Objects.nonNull(produto)) {
            carrinho.addItem(qtd, produto);
        }
        return carrinho;
    }
    
    @GetMapping("/mostrar-tudo")
    public CarrinhoModel mostrarTudo() {
        return carrinho;
    }
    
    @DeleteMapping("/remover")
    public ItemCarrinhoModel remover(@RequestParam Long id) {
        return carrinho.removerItem(id);
    }
}
