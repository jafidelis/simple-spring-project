package br.com.edward.restfull.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import br.com.edward.restfull.domain.Pessoa;
import br.com.edward.restfull.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {

    private static List<Pessoa> lista = new ArrayList<>();
    
    @Override
    public Pessoa post(Pessoa model) {
        Pessoa pessoa = this.consultar(model.getId());
        if (Objects.isNull(pessoa)) {
            lista.add(model);
            return model;
        }
        throw new RuntimeException("Pessoa já existe");
    }

    @Override
    public Pessoa consultar(Long idPessoa) {
        return lista.stream().filter(item -> idPessoa.equals(item.getId())).findAny().orElse(null);
    }
    
    @Override
    public List<Pessoa> mostrarTudo() {
        return lista;
    }

    @Override
    public Pessoa remover(Long id) {
        Pessoa pessoaRemover = this.consultar(id);
        if (Objects.nonNull(pessoaRemover)) {
            lista.remove(pessoaRemover);
        }
        return pessoaRemover;
    }
}
