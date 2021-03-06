package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistro;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Implelemtacion del Servicio de usuarios, la anotacion @Service indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.servicios
// para encontrar esta clase.
// La anotacion @Transactional indica que se debe iniciar una transaccion de base de datos ante la invocacion de cada metodo del servicio,
// dicha transaccion esta asociada al transaction manager definido en el archivo spring-servlet.xml y el mismo asociado al session factory definido
// en hibernateCOntext.xml. De esta manera todos los metodos de cualquier dao invocados dentro de un servicio se ejecutan en la misma transaccion
@Service("servicioLogin")
@Transactional
public class ServicioLogin implements IServicioLogin {

	private RepositorioUsuario repositorioUsuario;

	@Autowired
	public ServicioLogin(RepositorioUsuario repositorioUsuario){
		this.repositorioUsuario = repositorioUsuario;
	}

	@Override
	public Usuario consultarUsuario (String email, String password) {
		return repositorioUsuario.buscarUsuario(email, password);
	}

	@Override
	public void guardarNuevoUsuario(DatosRegistro usuario) {
		Usuario usuarioNuevo = new Usuario();
		usuarioNuevo.setEmail(usuario.getEmail());
		usuarioNuevo.setPassword(usuario.getPassword());
		usuarioNuevo.setNombre(usuario.getNombre());
		usuarioNuevo.setApellido(usuario.getApellido());
		usuarioNuevo.setEdad(usuario.getEdad());
		repositorioUsuario.guardarNuevoUsuario(usuarioNuevo);
	}

}
