package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "alquiler")
public class Alquiler {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_alquiler;

    @OneToOne
    private Vivienda vivienda;

    @OneToMany(mappedBy = "Roomie", cascade = CascadeType.ALL)
    private List<Roomie> roomie;


}
