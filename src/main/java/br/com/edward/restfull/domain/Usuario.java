package br.com.edward.restfull.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.edward.restfull.model.UsuarioModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(name="nome", length = 128)
    private String nome;
    
    @NotNull
    @Column(name="login", length = 128)
    private String login;
    
    @NotNull
    @Column(name="senha", length = 512)
    private String senha;
    
    public Usuario(UsuarioModel model) {
        
        this.nome = model.getNome();
        this.login = model.getLogin();
        this.senha = model.getSenha();
    }
}
