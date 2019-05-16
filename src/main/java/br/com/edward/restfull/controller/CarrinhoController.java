package br.com.edward.restfull.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.edward.restfull.model.CarrinhoModel;
import br.com.edward.restfull.model.ItemCarrinhoModel;
import br.com.edward.restfull.service.CarrinhoService;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;
    
    @PostMapping("/adicionar")
    public CarrinhoModel adicionar(@RequestParam Integer qtd, @RequestParam Long id) {
       return new CarrinhoModel(carrinhoService.adicionar(qtd, id));
    }
    
    @GetMapping("/mostrar-abertos")
    public List<CarrinhoModel> mostrarAbertos() {
        return carrinhoService.mostrarAbertos().stream().map(CarrinhoModel::new).collect(Collectors.toList());
    }
    
    @GetMapping("/mostrar-fechados")
    public List<CarrinhoModel> mostrarFechados() {
        return carrinhoService.mostrarFechados().stream().map(CarrinhoModel::new).collect(Collectors.toList());
    }
    
    @PostMapping("/finalizar")
    public CarrinhoModel finalizar(@RequestParam Long id) {
        return new CarrinhoModel(carrinhoService.finalizar(id));
    }
    
    @DeleteMapping("/remover")
    public ItemCarrinhoModel remover(@RequestParam Long id) {
        return new ItemCarrinhoModel(carrinhoService.remover(id));
    }
}
