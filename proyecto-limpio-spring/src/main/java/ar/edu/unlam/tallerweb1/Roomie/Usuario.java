package ar.edu.unlam.tallerweb1.Roomie;

public class Usuario {

    private Integer id;
    private String nombre;
    private String apellido;
    private String nick;
    private String pass;
    private String mail;
    private Integer edad;
    private CaracteristicasDeUsuario caracteristicas;
    public Usuario(Integer id, String nombre, String apellido, String nick, String pass, String mail, Integer edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nick = nick;
        this.pass = pass;
        this.mail = mail;
        this.edad = edad;

    }
}
