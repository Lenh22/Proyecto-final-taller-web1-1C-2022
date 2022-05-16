package ar.edu.unlam.tallerweb1.modelo;

import ar.edu.unlam.tallerweb1.Roomie.Atributo;
import ar.edu.unlam.tallerweb1.Roomie.Usuario;

import java.util.*;

public class Roomie extends Usuario {

    private Boolean recibirDonacion;

    private double ingreso;
    private double puntaje;
    private double cantidadTotalPuntuada;
    private double billeteraDeDonaciones;



    //Tengo dudas de q sea un ArrayList o un TreeSet
    private TreeSet<Atributo> atributos= new TreeSet<>();


    public void setCoincidencia(double coincidencia) {
        this.coincidencia = coincidencia;
    }

    private double coincidencia;



    public Roomie(Integer id, String nombre, String apellido, String pass, String mail, Integer edad, Double ingreso , Boolean recibirDonacion) {
        super(id, nombre, apellido, pass, mail, edad);
        this.ingreso = ingreso;
        this.recibirDonacion = recibirDonacion;
        this.puntaje = 0.0;
        this.cantidadTotalPuntuada = 0.0;
        this.billeteraDeDonaciones=0.0;

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
    public boolean recibeDonacion(Roomie otro, Double minimovitalmovil) {


        if (otro.ingreso < minimovitalmovil) {
            return recibirDonacion = true;
        } else {
            return recibirDonacion = false;
        }
    }

    public void donarAOtroRoomie(Roomie otro, Double donacion){
        if(otro.getRecibirDonacion()==true) {
            otro.billeteraDeDonaciones += donacion;

        }else {
            otro.billeteraDeDonaciones=0.0;
        }



    }

    public Double getBilleteraDeDonaciones() {
        return billeteraDeDonaciones;
    }

    public Boolean getRecibirDonacion() {
        return recibirDonacion;
    }


    public void agregarAtributo(Atributo atributo) {
        atributos.add(atributo);
    }

    public TreeSet<Atributo> mostrarAtributos(){
    return atributos;
    }
    public double getCoincidencia() {
        return coincidencia;
    }




}


