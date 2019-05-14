package br.com.edward.restfull.model;

import br.com.edward.restfull.domain.Usuario;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UsuarioModel {

    private Long id;
    private String nome;
    private String login;
    private String senha;
    
    public UsuarioModel(Usuario domain) {
        this.id = domain.getId();
        this.nome = domain.getNome();
        this.login = domain.getLogin();
    }
}
