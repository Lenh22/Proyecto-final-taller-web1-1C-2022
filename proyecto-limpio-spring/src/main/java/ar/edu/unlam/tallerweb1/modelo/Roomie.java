package ar.edu.unlam.tallerweb1.modelo;


import javax.persistence.*;
import java.util.*;

@Entity
@PrimaryKeyJoinColumn(name="usuario_id")
public class Roomie extends Usuario {

    private Boolean recibirDonacion;

    private double ingreso;
    private double puntaje;
    private double cantidadTotalPuntuada;
    private double billeteraDeDonaciones;

    private Boolean puntuacion;
    private Boolean estudiante;

    private Integer cantidadDeDenuncias;

    public Integer puntajeGamification;

    @ManyToOne(optional = true)
    private  Alquiler alquiler;

    //Constructor para un roomie con la lista de atributos ya armadas
    public Roomie(String nombre, String apellido, Integer edad, String email, String password, String rol
            , boolean activo, Boolean recibirDonacion, double ingreso, double puntaje, double cantidadTotalPuntuada
            , double billeteraDeDonaciones) {
        super(nombre, apellido, edad, email, password, rol, activo);
        this.recibirDonacion = recibirDonacion;
        this.ingreso = ingreso;
        this.puntaje = puntaje;
        this.cantidadTotalPuntuada = cantidadTotalPuntuada;
        this.billeteraDeDonaciones = billeteraDeDonaciones;
    }

    //Constructor para un Roomie con la list de atributos vacias
    public Roomie(String nombre, String apellido, Integer edad, String email, String password, String rol
            , Boolean activo, Boolean recibirDonacion, double ingreso, double puntaje, double cantidadTotalPuntuada
            , double billeteraDeDonaciones) {
        super(nombre, apellido, edad, email, password, rol, activo);
        this.recibirDonacion = recibirDonacion;
        this.ingreso = ingreso;
        this.puntaje = puntaje;
        this.cantidadTotalPuntuada = cantidadTotalPuntuada;
        this.billeteraDeDonaciones = billeteraDeDonaciones;
    }

    //Constructor para armar un roomie,  solo con los atributos de usuarios
    public Roomie(String nombre, String apellido, Integer edad, String email, String password, String rol, Boolean activo) {
        super(nombre, apellido, edad, email, password, rol, activo);
    }

    public Roomie(String maria, String gonzalez, int i, String mail, String pass, boolean b, double v, double v1, double v2, double v3) {
    }

    //Constructor para datos registro
    public Roomie(String nombre, String apellido, Integer edad, String email, String password, String rol, Boolean recibirDonaciones, double ingreso,Boolean activo) {
        super(nombre, apellido, edad, email, password, rol,activo);
        this.recibirDonacion = recibirDonacion;
        this.ingreso = ingreso;
    }

    public Roomie(String nombre, String apellido, int edad, String email, String password,String rol,boolean activo, boolean recibirDonacion, double ingreso, double puntaje, double cantidadTotalPuntuada, double billeteraDeDonaciones, int cantidadDeDenuncias ,int puntajeGamification) {
        super(nombre,apellido,edad,email,password,rol,activo);
        this.recibirDonacion = recibirDonacion;
        this.ingreso = ingreso;
        this.puntaje = puntaje;
        this.cantidadTotalPuntuada = cantidadTotalPuntuada;
        this.billeteraDeDonaciones = billeteraDeDonaciones;
        this.cantidadDeDenuncias=cantidadDeDenuncias;
        this.puntajeGamification= puntajeGamification;
    }

    public Roomie(String s, String s1, int i, String s2, String password, String rol, boolean b, boolean b1, int i1, int i2, int i3, int i4) {
    }
    public Roomie(String maria, String gonzalez, int i, String mail, String pass, String rol, boolean b, double v, boolean b1, double v1, double v2, Double billeteraDeDonaciones) {
    }

    public Roomie() {

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
    public Double getBilleteraDeDonaciones() {
        return billeteraDeDonaciones;
    }

    public Boolean getRecibirDonacion() {
        return recibirDonacion;
    }

    public Integer getCantidadDeDenuncias() {
        return cantidadDeDenuncias;
    }

    public void setCantidadDeDenuncias(Integer cantidadDeDenuncias) {
        this.cantidadDeDenuncias = cantidadDeDenuncias;
    }

    public Integer getPuntajeGamification() {
        return puntajeGamification;
    }

    public void setPuntajeGamification(Integer puntajeGamification) {
        this.puntajeGamification = puntajeGamification;
    }

    public Boolean getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Boolean puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Boolean getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Boolean estudiante) {
        this.estudiante = estudiante;
    }
}



