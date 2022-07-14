package ar.edu.unlam.tallerweb1.modelo.DatosRecibidosPorPost;

public class DatosPuntuar {
    private Boolean puntuacion;
    private Long id;
    private String email;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
