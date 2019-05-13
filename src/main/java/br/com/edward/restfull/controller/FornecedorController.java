package br.com.edward.restfull.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edward.restfull.model.FornecedorModel;
import br.com.edward.restfull.service.FornecedorService;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;
    
    @PostMapping("/cadastrar")
    public FornecedorModel cadastrar(@RequestBody FornecedorModel model) {
        return new FornecedorModel(fornecedorService.cadastrar(model));
    }
    
    @GetMapping("/mostrar-tudo")
    public List<FornecedorModel> mostrarTudo() {
        return fornecedorService.mostrarTudo().stream().map(FornecedorModel::new).collect(Collectors.toList());
    }
}
