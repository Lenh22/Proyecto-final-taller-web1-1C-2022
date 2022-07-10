package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;

import java.util.List;

public interface IRepositorioDescuento {

    Roomie buscarRoomiePorMailyPass(String email, String password);

    List<Roomie> ObtenerRoomiesConDescuento();

    void AgregarRoomieConDescuento(Roomie roomie);
}
