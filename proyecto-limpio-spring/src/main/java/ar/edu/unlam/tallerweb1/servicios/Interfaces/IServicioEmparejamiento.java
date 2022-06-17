package ar.edu.unlam.tallerweb1.servicios.Interfaces;

import ar.edu.unlam.tallerweb1.modelo.Atributo;
import ar.edu.unlam.tallerweb1.modelo.Roomie;

import java.util.List;
import java.util.TreeSet;

public interface IServicioEmparejamiento {

    List<Roomie> obtenerRoomiesCompatibles(Long id);

    Integer calcularCompatibilidad(List<Atributo> atributos, List<Atributo> atributos1);
}
