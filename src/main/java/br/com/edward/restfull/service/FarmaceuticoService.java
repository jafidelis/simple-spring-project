package br.com.edward.restfull.service;

import java.util.List;

import br.com.edward.restfull.model.FarmaceuticoModel;

public interface FarmaceuticoService {

    FarmaceuticoModel cadastrar(FarmaceuticoModel model);
    List<FarmaceuticoModel> mostrarTudo();
}
