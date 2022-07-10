package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vivienda;

import java.util.List;

public interface IServicioBuscador {
    void  saveRoomie(Roomie roomie);
    List<Usuario> ListarRoomies();
    List<Usuario> ListarRoomiesPorFiltro(Integer id);

    void saveAlquiler(Vivienda vivienda);
    //Vivienda consultarAlquiler(String direccion);
   // List<Vivienda> buscarAlquileres(String nombre);
    Vivienda buscarAlquilerPorDireccion(String direccion);
    List<Vivienda> ListarAlquileres();
    List<Vivienda> ListarAlquileresPorFiltro(Integer id);
}
