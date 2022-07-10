package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;

public interface IServicioDescuento {
    Boolean verificarAplicacionADescuento(Roomie roomie);

    Boolean aplicaDescuento(Roomie roomie);

    Roomie consultarRoomie(String mail, String pass);

    void saveRoomie(Roomie roomie);
}
