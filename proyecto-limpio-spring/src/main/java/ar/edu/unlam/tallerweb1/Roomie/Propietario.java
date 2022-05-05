package ar.edu.unlam.tallerweb1.Roomie;

public class Propietario extends Usuario{

    private Integer id_vivienda;

    public Propietario(Integer id, String nombre, String apellido, String nick, String pass, String mail, Integer edad,Integer id_vivienda){
        super(id, nombre, apellido, nick, pass, mail, edad);

        this.id_vivienda=id_vivienda;
    }
}
