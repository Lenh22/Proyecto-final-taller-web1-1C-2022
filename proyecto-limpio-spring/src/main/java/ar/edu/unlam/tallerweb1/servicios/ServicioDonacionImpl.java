package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;

public class ServicioDonacionImpl implements ServicioDeDonacion{

    @Override
    public void ActivarDonacion(Roomie roomie, boolean activarDonacion) {
        if (activarDonacion == true) {
            roomie.setRecibirDonacion(true);
        }
    }

    @Override
    public Integer DarDonacion(Roomie roomie, Integer cantidadDeDonacion) {
        return null;
    }

}
