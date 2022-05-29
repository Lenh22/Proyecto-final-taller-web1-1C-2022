package ar.edu.unlam.tallerweb1.modelo;

import ar.edu.unlam.tallerweb1.modelo.Atributo;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Roomie")
public class Roomie extends Usuario {

    private Boolean recibirDonacion;

    private double ingreso;
    private double puntaje;
    private double cantidadTotalPuntuada;
    private double billeteraDeDonaciones;
    @ElementCollection
    private TreeSet<Atributo> atributos= new TreeSet<>();
    @ManyToOne
    @JoinColumn(name = "alquiler_id")
    private  Alquiler alquiler;

    public Roomie() { }

    //Constructor para un roomie con la lista de atributos ya armadas
    public Roomie(String nombre, String apellido, Integer edad, String email, String password, String rol
            , Boolean activo, Boolean recibirDonacion, double ingreso, double puntaje, double cantidadTotalPuntuada
            , double billeteraDeDonaciones, TreeSet<Atributo> atributos) {
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
        this.atributos = new TreeSet<Atributo>();
    }

    //Constructor para armar un roomie,  solo con los atributos de usuarios
    public Roomie(String nombre, String apellido, Integer edad, String email, String password, String rol, Boolean activo) {
        super(nombre, apellido, edad, email, password, rol, activo);
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

}



