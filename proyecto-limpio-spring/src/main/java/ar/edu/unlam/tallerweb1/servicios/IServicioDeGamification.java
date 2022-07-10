package ar.edu.unlam.tallerweb1.servicios;

public interface IServicioDeGamification {
    Integer generarPuntajeGamification(String mail);

    String obtenerNivel(String mail);
    void recalculoDePuntaje();
}
