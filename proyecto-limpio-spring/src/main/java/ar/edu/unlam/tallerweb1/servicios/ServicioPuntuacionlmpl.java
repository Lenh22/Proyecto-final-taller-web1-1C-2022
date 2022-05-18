package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;

public class ServicioPuntuacionlmpl implements ServicioDePuntuacion{

    @Override
    public Double puntuacionRoomie(Roomie roomie, Boolean puntuacion) {
        if (puntuacion == true) {
            roomie.subirPuntaje();
        } else {
            roomie.bajarPuntaje();
        }
        return roomie.verPuntuacion();
    }
}
