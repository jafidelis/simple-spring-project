package br.com.edward.restfull.controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import br.com.edward.restfull.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import br.com.edward.restfull.model.ProdutoModel;
import br.com.edward.restfull.model.TotalProdutoModel;
import br.com.edward.restfull.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoRepository produtoRepository;
    
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
    
    @DeleteMapping("{id}")
    public ProdutoModel delete(@PathVariable final Long id) {
        return new ProdutoModel(produtoService.remover(id));
    }
    
    @GetMapping("/get-total")
    public TotalProdutoModel getTotal() {
        return produtoService.getTotal();
    }

    @GetMapping("{id}")
    public ProdutoModel get(@PathVariable final Long id) {
        return  produtoRepository.findById(id).map(ProdutoModel::new).orElseThrow(EntityNotFoundException::new);
    }
}
