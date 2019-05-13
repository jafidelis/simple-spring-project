package br.com.edward.restfull.domain;

import br.com.edward.restfull.model.FornecedorModel;
import lombok.Getter;

@Getter
public class Fornecedor extends PessoaJuridica {

    private String representacao;

    public Fornecedor() {
        super();
    }

    public Fornecedor(FornecedorModel model) {
        super(model);
        this.representacao = model.getRepresentacao();
    }
}
