package br.com.edward.restfull.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.edward.restfull.model.PessoaModel;
import br.com.edward.restfull.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
    
    @GetMapping("/mostrar-tudo")
    public List<PessoaModel> mostrarTudo() {
        return pessoaService.mostrarTudo().stream().map(PessoaModel::new).collect(Collectors.toList());
    }
    
    @DeleteMapping("/remover")
    public PessoaModel remover(@RequestParam Long id) {
        return new PessoaModel(pessoaService.remover(id));
    }
}
