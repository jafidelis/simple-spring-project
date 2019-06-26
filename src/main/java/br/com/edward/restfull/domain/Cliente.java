package br.com.edward.restfull.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.edward.restfull.enuns.EnumTipoCliente;
import br.com.edward.restfull.model.ClienteModel;
import lombok.Getter;

@Getter

@Entity
@Table(name="cliente")
public class Cliente extends Pessoa {

    @Enumerated(EnumType.STRING)
    @Column(name="tipo")
    private EnumTipoCliente tipo;

    @Column(name="limite")
    private Double limite;
    
    public Cliente() {
        super();
    }

    public Cliente(ClienteModel model) {
        super(model);
        this.tipo = model.getTipo();
        this.limite = model.getLimite();
    }
    
    @Override
    public Boolean getDocumentoValido() {
        return Objects.nonNull(super.getDocumento()) && (super.getDocumento().length() == 11 || super.getDocumento().length() == 14);
    }
}
