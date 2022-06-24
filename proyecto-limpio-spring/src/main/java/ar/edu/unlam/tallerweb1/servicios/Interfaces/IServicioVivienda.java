package ar.edu.unlam.tallerweb1.servicios.Interfaces;

import ar.edu.unlam.tallerweb1.modelo.Vivienda;

import java.util.List;

public interface IServicioVivienda {

    List<Vivienda> getViviendas();
    List<Vivienda> getViviendasDisponibles();
    Boolean reservarVivienda(Long id_vivienda);
}
