package br.com.edward.restfull.domain;

import java.util.Objects;

import br.com.edward.restfull.model.FornecedorModel;
import lombok.Getter;

@Getter
public abstract class PessoaJuridica extends Pessoa {

    private String razaoSocial;
    
    public PessoaJuridica() {
        super();
    }
    
    public PessoaJuridica(FornecedorModel model) {
        super(model);
        this.razaoSocial = model.getRazaoSocial();
    }

    @Override
    public Boolean getDocumentoValido() {
        return Objects.nonNull(super.getDocumento()) && super.getDocumento().length() == 14;
    }
}
