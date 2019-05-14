package br.com.edward.restfull.service;

import java.util.List;

import br.com.edward.restfull.domain.Usuario;
import br.com.edward.restfull.model.UsuarioModel;

public interface UsuarioService {

    Usuario cadastrar(UsuarioModel model);
    List<Usuario> mostrarTudo();
}
