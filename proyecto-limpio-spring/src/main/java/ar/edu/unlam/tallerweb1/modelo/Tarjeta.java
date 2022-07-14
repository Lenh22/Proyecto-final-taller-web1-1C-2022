package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Tarjeta {

    private Long numeroTarjeta;
    private String titular;
    private int mes;
    private int anio;
    private int cvc;
    private int idRoomie;
    @Id
    @GeneratedValue
    private Integer id;

    public  Tarjeta(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(Long numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public int getIdRoomie() {
        return idRoomie;
    }

    public void setIdRoomie(int idRoomie) {
        this.idRoomie = idRoomie;
    }
}