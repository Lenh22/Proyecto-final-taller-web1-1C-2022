package ar.edu.unlam.tallerweb1.Roomie;

public class Propietario extends Usuario{

    private Vivienda vivienda;



    public Propietario(Integer id, String nombre, String apellido, String nick, String pass, String mail, Integer edad, Vivienda vivienda){
        super(id, nombre, apellido, nick, pass, mail, edad);
        this.vivienda=vivienda;


    }
}
