package ar.edu.unlam.tallerweb1.Roomie;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertTrue;

public class RoomieTest2 {
    private Integer id=1,id_Alquiler=12,cantidadMaximaRoomies=2,id_roomie=1,id_vivienda=1;
    private String direccion="Av. SinNombre 1234";
//Creacion de Roomies
    Roomie roomie1 = new Roomie(1, "Pepe", "Argento", "Pepito", "1234", "", 32, 10.0, false);
    Roomie roomie2 = new Roomie(2, "Moni", "Argento", "Monita", "1234", "MoArgento@gmail.com", 31, 120.0, true);
//Creacion de un alquiler para la composicion de Vivienda
   Alquiler alquiler1 = new Alquiler(id_Alquiler,id_roomie,id_vivienda);
//Creacion de vivienda para la composicion de Propietario
    Vivienda vivienda1 = new Vivienda(id,id_Alquiler,cantidadMaximaRoomies,direccion /*Al ser compuesto quizas hay que poner el alquiler aqui*/);
//Creacion de Propietario
    Propietario propietario1 = new Propietario(id,"Dardo","Fuseneco","Dardi","1234","Dardo@gmail.com",35,id_vivienda);

    @Test
    public void queUnRoomiePuedaGuardarSusCaracteristicas(){
        roomie1.agregarAtributo(Atributo.FUMADOR);
        roomie2.agregarAtributo(Atributo.DIURNO);

    }

    @Test
    public void queSePuedanCompararDosRoomies(){
//Se crea una clase coincidencia para comparacion de 2 objetos Roomie
        Coincidencia coincidencia = new Coincidencia();
//La comparacion deberia retornar el porcentaje que machean
        Double resultado= coincidencia.compararCoincidencia(roomie1,roomie2);

        assertThat(resultado).isEqualTo(60.0);
    }
    public void queSePuedanCompararRoomieYVivienda(){
        Coincidencia coincidencia = new Coincidencia();
//La comparacion deberia retornar el porcentaje que machean
      //  Double resultado= coincidencia.compararCoincidencia(roomie1,propietario1.getVivieda());

        assertThat(resultado).isEqualTo(60.0);
    }

}
