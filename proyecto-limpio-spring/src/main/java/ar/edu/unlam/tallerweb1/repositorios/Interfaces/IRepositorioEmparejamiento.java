package ar.edu.unlam.tallerweb1.repositorios.Interfaces;

import ar.edu.unlam.tallerweb1.modelo.Atributo;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.RoomieAtributos;

import java.util.List;

public interface IRepositorioEmparejamiento {

    List<Roomie> obtenerRoomies();

    Roomie obtenerRoomiePorId(Long id);

    void agregarRoomie(Roomie roomie);

    void guardarAtributosRoomie(RoomieAtributos pasarDatosRegistroARoomieAtributos);

    List<Roomie> obtenerIdRoomies();

    List<RoomieAtributos> obtenerAtributosPorId(Long idRoomie);
}
