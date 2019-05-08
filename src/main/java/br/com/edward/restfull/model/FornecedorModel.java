package br.com.edward.restfull.model;

public class FornecedorModel extends PessoaJuridicaModel {

    private String representacao;

    public FornecedorModel() {
        super();
    }
    
    public FornecedorModel(String nome) {
        super(nome);
    }
    
    public String getRepresentacao() {
        return representacao;
    }
}
