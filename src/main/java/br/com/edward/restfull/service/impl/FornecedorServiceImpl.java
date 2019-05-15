package br.com.edward.restfull.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.edward.restfull.domain.Fornecedor;
import br.com.edward.restfull.model.FornecedorModel;
import br.com.edward.restfull.repository.FornecedorRepository;
import br.com.edward.restfull.service.FornecedorService;

@Transactional
@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;
    
    @Override
    public Fornecedor cadastrar(FornecedorModel model) {
        return fornecedorRepository.save(new Fornecedor(model));
    }

    @Override
    public List<Fornecedor> mostrarTudo() {
        return fornecedorRepository.findAll();
    }

    @Override
    public Optional<Fornecedor> findById(Long id) {
        return fornecedorRepository.findById(id);
    }

}
