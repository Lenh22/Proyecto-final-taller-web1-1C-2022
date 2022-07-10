package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;

public class DatosGamification {

    private String email;
    private Integer puntaje;
    @Autowired
    public DatosGamification(String email, int puntaje) {

        this.email = email;
        this.puntaje=puntaje;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
