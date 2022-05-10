package ar.edu.unlam.tallerweb1.modelo;

import ar.edu.unlam.tallerweb1.Roomie.Usuario;
import ar.edu.unlam.tallerweb1.Roomie.Vivienda;

public class Propietario extends Usuario {


    private Vivienda vivienda1;

    public Propietario(Integer id, String nombre, String apellido, String pass, String mail, Integer edad, Vivienda vivienda1) {
        super(id, nombre, apellido, pass, mail, edad);

        this.vivienda1 = vivienda1;
    }
}
