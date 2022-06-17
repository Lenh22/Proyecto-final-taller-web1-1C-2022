package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Atributo;

import java.util.List;

public class DatosRegistro {

    private	String nombre;
    private Integer edad;
    private String email;
    private String password;
    private String rol;
    private Boolean activo = false;
    private String Apellido;
    private Boolean recibirDonaciones;
    private List<Atributo> atributos;
    private double ingreso;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public Boolean getRecibirDonaciones() {
        return recibirDonaciones;
    }

    public void setRecibirDonaciones(Boolean recibirDonaciones) {
        this.recibirDonaciones = recibirDonaciones;
    }

    public List<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<Atributo> atributos) {
        this.atributos = atributos;
    }

    public double getIngreso() {
        return ingreso;
    }

    public void setIngreso(double ingreso) {
        this.ingreso = ingreso;
    }
}
