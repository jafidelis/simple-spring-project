package br.com.edward.restfull.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edward.restfull.model.FornecedorModel;
import br.com.edward.restfull.service.FornecedorService;
import br.com.edward.restfull.service.PessoaService;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    private PessoaService pessoaService;
    
    @Override
    public FornecedorModel cadastrar(FornecedorModel model) {
        return (FornecedorModel)pessoaService.post(model);
    }

    @Override
    public List<FornecedorModel> mostrarTudo() {
        return pessoaService.mostrarTudo().stream().filter(x -> x instanceof FornecedorModel)
                .map(f -> (FornecedorModel)f).collect(Collectors.toList());
    }

}
