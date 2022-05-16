package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Atributo;
import ar.edu.unlam.tallerweb1.modelo.Roomie;

public class ServicioEmparejamientoImpl implements  ServicioEmparejamiento{
    @Override
    public Double matcheoDeRoomie(Roomie roomie1, Roomie roomie2) {
        Double coincidencia=0.0;
        Double resultado = 0.0;
        if (roomie1.mostrarAtributos().contains(Atributo.FUMADOR)&&(roomie2.mostrarAtributos().contains(Atributo.FUMADOR))) {
            coincidencia++;
        }
        if (roomie1.mostrarAtributos().contains(Atributo.DIURNO)&&(roomie2.mostrarAtributos().contains(Atributo.DIURNO))) {
            coincidencia++;
        }
        if (roomie1.mostrarAtributos().contains(Atributo.NOCTURNO)&&(roomie2.mostrarAtributos().contains(Atributo.NOCTURNO)))
        {
            coincidencia++;
        }
        resultado += ((coincidencia) / ((roomie1.mostrarAtributos().size()))) * ((coincidencia) / ((roomie2.mostrarAtributos().size()))) *100;
        return resultado;
    }
}
