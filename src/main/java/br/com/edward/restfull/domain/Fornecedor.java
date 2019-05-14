package br.com.edward.restfull.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.edward.restfull.model.FornecedorModel;
import lombok.Getter;

@Getter

@Entity
@Table(name="fornecedor")
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
