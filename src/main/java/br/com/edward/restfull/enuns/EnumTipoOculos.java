package br.com.edward.restfull.enuns;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EnumTipoOculos {

    NAO_USA_NADA,
    OCULOS_GRAU,
    OCULOS_SOL,
    OCULOS_SOL_GRAU,
    LENTE_GRAU,
    LENTE_BONITA,
    LENTE_BONITA_GRAU;
    
    @JsonCreator
    public static EnumTipoOculos getByCodigo(String codigo) {
        return EnumTipoOculos.valueOf(codigo);
    }
}
