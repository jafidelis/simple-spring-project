package br.com.edward.restfull.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.edward.restfull.model.FarmaceuticoModel;
import lombok.Getter;

@Getter

@Entity
@Table(name="farmaceutico")
public class Farmaceutico extends Pessoa {

    private String crf;
    private Boolean usaOculos;

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
