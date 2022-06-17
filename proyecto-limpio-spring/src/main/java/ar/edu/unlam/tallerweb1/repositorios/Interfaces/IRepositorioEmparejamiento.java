package ar.edu.unlam.tallerweb1.repositorios.Interfaces;

import ar.edu.unlam.tallerweb1.modelo.Roomie;

import java.util.List;

public interface IRepositorioEmparejamiento {

    List<Roomie> obtenerRoomies();

    Roomie obtenerRoomiePorId(Long id);

    void agregarRoomie(Roomie roomie);
}
