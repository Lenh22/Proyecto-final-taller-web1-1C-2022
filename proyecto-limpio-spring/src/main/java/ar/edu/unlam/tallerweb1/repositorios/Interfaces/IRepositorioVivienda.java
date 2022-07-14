package ar.edu.unlam.tallerweb1.repositorios.Interfaces;

import ar.edu.unlam.tallerweb1.modelo.Vivienda;

import java.util.LinkedList;
import java.util.List;

public interface IRepositorioVivienda {

    Vivienda getViviendaID(int id_vivienda);
    List<Vivienda> getViviendas();
    List<Vivienda> getViviendasDisponibles();
    Vivienda buscarViviendaId(int id);
    void crearVivienda(Vivienda datoVivienda);

    void editarVivienda(Vivienda aEditar);

    void eliminarVivienda(Vivienda vivienda);
}
