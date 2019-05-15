package br.com.edward.restfull.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.edward.restfull.domain.Farmaceutico;
import br.com.edward.restfull.model.FarmaceuticoModel;
import br.com.edward.restfull.repository.FarmaceuticoRepository;
import br.com.edward.restfull.service.FarmaceuticoService;

@Transactional
@Service
public class FarmaceuticoServiceImpl implements FarmaceuticoService {

    @Autowired
    private FarmaceuticoRepository farmaceuticoRepository;
    
    @Override
    public Farmaceutico cadastrar(FarmaceuticoModel model) {
        return farmaceuticoRepository.save(new Farmaceutico(model));
    }

    @Override
    public List<Farmaceutico> mostrarTudo() {
        return farmaceuticoRepository.findAll();
    }
}
