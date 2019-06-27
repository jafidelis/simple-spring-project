package br.com.edward.restfull.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.edward.restfull.enuns.EnumTipoOculos;
import br.com.edward.restfull.model.FarmaceuticoModel;
import lombok.Getter;

@Getter

@Entity
@Table(name="farmaceutico")
public class Farmaceutico extends Pessoa {

    @Column(name="crf", length = 128)
    private String crf;
    
    @Enumerated(EnumType.STRING)
    @Column(name="usa_oculos")
    private EnumTipoOculos usaOculos;

    public Farmaceutico() {
        super();
    }

    public Farmaceutico(FarmaceuticoModel model) {
        super(model);
        this.crf = model.getCrf();
        this.usaOculos = model.getUsaOculos();
    }

    @Override
    public Boolean getDocumentoValido() {
        return Objects.nonNull(super.getDocumento()) && super.getDocumento().length() == 11;
    }
}
