package br.com.edward.restfull.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import br.com.edward.restfull.model.PessoaModel;
import br.com.edward.restfull.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {

    private static List<PessoaModel> lista = new ArrayList<>();
    
    @Override
    public PessoaModel post(PessoaModel model) {
        lista.add(model);
        return model;
    }

    @Override
    public List<PessoaModel> mostrarTudo() {
        return lista;
    }

    @Override
    public PessoaModel remover(Long id) {
        PessoaModel pessoaRemover = lista.stream().filter(item -> id.equals(item.getId())).findAny().orElse(null);
        if (Objects.nonNull(pessoaRemover)) {
            lista.remove(pessoaRemover);
        }
        return pessoaRemover;
    }
}
