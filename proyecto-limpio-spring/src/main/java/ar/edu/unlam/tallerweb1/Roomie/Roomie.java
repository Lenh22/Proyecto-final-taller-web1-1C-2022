package ar.edu.unlam.tallerweb1.Roomie;

public class Roomie extends Usuario{

    private Boolean recibirDonacion;

    private double ingreso;
    private double puntaje;
    private double cantidadTotalPuntuada;
    private double billeteraDeDonaciones;

    public Roomie(Integer id, String nombre, String apellido, String nick, String pass, String mail, Integer edad, Double ingreso ,Boolean recibirDonacion) {
        super(id, nombre, apellido, nick, pass, mail, edad);
        this.ingreso = ingreso;
        this.recibirDonacion = recibirDonacion;
        this.puntaje = 0.0;
        this.cantidadTotalPuntuada = 0.0;
        this.billeteraDeDonaciones=0.0;
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
    public boolean recibeDonacion(Roomie otro, Double minimovitalmovil) {


        if (otro.ingreso < minimovitalmovil) {
            return recibirDonacion = true;
        } else {
            return recibirDonacion = false;
        }
    }

    public void donarAOtroRoomie(Roomie otro, Double donacion){
        if(otro.getRecibirDonacion()==true) {
            otro.billeteraDeDonaciones += donacion;

        }else {
            otro.billeteraDeDonaciones=0.0;
        }



    }

    public Double getBilleteraDeDonaciones() {
        return billeteraDeDonaciones;
    }

    public Boolean getRecibirDonacion() {
        return recibirDonacion;
    }



    }


