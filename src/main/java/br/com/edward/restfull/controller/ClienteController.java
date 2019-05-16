package br.com.edward.restfull.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edward.restfull.model.ClienteModel;
import br.com.edward.restfull.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    
    @PostMapping("/cadastrar")
    public ClienteModel cadastrar(@Valid @RequestBody ClienteModel model, BindingResult bindingResult) {
       
        if (!bindingResult.hasErrors()) {
            return new ClienteModel(clienteService.cadastrar(model));
        }
        throw new RuntimeException("Model inválida");
    }
    
    @GetMapping("/mostrar-tudo")
    public List<ClienteModel> mostrarTudo() {
        return clienteService.mostrarTudo().stream().map(ClienteModel::new).collect(Collectors.toList());
    }
}
