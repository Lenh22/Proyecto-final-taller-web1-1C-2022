package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Excepciones.UsuarioExistente;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface IServicioPuntuaciones {

    Double puntuacionRoomie (Long id, Boolean puntuacion) throws UsuarioExistente;
    Double puntuacionRoomieMail (String email, Boolean puntuacion) throws UsuarioExistente;
    Double verPuntaje(Roomie roomie);
    double bajarPuntaje(Roomie roomie);
    Double subirPuntaje(Roomie roomie);
    Roomie consultarRoomie(Long id);
    Roomie consultarRoomiePorMail(String mail);
    void saveRoomie(Roomie roomie);
}
