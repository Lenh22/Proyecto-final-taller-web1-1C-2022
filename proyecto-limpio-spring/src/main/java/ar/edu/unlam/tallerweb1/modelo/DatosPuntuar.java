package ar.edu.unlam.tallerweb1.modelo;

public class DatosPuntuar {
    private Roomie roomie;
    private Boolean puntuacion;
    private Long id;

    public DatosPuntuar(Long id, Boolean puntuacion) {
        this.id = id;
        this.puntuacion = puntuacion;
    }

    public DatosPuntuar() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Boolean puntuacion) {
        this.puntuacion = puntuacion;
    }

}
