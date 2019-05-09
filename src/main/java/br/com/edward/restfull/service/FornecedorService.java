package br.com.edward.restfull.service;

import java.util.List;

import br.com.edward.restfull.model.FornecedorModel;

public interface FornecedorService {

    FornecedorModel cadastrar(FornecedorModel model);
    List<FornecedorModel> mostrarTudo();
}
