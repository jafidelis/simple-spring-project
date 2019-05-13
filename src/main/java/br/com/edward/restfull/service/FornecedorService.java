package br.com.edward.restfull.service;

import java.util.List;

import br.com.edward.restfull.domain.Fornecedor;
import br.com.edward.restfull.model.FornecedorModel;

public interface FornecedorService {

    Fornecedor cadastrar(FornecedorModel model);
    List<Fornecedor> mostrarTudo();
}
