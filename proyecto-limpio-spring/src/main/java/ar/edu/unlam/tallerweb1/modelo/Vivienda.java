package ar.edu.unlam.tallerweb1.modelo;

import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "vivienda")
public class Vivienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String direccion;
    private Integer cantidadMaximaRoomies;
    private Integer cantidadAmbientes;
    private String descripcion;
    private Boolean amueblado = false;
    private Boolean alquilado;
    private Integer precioAlquiler;

    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;

    public Vivienda(String direccion, Integer cantidadMaximaRoomies, Integer cantidadAmbientes, String descripcion, Boolean amueblado, Propietario propietario, Integer precioAlquiler) {
        this.direccion = direccion;
        this.cantidadMaximaRoomies = cantidadMaximaRoomies;
        this.cantidadAmbientes = cantidadAmbientes;
        this.descripcion = descripcion;
        this.amueblado = amueblado;
        this.propietario = propietario;
        this.precioAlquiler = precioAlquiler;
    }

    public Vivienda() {

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer vivienda) {
        this.Id = vivienda;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCantidadMaximaRoomies() {
        return cantidadMaximaRoomies;
    }

    public void setCantidadMaximaRoomies(Integer cantidadMaximaRoomies) {
        this.cantidadMaximaRoomies = cantidadMaximaRoomies;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Integer getCantidadAmbientes() {
        return cantidadAmbientes;
    }

    public void setCantidadAmbientes(Integer cantidadAmbientes) {
        this.cantidadAmbientes = cantidadAmbientes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getAmueblado() {
        return amueblado;
    }

    public void setAmueblado(Boolean amueblado) {
        this.amueblado = amueblado;
    }

    public Boolean getAlquilado() {
        return alquilado;
    }

    public void setAlquilado(Boolean alquilado) {
        this.alquilado = alquilado;
    }

    public Integer getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(Integer precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }
}
