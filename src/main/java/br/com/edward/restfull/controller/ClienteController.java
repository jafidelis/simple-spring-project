package br.com.edward.restfull.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import br.com.edward.restfull.domain.Cliente;
import br.com.edward.restfull.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import br.com.edward.restfull.model.ClienteModel;
import br.com.edward.restfull.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;
    
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

    @GetMapping("{id}")
    public ClienteModel get(@PathVariable final Long id) {
        return  clienteRepository.findById(id).map(ClienteModel::new).orElseThrow(EntityNotFoundException::new);
    }

    @PutMapping("{id}")
    public ClienteModel update(@PathVariable final Long id, @RequestBody ClienteModel model) {

        if (clienteRepository.findById(id).isPresent()) {
            return new ClienteModel(clienteRepository.save(new Cliente(model)));
        }
        throw new RuntimeException("Cadastro não encontrado");
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable final Long id) {
        clienteRepository.deleteById(id);
    }
}
