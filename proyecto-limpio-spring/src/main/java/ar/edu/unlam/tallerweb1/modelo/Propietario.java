package ar.edu.unlam.tallerweb1.modelo;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vivienda;

public class Propietario extends Usuario {


    private Vivienda vivienda1;

    /*public Propietario(Integer id, String nombre, String apellido, String pass, String mail, Integer edad, Vivienda vivienda1) {
        super(id, nombre, apellido, pass, mail, edad);

        this.vivienda1 = vivienda1;
    }*/

    public Propietario(String nombre, String apellido, Integer edad, String email, String password, Vivienda vivienda1) {
        super(nombre, apellido, edad, email, password);
        this.vivienda1 = vivienda1;
    }
}
