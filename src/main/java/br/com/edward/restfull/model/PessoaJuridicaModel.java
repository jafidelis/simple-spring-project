package br.com.edward.restfull.model;

import java.util.Objects;

public abstract class PessoaJuridicaModel extends PessoaModel {

    private String razaoSocial;
    
    public PessoaJuridicaModel() {
        super();
    }
    
    public PessoaJuridicaModel(String nome) {
        super(nome);
    }
    
    @Override
    public Boolean getDocumentoValido() {
        return Objects.nonNull(super.getDocumento()) && super.getDocumento().length() == 14;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }
}
