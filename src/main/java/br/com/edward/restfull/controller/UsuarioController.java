package br.com.edward.restfull.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edward.restfull.model.UsuarioModel;
import br.com.edward.restfull.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping("/cadastrar")
    public UsuarioModel cadastrar(@RequestBody UsuarioModel model) {
        return new UsuarioModel(usuarioService.cadastrar(model));
    }

    @GetMapping("/mostrar-tudo")
    public List<UsuarioModel> mostrarTudo() {
        return usuarioService.mostrarTudo().stream().map(UsuarioModel::new).collect(Collectors.toList());
    }
}
