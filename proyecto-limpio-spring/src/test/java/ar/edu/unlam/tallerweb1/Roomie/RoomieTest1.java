package ar.edu.unlam.tallerweb1.Roomie;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import  org.junit.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertTrue;

public class RoomieTest1 {

    private Integer id = 1;
    private String nombre = "Juan";
    private String apellido = "Perez";
    private String pass = "hola123";
    private String mail = "juan@gamil.com";
    private Integer edad = 20;

    private Double ingreso =10.0;
    private Boolean recibirDonacion = true;
    Roomie roomie = new Roomie(nombre,apellido,edad,mail,pass,true,10000,0.0,0.0,0.0);


    private Integer id2 = 2;
    private String nombre2 = "Pablo";
    private String apellido2 = "Gonzalez";
    private String pass2 = "iuwshefw";
    private String mail2 = "pablo@gamil.com";
    private Integer edad2 = 30;
    private Boolean recibirDonacion2 = true;

    private Double ingreso2 = 10.0;

    private Double minimoVitalmovil = 100.0;

    Roomie roomie2 = new Roomie(nombre2,apellido2,edad2,mail2,pass2,recibirDonacion2,ingreso2,0.0,0.0,0.0);
    Roomie roomie3 = new Roomie(nombre2,apellido2,edad2,mail2,pass2,recibirDonacion2,ingreso2,0.0,0.0,0.0);
    Roomie roomie4 = new Roomie(nombre2,apellido2,edad2,mail2,pass2,recibirDonacion2,ingreso2,0.0,0.0,0.0);
    Roomie roomie5 = new Roomie(nombre2,apellido2,edad2,mail2,pass2,recibirDonacion2,ingreso2,0.0,0.0,0.0);

    /*Roomie roomie3 = new Roomie(2, "Maria", apellido2, pass2, mail2, edad2,ingreso2, recibirDonacion2);
    Roomie roomie4 = new Roomie(3, nombre2, apellido2, pass2, mail2, edad2,ingreso2, recibirDonacion2);
    Roomie roomie5 = new Roomie(4, nombre2, apellido2, pass2, mail2, edad2,ingreso2, recibirDonacion2);*/

    @Test
    public void queSePuedaPuntuarAUnRoomie(){

        Boolean puntuacion = true;
        //PUNTUAR DEBERIA SUMAR UN VOTO POSITIVO O NEGATIVO
        roomie.puntuar(roomie2, puntuacion);

         entoncesSePudoPuntuar();
    }

    @Test
    public void queVariosPuedanPuntuarAUnRoomie(){

        Boolean puntuacion = true;
        Boolean puntuacion2 = false;
        //PUNTUAR DEBERIA SUMAR UN VOTO POSITIVO O NEGATIVO
        roomie.puntuar(roomie2, puntuacion);
        roomie3.puntuar(roomie2, puntuacion2);
        roomie4.puntuar(roomie2, puntuacion2);
        roomie5.puntuar(roomie2, puntuacion2);

        entoncesSePudoPuntuar2();
    }


    private void entoncesSePudoPuntuar(){
        //VERPUNTUACION DEBERIA MOSTRAR EL PORCENTAJE DE PUNTUACION TOTAL
        assertThat(roomie2.verPuntuacion()).isEqualTo(100);
    }
    private void entoncesSePudoPuntuar2(){
        //VERPUNTUACION DEBERIA MOSTRAR EL PORCENTAJE DE PUNTUACION TOTAL
        assertThat(roomie2.verPuntuacion()).isEqualTo(25.0);
    }

    @Test
    public void puedeRecibirDonaciones(){

        Roomie rommie = new Roomie(nombre,apellido,edad,mail,pass,recibirDonacion,ingreso,0.0,0.0,0.0);

        assertTrue(rommie.recibeDonacion(roomie,minimoVitalmovil));
    }

    @Test
    public void queUnRoomiePuedaDonar() {
        Double donacion =500.0;
        roomie.donarAOtroRoomie(roomie2,donacion);
        roomie3.donarAOtroRoomie(roomie2,200.0);
        Roomie roomie2 = new Roomie(nombre2,apellido2,edad2,mail2,pass2,recibirDonacion2,ingreso2,0.0,0.0,0.0);
        Roomie roomie3 = new Roomie(nombre,apellido,edad,mail,pass,true,10000,0.0,0.0,0.0);

        entoncesSePudoDonar();




    }

    private void entoncesSePudoDonar() {

        assertThat(roomie2.getBilleteraDeDonaciones()).isEqualTo(700.0);

    }
}




