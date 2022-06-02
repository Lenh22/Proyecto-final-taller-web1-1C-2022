package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;

import java.util.List;

public interface IRepositorioRoomie {

    Roomie buscar(String roomie);

    List<Roomie> obtenerRoomies();
}
