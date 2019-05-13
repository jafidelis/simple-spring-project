package br.com.edward.restfull.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edward.restfull.domain.Fornecedor;
import br.com.edward.restfull.model.FornecedorModel;
import br.com.edward.restfull.service.FornecedorService;
import br.com.edward.restfull.service.PessoaService;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    private PessoaService pessoaService;
    
    @Override
    public Fornecedor cadastrar(FornecedorModel model) {
        return (Fornecedor)pessoaService.post(new Fornecedor(model));
    }

    @Override
    public List<Fornecedor> mostrarTudo() {
        return pessoaService.mostrarTudo().stream().filter(x -> x instanceof Fornecedor)
                .map(f -> (Fornecedor)f).collect(Collectors.toList());
    }

}
