package ar.edu.unlam.tallerweb1.servicios.Interfaces;

import ar.edu.unlam.tallerweb1.modelo.Vivienda;

import java.util.List;

public interface IServicioVivienda {
    Vivienda obtenerViviendaPorId(int idVivienda);

    void guardarNuevaVivienda(Vivienda vivienda);

    List<Vivienda> obtenerListaViviendas();

    List<Vivienda> obtenerListaViviendasPorIdPropietario(Long id);

    void eliminarVivienda(Vivienda vivienda);

    void modificarVivienda(Vivienda idVivienda);
}
