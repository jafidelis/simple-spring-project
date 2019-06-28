package br.com.edward.restfull.controller;

import java.util.List;
import java.util.stream.Collectors;

import br.com.edward.restfull.domain.Fornecedor;
import br.com.edward.restfull.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.edward.restfull.model.FornecedorModel;
import br.com.edward.restfull.service.FornecedorService;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @Autowired
    private FornecedorRepository fornecedorRepository;
    
    @PostMapping("/cadastrar")
    public FornecedorModel cadastrar(@RequestBody FornecedorModel model) {
        return new FornecedorModel(fornecedorService.cadastrar(model));
    }
    
    @GetMapping("/mostrar-tudo")
    public List<FornecedorModel> mostrarTudo() {
        return fornecedorService.mostrarTudo().stream().map(FornecedorModel::new).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public FornecedorModel get(@PathVariable final Long id) {
        return  fornecedorRepository.findById(id).map(FornecedorModel::new).orElseThrow(EntityNotFoundException::new);
    }

    @PutMapping("{id}")
    public FornecedorModel update(@PathVariable final Long id, @RequestBody FornecedorModel model) {

        if (fornecedorRepository.findById(id).isPresent()) {
            return new FornecedorModel(fornecedorRepository.save(new Fornecedor(model)));
        }
        throw new RuntimeException("Cadastro não encontrado");
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable final Long id) {
        fornecedorRepository.deleteById(id);
    }

    @GetMapping("/busca-por-nome/{nome}")
    public List<FornecedorModel> buscaPorNomeOuId(@PathVariable final String nome) {
        return fornecedorRepository.findByNome(nome).stream().map(FornecedorModel::new).collect(Collectors.toList());
    }
}
