package ar.edu.unlam.tallerweb1.modelo;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vivienda;

import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name="usuario_id")
public class Propietario extends Usuario {

    @OneToMany
    private List<Vivienda> vivienda;

    public Propietario(String nombre, String apellido, Integer edad, String email, String password, String rol, Boolean activo) {
        super(nombre, apellido, edad, email, password, rol, activo);
    }

    public Propietario() {
        super("","",0,"","","",true);
    }

}
