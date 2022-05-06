package ar.edu.unlam.tallerweb1.modelo;

import ar.edu.unlam.tallerweb1.Roomie.Usuario;

public class Propietario extends Usuario {

    private Vivienda vivienda;



    public Propietario(Integer id, String nombre, String apellido, String pass, String mail, Integer edad, Vivienda vivienda){
        super(id, nombre, apellido, pass, mail, edad);
        this.vivienda=vivienda;


    }
}
