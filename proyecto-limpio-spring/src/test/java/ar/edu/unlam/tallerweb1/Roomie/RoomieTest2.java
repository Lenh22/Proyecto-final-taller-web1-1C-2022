package ar.edu.unlam.tallerweb1.Roomie;

import ar.edu.unlam.tallerweb1.modelo.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertTrue;

public class RoomieTest2 {
    private Integer id=1,id_Alquiler=12,cantidadMaximaRoomies=2,id_roomie=1,id_vivienda=1;
    private String direccion="Av. SinNombre 1234";

    //
    Roomie roomie1 = new Roomie(1, "Pepe", "Argento", "1234", "", 32, 10.0, false);
    Roomie roomie2 = new Roomie(2, "Moni", "Argento", "1234", "MoArgento@gmail.com", 31, 120.0, true);
   //

   //

    Alquiler alquiler1 = new Alquiler( id_Alquiler);
    Vivienda vivienda1 = new Vivienda(id_vivienda, direccion , cantidadMaximaRoomies, alquiler1);

    //
    Propietario propietario1 = new Propietario(id,"Dardo","Fuseneco","1234","Dardo@gmail.com",35,vivienda1);
/*
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
        Double resultado= coincidencia.compararCoincidencia(roomie1,propietario1.getVivieda());

        assertThat(resultado).isEqualTo(60.0);
    }*/

}
