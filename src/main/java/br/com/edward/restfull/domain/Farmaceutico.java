package br.com.edward.restfull.domain;

import br.com.edward.restfull.model.FarmaceuticoModel;
import lombok.Getter;

@Getter
public class Farmaceutico extends PessoaFisica {

    private String crf;

    public Farmaceutico() {
        super();
    }

    public Farmaceutico(FarmaceuticoModel model) {
        super(model);
        this.crf = model.getCrf();
    }
}
