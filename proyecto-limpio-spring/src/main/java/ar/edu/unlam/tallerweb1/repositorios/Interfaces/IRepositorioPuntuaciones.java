package ar.edu.unlam.tallerweb1.repositorios.Interfaces;

import ar.edu.unlam.tallerweb1.modelo.Roomie;

import java.util.List;

public interface IRepositorioPuntuaciones {

    List<Roomie> obtenerRoomies();

    Roomie obtenerUnRoomie(String email);;

    Roomie buscarUsuario(String email, String password);

    void agregarRoomie(Roomie roomie);
}
