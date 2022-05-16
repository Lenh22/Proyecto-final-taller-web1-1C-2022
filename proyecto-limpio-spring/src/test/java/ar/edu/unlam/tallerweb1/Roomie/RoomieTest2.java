package ar.edu.unlam.tallerweb1.Roomie;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.ServicioEmparejamiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioEmparejamientoImpl;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertTrue;

public class RoomieTest2 {

    ServicioEmparejamiento servicioEmparejamiento = new ServicioEmparejamientoImpl();
    private Integer id=1,id_Alquiler=12,cantidadMaximaRoomies=2,id_roomie=1,id_vivienda=1;
    private String direccion="Av. SinNombre 1234";

//Creacion de Roomies
    private String nombre = "Juan";
    private String apellido = "Perez";
    private String pass = "hola123";
    private String mail = "juan@gamil.com";
    private Integer edad = 20;

    private Double ingreso =10.0;
    private Boolean recibirDonacion = true;
    Roomie roomie1 = new Roomie(nombre,apellido,edad,mail,pass,true,10000,0.0,0.0,0.0);

    private String nombre2 = "Pablo";
    private String apellido2 = "Gonzalez";
    private String pass2 = "iuwshefw";
    private String mail2 = "pablo@gamil.com";
    private Integer edad2 = 30;
    private Boolean recibirDonacion2 = true;

    private Double ingreso2 = 10.0;

    private Double minimoVitalmovil = 100.0;
    Roomie roomie2 = new Roomie(nombre2,apellido2,edad2,mail2,pass2,recibirDonacion2,ingreso2,0.0,0.0,0.0);
//Creacion de un alquiler para la composicion de Vivienda
    Alquiler alquiler1 = new Alquiler( id_Alquiler);
//Creacion de vivienda para la composicion de Propietario
    Vivienda vivienda1 = new Vivienda(id_vivienda, direccion , cantidadMaximaRoomies, alquiler1);//Creacion de Propietario
    Propietario propietario1 = new Propietario("Dardo","Fuseneco",23,"Dardo@gmail.com","1234",vivienda1);
    @Test
    public void queSePuedanAgregarAtributosAlRoomie() {
        roomie1.agregarAtributo(Atributo.FUMADOR);
        roomie2.agregarAtributo(Atributo.DIURNO);

        assertThat(roomie1.mostrarAtributos()).isEqualTo(Atributo.FUMADOR);
        assertThat(roomie2.mostrarAtributos()).isEqualTo(Atributo.DIURNO);

    }

   /* @Test
    public void queSePuedanCompararDosRoomies(){
        roomie1.agregarAtributo(Atributo.FUMADOR);
        roomie2.agregarAtributo(Atributo.FUMADOR);
//Se crea una clase coincidencia para comparacion de 2 objetos Roomie
        Coincidencia coincidencia = new Coincidencia();
//La comparacion deberia retornar el porcentaje que machean
       /* Double resultado= coincidencia.compararCoincidencia(roomie1,roomie2);

        assertThat(resultado).isEqualTo(100.0);*/

    /*
    @Test
    public void queSePuedanCompararRoomieYVivienda(){
        Coincidencia coincidencia = new Coincidencia();
//La comparacion deberia retornar el porcentaje que machean
      //  Double resultado= coincidencia.compararCoincidencia(roomie1,propietario1.getVivieda());

        assertThat(resultado).isEqualTo(60.0);
    }*/



    @Test
    public void porcentajeDeMatcheo(){




        roomie2.agregarAtributo(Atributo.NOCTURNO);

        roomie1.agregarAtributo(Atributo.DIURNO);

       Double resultado= servicioEmparejamiento.matcheoDeRoomie(roomie1,roomie2);

        assertThat(resultado).isEqualTo(0.0);
    }
}
