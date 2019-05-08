package br.com.edward.restfull.model;

public class FarmaceuticoModel extends PessoaFisicaModel {

    private String crf;

    public FarmaceuticoModel() {
        super();
    }
    
    public FarmaceuticoModel(String nome) {
        super(nome);
    }
    
    public String getCrf() {
        return crf;
    }
}
