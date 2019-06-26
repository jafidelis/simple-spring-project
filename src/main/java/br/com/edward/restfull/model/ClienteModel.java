package br.com.edward.restfull.model;

import javax.validation.constraints.NotNull;

import br.com.edward.restfull.domain.Cliente;
import br.com.edward.restfull.enuns.EnumTipoCliente;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ClienteModel extends PessoaModel {

    private EnumTipoCliente tipo;

    private Double limite;
    
    public ClienteModel(Cliente domain) {
        super(domain);
        this.tipo = domain.getTipo();
        this.limite = domain.getLimite();
    }
}
