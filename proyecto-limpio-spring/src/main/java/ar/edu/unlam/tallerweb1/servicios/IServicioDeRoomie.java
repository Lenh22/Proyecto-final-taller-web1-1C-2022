package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface IServicioDeRoomie {
    Usuario consultarUsuario(String email);
}
