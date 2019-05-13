package br.com.edward.restfull.domain;

import java.util.Objects;

import br.com.edward.restfull.model.FarmaceuticoModel;
import lombok.Getter;

@Getter
public abstract class PessoaFisica extends Pessoa {

    private Boolean usaOculos;
    
    public PessoaFisica() {
        super();
    }
    
    public PessoaFisica(FarmaceuticoModel model) {
        super(model);
        this.usaOculos = model.getUsaOculos();
    }

    @Override
    public Boolean getDocumentoValido() {
        return Objects.nonNull(super.getDocumento()) && super.getDocumento().length() == 11;
    }
}
