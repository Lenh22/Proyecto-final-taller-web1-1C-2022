package ar.edu.unlam.tallerweb1.servicios;

public interface IServicioDeGamification {
    Integer ReCalcularPuntajeGamification(String email);

    String obtenerNombreDeLaMedalla(String mail);
}
