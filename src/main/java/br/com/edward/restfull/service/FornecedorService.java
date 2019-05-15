package br.com.edward.restfull.service;

import java.util.List;
import java.util.Optional;

import br.com.edward.restfull.domain.Fornecedor;
import br.com.edward.restfull.model.FornecedorModel;

public interface FornecedorService {

    Fornecedor cadastrar(FornecedorModel model);
    List<Fornecedor> mostrarTudo();
    Optional<Fornecedor> findById(Long id);
}
