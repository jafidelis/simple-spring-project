package br.com.edward.restfull.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edward.restfull.domain.Farmaceutico;
import br.com.edward.restfull.model.FarmaceuticoModel;
import br.com.edward.restfull.service.FarmaceuticoService;
import br.com.edward.restfull.service.PessoaService;

@Service
public class FarmaceuticoServiceImpl implements FarmaceuticoService {

    @Autowired
    private PessoaService pessoaService;
    
    @Override
    public Farmaceutico cadastrar(FarmaceuticoModel model) {
        return (Farmaceutico)pessoaService.post(new Farmaceutico(model));
    }

    @Override
    public List<Farmaceutico> mostrarTudo() {
        return pessoaService.mostrarTudo().stream().filter(x -> x instanceof Farmaceutico)
                .map(f -> (Farmaceutico)f).collect(Collectors.toList());
    }
}
