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


}
