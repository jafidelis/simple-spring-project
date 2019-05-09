package br.com.edward.restfull.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edward.restfull.model.FarmaceuticoModel;
import br.com.edward.restfull.service.FarmaceuticoService;
import br.com.edward.restfull.service.PessoaService;

@Service
public class FarmaceuticoServiceImpl implements FarmaceuticoService {

    @Autowired
    private PessoaService pessoaService;
    
    @Override
    public FarmaceuticoModel cadastrar(FarmaceuticoModel model) {
        return (FarmaceuticoModel)pessoaService.post(model);
    }

    @Override
    public List<FarmaceuticoModel> mostrarTudo() {
        return pessoaService.mostrarTudo().stream().filter(x -> x instanceof FarmaceuticoModel)
                .map(f -> (FarmaceuticoModel)f).collect(Collectors.toList());
    }
}
