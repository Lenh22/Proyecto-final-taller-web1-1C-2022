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

    private Integer cantidadDeDenuncias;

    public Integer puntajeGamification;

    @ElementCollection
    private List<Atributo> atributos;
    @ManyToOne(optional = true)
    private  Alquiler alquiler;

    public Roomie() { }

    //Constructor para un roomie con la lista de atributos ya armadas
    public Roomie(String nombre, String apellido, Integer edad, String email, String password, String rol
            , Boolean activo, Boolean recibirDonacion, double ingreso, double puntaje, double cantidadTotalPuntuada
            , double billeteraDeDonaciones, LinkedList<Atributo> atributos) {
        super(nombre, apellido, edad, email, password, rol, activo);
        this.recibirDonacion = recibirDonacion;
        this.ingreso = ingreso;
        this.puntaje = puntaje;
        this.cantidadTotalPuntuada = cantidadTotalPuntuada;
        this.billeteraDeDonaciones = billeteraDeDonaciones;
        this.atributos = atributos;
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
        //this.atributos = new List<Atributo>();
    }

    //Constructor para armar un roomie,  solo con los atributos de usuarios
    public Roomie(String nombre, String apellido, Integer edad, String email, String password, String rol, Boolean activo) {
        super(nombre, apellido, edad, email, password, rol, activo);
    }

    public Roomie(String maria, String gonzalez, int i, String mail, String pass, boolean b, double v, double v1, double v2, double v3) {
    }

    public Roomie(String nombre, String apellido, int edad, String email, String password, boolean recibirDonacion, double ingreso, double puntaje, double cantidadTotalPuntuada, double billeteraDeDonaciones, int puntajeGamification) {
        super();
        this.recibirDonacion = recibirDonacion;
        this.ingreso = ingreso;
        this.puntaje = puntaje;
        this.cantidadTotalPuntuada = cantidadTotalPuntuada;
        this.billeteraDeDonaciones = billeteraDeDonaciones;
        this.puntajeGamification= puntajeGamification;

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

    public List<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(LinkedList<Atributo> atributos) {
        this.atributos = atributos;
    }
    public Double getBilleteraDeDonaciones() {
        return billeteraDeDonaciones;
    }

    public Boolean getRecibirDonacion() {
        return recibirDonacion;
    }

    //Agregar a capa de servicio de Roomie
    public void addAtributo(Atributo atributo) {
        atributos.add(atributo);
    }

    public void eliminarAtributo(Atributo atributo){
        atributos.remove(atributo);
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
}



