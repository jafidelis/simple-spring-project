package br.com.edward.restfull.service;

import java.util.List;
import java.util.Optional;

import br.com.edward.restfull.domain.Cliente;
import br.com.edward.restfull.model.ClienteModel;

public interface ClienteService {

    Cliente cadastrar(ClienteModel model);
    List<Cliente> mostrarTudo();
    Optional<Cliente> consultar(Long idCliente);
}
