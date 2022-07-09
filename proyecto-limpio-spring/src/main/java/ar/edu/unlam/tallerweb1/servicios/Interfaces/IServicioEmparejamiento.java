package ar.edu.unlam.tallerweb1.servicios.Interfaces;

import ar.edu.unlam.tallerweb1.modelo.Atributo;
import ar.edu.unlam.tallerweb1.modelo.Roomie;

import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public interface IServicioEmparejamiento {

    List<Roomie> obtenerRoomiesCompatibles(Long id);

    Integer calcularCompatibilidad(long atributos, long atributos1);
}
