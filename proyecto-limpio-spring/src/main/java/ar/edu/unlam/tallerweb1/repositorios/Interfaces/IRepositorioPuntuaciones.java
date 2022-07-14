package ar.edu.unlam.tallerweb1.repositorios.Interfaces;

import ar.edu.unlam.tallerweb1.modelo.Roomie;

import java.util.List;

public interface IRepositorioPuntuaciones {

    List<Roomie> ObtenerRoomies();

    Roomie ObtenerUnRoomie(Long id);;

    Roomie ObtenerUnRoomieMail(String email);

    Roomie buscarUsuario(String email, String password);

    Roomie buscarRoomie(Long id, Boolean puntuacion);

    void AgregarRoomie(Roomie roomie);

    void AgregarRoomiePuntuado(Roomie roomie);
}
