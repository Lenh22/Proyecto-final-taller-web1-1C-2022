package ar.edu.unlam.tallerweb1.Roomie;

import ar.edu.unlam.tallerweb1.modelo.CaracteristicasDeUsuario;

public class Usuario {

    private Integer id;
    private String nombre;
    private String apellido;
    private String pass;
    private String mail;
    private Integer edad;
    private CaracteristicasDeUsuario caracteristicas;
    public Usuario(Integer id, String nombre, String apellido, String pass, String mail, Integer edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pass = pass;
        this.mail = mail;
        this.edad = edad;

    }
}
