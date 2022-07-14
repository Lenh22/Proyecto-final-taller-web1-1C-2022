package ar.edu.unlam.tallerweb1.servicios.Interfaces;

import ar.edu.unlam.tallerweb1.modelo.Excepciones.UsuarioExistente;
import ar.edu.unlam.tallerweb1.modelo.Excepciones.ViviendaExistente;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vivienda;

import java.util.List;

public interface IServicioBuscador {
    void  saveRoomie(Roomie roomie);
    List<Usuario> ListarRoomies();
    List<Usuario> ListarRoomiesPorFiltro(Long id);

    List<Roomie> ListarRoomiesPorFiltro2(String nombre) throws UsuarioExistente;

    Integer getTotalRoomies();

    Roomie buscarRoomiePorNombre(String nombre);

    void saveAlquiler(Vivienda vivienda);
    //Vivienda consultarAlquiler(String direccion);
    // List<Vivienda> buscarAlquileres(String nombre);
    Vivienda buscarAlquilerPorDireccion(String direccion);
    List<Vivienda> ListarAlquileres();
    List<Vivienda> ListarAlquileresPorFiltro(Integer id);

    List<Vivienda> ListarAlquileresPorFiltro2(String direccion) throws ViviendaExistente;

    Integer getTotalViviendas();
}
