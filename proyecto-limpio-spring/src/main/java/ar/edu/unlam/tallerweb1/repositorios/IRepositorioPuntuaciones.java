package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;

import java.util.List;

public interface IRepositorioPuntuaciones {

    List<Roomie> ObtenerRoomies();

    Roomie ObtenerUnRoomie(String email);;

    Roomie buscarUsuario(String email, String password);

    void AgregarRoomie(Roomie roomie);
}
