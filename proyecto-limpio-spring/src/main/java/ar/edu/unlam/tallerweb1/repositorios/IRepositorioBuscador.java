package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vivienda;

import java.util.List;

public interface IRepositorioBuscador {

    void AgregarRoomie(Roomie roomie);
    Roomie ObtenerUnRoomie(String nombre);
    List<Usuario> ObtenerRoomies();
    Roomie buscarRoomie(String nombre);
    List<Usuario> ObtenerRoomiesPorFiltro(Long id);

    void AgregarAlquiler(Vivienda vivienda);
    List<Vivienda> ObtenerAlquileres();
    Vivienda buscarAlquiler(String direccion);
    List<Vivienda> ObtenerAlquileresPorFiltro(Integer id);
}
