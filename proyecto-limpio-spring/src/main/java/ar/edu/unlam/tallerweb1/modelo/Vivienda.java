package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
@Table(name = "vivienda")
public class Vivienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vivienda;

    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;

    private String direccion;

    @OneToOne
    private Alquiler alquiler;
    private Integer cantidadMaximaRoomies;

    public Integer getVivienda() {
        return vivienda;
    }

    public void setVivienda(Integer vivienda) {
        this.vivienda = vivienda;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    public Integer getCantidadMaximaRoomies() {
        return cantidadMaximaRoomies;
    }

    public void setCantidadMaximaRoomies(Integer cantidadMaximaRoomies) {
        this.cantidadMaximaRoomies = cantidadMaximaRoomies;
    }
}
