package br.com.edward.restfull.service;

import java.util.List;

import br.com.edward.restfull.domain.Pessoa;

public interface PessoaService {

    List<Pessoa> mostrarTudo();
    Pessoa remover(Long id);
    Pessoa consultar(Long idPessoa);
}
