package ar.edu.unlam.tallerweb1.servicios;

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

    List<Usuario> ListarRoomiesPorFiltro2(String nombre) throws UsuarioExistente;

    Integer getTotalRoomies();

    Roomie buscarRoomiePorId(Long id);

    void saveAlquiler(Vivienda vivienda);
    //Vivienda consultarAlquiler(String direccion);
   // List<Vivienda> buscarAlquileres(String nombre);
    Vivienda buscarAlquilerPorDireccion(Integer id);
    List<Vivienda> ListarAlquileres();
    List<Vivienda> ListarAlquileresPorFiltro(Integer id);

    List<Vivienda> ListarAlquileresPorFiltro2(String direccion) throws ViviendaExistente;

    Integer getTotalViviendas();
}
