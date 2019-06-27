package br.com.edward.restfull.controller;

import java.util.List;
import java.util.stream.Collectors;

import br.com.edward.restfull.domain.Farmaceutico;
import br.com.edward.restfull.repository.FarmaceuticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.edward.restfull.model.FarmaceuticoModel;
import br.com.edward.restfull.service.FarmaceuticoService;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/farmaceutico")
public class FarmaceuticoController {

    @Autowired
    private FarmaceuticoService farmaceuticoService;

    @Autowired
    private FarmaceuticoRepository farmaceuticoRepository;
    
    @PostMapping("/cadastrar")
    public FarmaceuticoModel cadastrar(@RequestBody FarmaceuticoModel model) {
        return new FarmaceuticoModel(farmaceuticoService.cadastrar(model));
    }
    
    @GetMapping("/mostrar-tudo")
    public List<FarmaceuticoModel> mostrarTudo() {
        return farmaceuticoService.mostrarTudo().stream().map(FarmaceuticoModel::new).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public FarmaceuticoModel get(@PathVariable final Long id) {
        return  farmaceuticoRepository.findById(id).map(FarmaceuticoModel::new)
                .orElseThrow(EntityNotFoundException::new);
    }

    @PutMapping("{id}")
    public FarmaceuticoModel update(@PathVariable final Long id, @RequestBody FarmaceuticoModel model) {

        if (farmaceuticoRepository.findById(id).isPresent()) {
            return new FarmaceuticoModel(farmaceuticoRepository.save(new Farmaceutico(model)));
        }
        throw new RuntimeException("Cadastro não encontrado");
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable final Long id) {
        farmaceuticoRepository.deleteById(id);
    }
}
