package ar.edu.unlam.tallerweb1.modelo;

import ar.edu.unlam.tallerweb1.modelo.Atributo;

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

    /*public Roomie(String nombre, String apellido, String password, String mail, Integer edad, Double ingreso , Boolean recibirDonacion) {
        super( nombre, apellido, password, mail, edad);
        this.ingreso = ingreso;
        this.recibirDonacion = recibirDonacion;
        this.puntaje = 0.0;
        this.cantidadTotalPuntuada = 0.0;
        this.billeteraDeDonaciones=0.0;
    }*/

    public Roomie() {
    }

    public Roomie(String nombre, String apellido, Integer edad, String email, String password, Boolean recibirDonacion, double ingreso, double puntaje, double cantidadTotalPuntuada, double billeteraDeDonaciones) {
        super(nombre, apellido, edad, email, password);
        this.recibirDonacion = recibirDonacion;
        this.ingreso = ingreso;
        this.puntaje = puntaje;
        this.cantidadTotalPuntuada = cantidadTotalPuntuada;
        this.billeteraDeDonaciones = billeteraDeDonaciones;
    }

    public void setRecibirDonacion(Boolean recibirDonacion) {
        this.recibirDonacion = recibirDonacion;
    }

    public double getIngreso() {
        return ingreso;
    }

    public void setIngreso(double ingreso) {
        this.ingreso = ingreso;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }

    public double getCantidadTotalPuntuada() {
        return cantidadTotalPuntuada;
    }

    public void setCantidadTotalPuntuada(double cantidadTotalPuntuada) {
        this.cantidadTotalPuntuada = cantidadTotalPuntuada;
    }

    public void setBilleteraDeDonaciones(double billeteraDeDonaciones) {
        this.billeteraDeDonaciones = billeteraDeDonaciones;
    }

    public TreeSet<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(TreeSet<Atributo> atributos) {
        this.atributos = atributos;
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



