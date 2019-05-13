package br.com.edward.restfull.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edward.restfull.model.FarmaceuticoModel;
import br.com.edward.restfull.service.FarmaceuticoService;

@RestController
@RequestMapping("/farmaceutico")
public class FarmaceuticoController {

    @Autowired
    private FarmaceuticoService farmaceuticoService;
    
    @PostMapping("/cadastrar")
    public FarmaceuticoModel cadastrar(@RequestBody FarmaceuticoModel model) {
        return new FarmaceuticoModel(farmaceuticoService.cadastrar(model));
    }
    
    @GetMapping("/mostrar-tudo")
    public List<FarmaceuticoModel> mostrarTudo() {
        return farmaceuticoService.mostrarTudo().stream().map(FarmaceuticoModel::new).collect(Collectors.toList());
    }
}
