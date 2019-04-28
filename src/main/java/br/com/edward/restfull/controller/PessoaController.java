package br.com.edward.restfull.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.edward.restfull.model.PessoaModel;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@GetMapping("/param")
    public PessoaModel param(@RequestParam String nome) {
        return new PessoaModel(nome);
    }
	
	@GetMapping("/path/{nome}")
    public PessoaModel path(@PathVariable String nome) {
        return new PessoaModel(nome);
    }
	
	@PostMapping("/post")
	public PessoaModel perguntar(@RequestBody PessoaModel model) {
		return model;
	}
}
