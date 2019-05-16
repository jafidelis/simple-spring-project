package br.com.edward.restfull.enuns;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EnumStatusCarrinho {

    ABERTO,
    FECHADO;
    
    @JsonCreator
    public static EnumStatusCarrinho getByCodigo(String codigo) {
        return EnumStatusCarrinho.valueOf(codigo);
    }
}
