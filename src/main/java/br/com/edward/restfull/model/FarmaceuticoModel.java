package br.com.edward.restfull.model;

import br.com.edward.restfull.domain.Farmaceutico;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FarmaceuticoModel extends PessoaModel {

    private Boolean usaOculos;
    private String crf;
    
    public FarmaceuticoModel(Farmaceutico domain) {
        super(domain);
        this.usaOculos = domain.getUsaOculos();
        this.crf = domain.getCrf();
    }
}
