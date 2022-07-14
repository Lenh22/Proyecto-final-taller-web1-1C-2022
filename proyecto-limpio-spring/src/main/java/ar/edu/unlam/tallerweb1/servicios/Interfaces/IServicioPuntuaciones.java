package ar.edu.unlam.tallerweb1.servicios.Interfaces;

import ar.edu.unlam.tallerweb1.modelo.Excepciones.UsuarioExistente;
import ar.edu.unlam.tallerweb1.modelo.Roomie;

public interface IServicioPuntuaciones {

    Double puntuacionRoomie (Roomie roomie, Boolean puntuacion) throws UsuarioExistente;
    Double verPuntuacion(Roomie roomie);
    double bajarPuntaje(Roomie roomie);
    Double subirPuntaje(Roomie roomie);
}
