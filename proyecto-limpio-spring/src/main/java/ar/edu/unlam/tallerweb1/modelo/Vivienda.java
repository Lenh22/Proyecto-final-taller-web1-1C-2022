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

    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;

    public Vivienda(String direccion, Integer cantidadMaximaRoomies, Propietario propietario) {
        this.direccion = direccion;
        this.cantidadMaximaRoomies = cantidadMaximaRoomies;
        this.propietario = propietario;
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
}
