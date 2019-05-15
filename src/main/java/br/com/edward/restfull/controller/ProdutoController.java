package br.com.edward.restfull.controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.edward.restfull.model.ProdutoModel;
import br.com.edward.restfull.model.TotalProdutoModel;
import br.com.edward.restfull.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    
    @PostMapping("/cadastrar")
    public ProdutoModel cadastrar(@Valid @RequestBody ProdutoModel model, BindingResult bindingResult) {
        
        if (!bindingResult.hasErrors() && Objects.nonNull(model.getFornecedor().getId())) {
            return new ProdutoModel(produtoService.cadastrar(model));
        }
        throw new RuntimeException("Model inválida");
    }
    
    @PutMapping("/alterar")
    public ProdutoModel alterar(@Valid @RequestBody ProdutoModel model, BindingResult bindingResult) {
        if (!bindingResult.hasErrors() && Objects.nonNull(model.getId())) {
            return new ProdutoModel(produtoService.alterar(model));
        }
        throw new RuntimeException("Model inválida");
    }
    
    @GetMapping("/mostrar-tudo")
    public List<ProdutoModel> mostrarTudo() {
        return produtoService.mostrarTudo().stream().map(ProdutoModel::new).collect(Collectors.toList());
    }
    
    @DeleteMapping("/remover")
    public ProdutoModel remover(@RequestParam Long id) {
        return new ProdutoModel(produtoService.remover(id));
    }
    
    @GetMapping("/get-total")
    public TotalProdutoModel getTotal() {
        return produtoService.getTotal();
    }
}
