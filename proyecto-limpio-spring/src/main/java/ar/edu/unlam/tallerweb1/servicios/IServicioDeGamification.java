package ar.edu.unlam.tallerweb1.servicios;

public interface IServicioDeGamification {
    Integer generarPuntajeGamification(String email);

    String obtenerNivel(String mail);
}
