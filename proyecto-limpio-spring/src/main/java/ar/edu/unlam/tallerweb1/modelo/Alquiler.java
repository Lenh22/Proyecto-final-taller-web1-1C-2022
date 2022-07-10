package ar.edu.unlam.tallerweb1.modelo;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

import static org.hibernate.annotations.CascadeType.ALL;

@Entity
@Table(name = "alquiler")
public class Alquiler {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_alquiler;

    @OneToOne
    @JoinColumn(name= "id_vivienda")
    private Vivienda vivienda;

    @OneToMany(fetch = FetchType.LAZY)
    @Cascade(value = ALL)
    private List<Roomie> roomie = new LinkedList<>();

}
