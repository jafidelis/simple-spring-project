package br.com.edward.restfull.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.edward.restfull.model.ProdutoModel;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    public static List<ProdutoModel> lista = new ArrayList<>();

    @PostMapping("/cadastrar")
    public ProdutoModel cadastrar(@RequestBody ProdutoModel model) {
        lista.add(model);
        return model;
    }
    
    @GetMapping("/mostrar-tudo")
    public List<ProdutoModel> mostrarTudo() {
        return lista;
    }
    
    @DeleteMapping("/remover")
    public ProdutoModel remover(@RequestParam Long id) {
        
        ProdutoModel produto = lista.stream().filter(item -> id.equals(item.getId())).findAny().orElse(null);
        if (Objects.nonNull(produto)) {
            lista.remove(produto);
        }
        return produto;
    }
}
