package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;

public interface ServicioDeDonacion {

    void ActivarDonacion (Roomie roomie, boolean activarDonacion);

    Integer DarDonacion (Roomie roomie, Integer cantidadDeDonacion);
}
