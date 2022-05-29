package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;

import java.util.List;

public interface IRepositorioEmparejamiento {

    List<Roomie> ObtenerRoomies();

    Roomie ObtenerRoomiePorId(Long id);
}
