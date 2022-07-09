package ar.edu.unlam.tallerweb1.repositorios.Interfaces;

import ar.edu.unlam.tallerweb1.modelo.Atributo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

// Interface que define los metodos del Repositorio de Usuarios.
public interface IRepositorioUsuario {
	
	Usuario buscarUsuario(String email, String password);
	void guardarNuevoUsuario(Usuario usuario);
    Usuario buscarPorMail(String email);
	void modificar(Usuario usuario);
}
