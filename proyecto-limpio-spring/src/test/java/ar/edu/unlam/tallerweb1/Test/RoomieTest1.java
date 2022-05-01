package ar.edu.unlam.tallerweb1.Test;
import  org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class RoomieTest1 {

    private Integer id = 1;
    private String nombre = "Juan";
    private String apellido = "Perez";
    private String nick = "JuanPe";
    private String pass = "hola123";
    private String mail = "juan@gamil.com";
    private Integer edad = 20;
    private Boolean recibirDonacion = true;
    Roomie roomie = new Roomie(id, nombre, apellido, nick, pass, mail, edad, recibirDonacion);

    private Integer id2 = 2;
    private String nombre2 = "Pablo";
    private String apellido2 = "Gonzalez";
    private String nick2 = "PabloGonza";
    private String pass2 = "iuwshefw";
    private String mail2 = "pablo@gamil.com";
    private Integer edad2 = 30;
    private Boolean recibirDonacion2 = false;

    Roomie roomie2 = new Roomie(id2, nombre2, apellido2, nick2, pass2, mail2, edad2, recibirDonacion2);

    Roomie roomie3 = new Roomie(2, "Maria", apellido2, nick2, pass2, mail2, edad2, recibirDonacion2);
    Roomie roomie4 = new Roomie(3, nombre2, apellido2, nick2, pass2, mail2, edad2, recibirDonacion2);
    Roomie roomie5 = new Roomie(4, nombre2, apellido2, nick2, pass2, mail2, edad2, recibirDonacion2);

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




}
