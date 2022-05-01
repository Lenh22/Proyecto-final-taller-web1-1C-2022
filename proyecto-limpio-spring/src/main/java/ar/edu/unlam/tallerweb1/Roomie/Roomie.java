package ar.edu.unlam.tallerweb1.Roomie;

public class Roomie extends Usuario{

    private Boolean recibirDonacion;
    private double puntaje;
    private double cantidadTotalPuntuada;

    public Roomie(Integer id, String nombre, String apellido, String nick, String pass, String mail, Integer edad, Boolean recibirDonacion) {
        super(id, nombre, apellido, nick, pass, mail, edad);
        this.recibirDonacion = recibirDonacion;
        this.puntaje = 0.0;
        this.cantidadTotalPuntuada = 0.0;
    }

    public void puntuar(Roomie roomie2, Boolean puntuacion) {

        if (puntuacion == true) {
            roomie2.subirPuntaje();
        } else {
            roomie2.bajarPuntaje();
        }
    }

    private void bajarPuntaje() {
        this.cantidadTotalPuntuada++;
    }

    private void subirPuntaje() {
        this.cantidadTotalPuntuada++;
        this.puntaje++;
    }

    public Double verPuntuacion() {
        Double resultado = 0.0;
        resultado = (this.puntaje / this.cantidadTotalPuntuada) * 100;
        return resultado;

    }
}
