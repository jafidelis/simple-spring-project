package br.com.edward.restfull.service;

import java.util.List;

import br.com.edward.restfull.domain.Farmaceutico;
import br.com.edward.restfull.model.FarmaceuticoModel;

public interface FarmaceuticoService {

    Farmaceutico cadastrar(FarmaceuticoModel model);
    List<Farmaceutico> mostrarTudo();
}
