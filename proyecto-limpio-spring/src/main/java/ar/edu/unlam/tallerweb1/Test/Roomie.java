package ar.edu.unlam.tallerweb1.Test;

import java.util.ArrayList;

public class Roomie {
    private Integer id;
    private String nombre;
    private String apellido;
    private String nick;
    private String pass;
    private String mail;
    private Integer edad;
    private Boolean recibirDonacion;
    private Double puntaje;
    private Double cantidadTotalPuntuada;

    public Roomie(Integer id, String nombre, String apellido, String nick, String pass, String mail, Integer edad,
                  Boolean recibirDonacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nick = nick;
        this.pass = pass;
        this.mail = mail;
        this.edad = edad;
        this.recibirDonacion = recibirDonacion;
        this.puntaje = 0.0;
        this.cantidadTotalPuntuada = 0.0;
    }

    public void puntuar(Roomie roomie2, Boolean puntuacion) {

        if (puntuacion == true) {
            roomie2.subirPuntaje();
        } else {
            roomie2.bajarPuntaje();
        }
    }

    private void bajarPuntaje() {
        this.cantidadTotalPuntuada++;
    }

    private void subirPuntaje() {
        this.cantidadTotalPuntuada++;
        this.puntaje++;
    }

    public Double verPuntuacion() {
        Double resultado = 0.0;
        resultado = (this.puntaje / this.cantidadTotalPuntuada) * 100;
        return resultado;

    }
}
