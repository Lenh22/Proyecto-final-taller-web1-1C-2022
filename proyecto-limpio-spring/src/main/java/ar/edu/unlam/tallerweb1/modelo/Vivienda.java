package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
@Table(name = "vivienda")
public class Vivienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_vivienda;

    @ManyToOne
    private Propietario propietario;

    private String direccion;

    @OneToOne
    @JoinColumn(name= "id_alquiler")
    private Alquiler alquiler;
    private Integer cantidadMaximaRoomies;


}
