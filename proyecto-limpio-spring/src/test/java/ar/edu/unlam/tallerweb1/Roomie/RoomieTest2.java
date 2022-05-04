package ar.edu.unlam.tallerweb1.Roomie;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertTrue;

public class RoomieTest2 {
    Roomie roomie1 = new Roomie(1, "Pepe", "Argento", "Pepito", "1234", "", 32, 10.0, false);
    Roomie roomie2 = new Roomie(2, "Moni", "Argento", "Monita", "1234", "MoArgento@gmail.com", 31, 120.0, true);

    @Test
    public void queSePuedanCompararDosRoomies(){
        Coincidencia coincidencia = new Coincidencia();
//La comparacion deberia retornar el porcentaje que machean
        Double resultado= coincidencia.compararCoincidencia(roomie1,roomie2);

        assertThat(resultado).isEqualTo(60.0);
    }

}
