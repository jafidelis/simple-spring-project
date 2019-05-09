package br.com.edward.restfull.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.edward.restfull.model.FarmaceuticoModel;
import br.com.edward.restfull.model.FornecedorModel;
import br.com.edward.restfull.model.PessoaModel;
import br.com.edward.restfull.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
    
    @GetMapping("/param")
    public PessoaModel param(@RequestParam String nome) {
        return new FarmaceuticoModel(nome);
    }

    @GetMapping("/path/{nome}")
    public PessoaModel path(@PathVariable String nome) {
        return new FornecedorModel(nome);
    }

    @PostMapping("/post")
    public PessoaModel post(@RequestBody PessoaModel model) {
       return pessoaService.post(model);
    }
    
    @GetMapping("/mostrar-tudo")
    public List<PessoaModel> mostrarTudo() {
        return pessoaService.mostrarTudo();
    }
    
    @DeleteMapping("/remover")
    public PessoaModel remover(@RequestParam Long id) {
        return pessoaService.remover(id);
    }
}
