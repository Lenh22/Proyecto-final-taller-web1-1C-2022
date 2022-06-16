package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;

import java.util.List;

public interface IRepositorioRoomie {

    Roomie buscar(String roomie);

    List<Roomie> obtenerRoomies();

    void agregarRoomie(Roomie roomie);

    Roomie ObtenerUnRoomie(String email);

    List<Roomie> ObtenerUnRoomiDonatario(Boolean recibe);

    void actualizar(Roomie roomie1);
}
