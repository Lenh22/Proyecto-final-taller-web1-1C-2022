package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Excepciones.UsuarioExistente;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface IServicioPuntuaciones {

    Double puntuacionRoomie (Roomie roomie, Boolean puntuacion) throws UsuarioExistente;
    Double verPuntaje(Roomie roomie);
    double bajarPuntaje(Roomie roomie);
    Double subirPuntaje(Roomie roomie);
    Roomie consultarRoomie(Long id, Boolean puntuacion);
    void saveRoomie(Roomie roomie);
}
