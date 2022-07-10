package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface IServicioDenuncia {
    Boolean obtenerEstadoDelUsuario(String email);

    Object cambiarEstado(String email, Boolean estado);

    Usuario consultarUsuario(String email);

    void aumentarDenuncia(String email);

    void inactivarRoomiePorCantidadDeDenuncia(String email);
}
