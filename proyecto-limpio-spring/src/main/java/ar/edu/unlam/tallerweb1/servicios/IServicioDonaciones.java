package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;

import java.util.List;

public interface IServicioDonaciones {

    List<Roomie> buscarDonatarios(Boolean recibe) throws Exception ;

    Boolean darDonacion(Roomie roomieDonatario, Double donacion);

    Double incrementaBilletera(Roomie roomie, Double donacion);

    Roomie buscarDonatario(Roomie roomieDonatario);

    Double billeteraDelRoomie(Roomie roomieDonatario);
}
