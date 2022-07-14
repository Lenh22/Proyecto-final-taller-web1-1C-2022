package ar.edu.unlam.tallerweb1.modelo;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vivienda;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

import static org.hibernate.annotations.CascadeType.ALL;

@Entity
@PrimaryKeyJoinColumn(name="usuarioId")
public class Propietario extends Usuario {

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(value = ALL)
    private List<Vivienda> vivienda;

    public Propietario(String nombre, String apellido, Integer edad, String email, String password, String rol, Boolean activo) {
        super(nombre, apellido, edad, email, password, rol, activo);
    }

    public Propietario() {

    }

    //Constructor para datos registros
    public Propietario(String nombre, String apellido, Integer edad, String email, String password, String rol) {
        super(nombre, apellido, edad, email, password, rol);
    }
}
