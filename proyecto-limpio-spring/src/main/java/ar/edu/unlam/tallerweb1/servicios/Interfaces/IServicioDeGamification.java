package ar.edu.unlam.tallerweb1.servicios.Interfaces;

public interface IServicioDeGamification {
    Integer generarPuntajeGamification(String email);

    String obtenerNivel(String mail);

}
