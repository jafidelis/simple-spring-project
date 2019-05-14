package br.com.edward.restfull.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.edward.restfull.domain.Usuario;
import br.com.edward.restfull.model.UsuarioModel;
import br.com.edward.restfull.repository.UsuarioRepository;
import br.com.edward.restfull.service.UsuarioService;

@Transactional
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public Usuario cadastrar(UsuarioModel model) {
        return usuarioRepository.save(new Usuario(model));
    }

    @Override
    public List<Usuario> mostrarTudo() {
        return usuarioRepository.findAll();
    }

}
