package ar.edu.unlam.tallerweb1.servicios.Interfaces;

import ar.edu.unlam.tallerweb1.modelo.DatosRecibidosPorPost.DatosRegistro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del Servicio de Usuarios.
public interface IServicioLogin {

	Usuario consultarUsuario(String email, String password);

	void guardarNuevoUsuario(DatosRegistro usuario);
}
