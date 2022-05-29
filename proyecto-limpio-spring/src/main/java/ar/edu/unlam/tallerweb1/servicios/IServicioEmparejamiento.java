package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Atributo;
import ar.edu.unlam.tallerweb1.modelo.Roomie;

import java.util.List;
import java.util.TreeSet;

public interface IServicioEmparejamiento {

    List<Roomie> ObtenerRoomiesCompatibles(Long id);

    Integer CalcularCompatibilidad(TreeSet<Atributo> atributos, TreeSet<Atributo> atributos1);
}
