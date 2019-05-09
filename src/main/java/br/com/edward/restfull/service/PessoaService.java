package br.com.edward.restfull.service;

import java.util.List;

import br.com.edward.restfull.model.PessoaModel;

public interface PessoaService {

    PessoaModel post(PessoaModel model);
    List<PessoaModel> mostrarTudo();
    PessoaModel remover(Long id);
}
