package br.com.edward.restfull.domain;

import java.util.Objects;

import br.com.edward.restfull.model.FornecedorModel;
import lombok.Getter;

@Getter
public class Fornecedor extends Pessoa {

    private String representacao;
    private String razaoSocial;

    public Fornecedor() {
        super();
    }

    public Fornecedor(FornecedorModel model) {
        super(model);
        this.representacao = model.getRepresentacao();
        this.razaoSocial = model.getRazaoSocial();
    }

    @Override
    public Boolean getDocumentoValido() {
        return Objects.nonNull(super.getDocumento()) && super.getDocumento().length() == 14;
    }
}
