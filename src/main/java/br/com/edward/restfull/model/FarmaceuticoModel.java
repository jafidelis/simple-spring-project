package br.com.edward.restfull.model;

import br.com.edward.restfull.domain.Farmaceutico;
import br.com.edward.restfull.enuns.EnumTipoOculos;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FarmaceuticoModel extends PessoaModel {

    private EnumTipoOculos usaOculos;
    private String crf;
    
    public FarmaceuticoModel(Farmaceutico domain) {
        super(domain);
        this.usaOculos = domain.getUsaOculos();
        this.crf = domain.getCrf();
    }
}
