package ar.edu.unlam.tallerweb1.servicios.Interfaces;

import ar.edu.unlam.tallerweb1.modelo.Excepciones.UsuarioExistente;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface IServicioPuntuaciones {

    Double puntuacionRoomie (Long id, Boolean puntuacion) throws UsuarioExistente;
    Double verPuntaje(Roomie roomie);
    double bajarPuntaje(Roomie roomie);
    Double subirPuntaje(Roomie roomie);
    Roomie consultarRoomie(Long id);
    void saveRoomie(Roomie roomie);
}
