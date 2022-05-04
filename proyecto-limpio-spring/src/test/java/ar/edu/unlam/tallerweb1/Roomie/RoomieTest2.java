package ar.edu.unlam.tallerweb1.Roomie;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertTrue;

public class RoomieTest2 {
    Roomie roomie1 = new Roomie(1, "Pepe", "Argento", "Pepito", "1234", "", 32, 10.0, false);
    Roomie roomie2 = new Roomie(2, "Moni", "Argento", "Monita", "1234", "MoArgento@gmail.com", 31, 120.0, true);
    private Integer id=1,id_Alguiler=12,cantidadMaximaRoomies=2;
    private String direccion="Av. SinNombre 1234";
    Vivienda vivienda1 = new Vivienda(id,id_Alguiler,cantidadMaximaRoomies,direccion /*Al ser compuesto quizas hay que poner el alquiler aqui*/);

    @Test
    public void queSePuedanCompararDosRoomies(){
        Coincidencia coincidencia = new Coincidencia();
//La comparacion deberia retornar el porcentaje que machean
        Double resultado= coincidencia.compararCoincidencia(roomie1,roomie2);

        assertThat(resultado).isEqualTo(60.0);
    }
    public void queSePuedanCompararRoomieYVivienda(){
        Coincidencia coincidencia = new Coincidencia();
//La comparacion deberia retornar el porcentaje que machean
        Double resultado= coincidencia.compararCoincidencia(roomie1,departamento);

        assertThat(resultado).isEqualTo(60.0);
    }

}
