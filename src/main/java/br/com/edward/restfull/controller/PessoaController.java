package br.com.edward.restfull.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private static List<PessoaModel> lista = new ArrayList<>();
    
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
        lista.add(model);
        return model;
    }
    
    @GetMapping("/mostrar-tudo")
    public List<PessoaModel> mostrarTudo() {
        return lista;
    }
    
    @DeleteMapping("/remover")
    public PessoaModel remover(@RequestParam Long id) {
        
        PessoaModel pessoaRemover = lista.stream().filter(item -> id.equals(item.getId())).findAny().orElse(null);
        if (Objects.nonNull(pessoaRemover)) {
            lista.remove(pessoaRemover);
        }
        return pessoaRemover;
    }
}
