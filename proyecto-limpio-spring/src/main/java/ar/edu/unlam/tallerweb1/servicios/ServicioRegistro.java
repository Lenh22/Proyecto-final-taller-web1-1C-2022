package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.DatosRecibidosPorPost.DatosRegistro;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioEmparejamiento;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioUsuario;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioRegistro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional
public class ServicioRegistro implements IServicioRegistro {

    private IRepositorioUsuario repositorioUsuario;
    private IRepositorioEmparejamiento repositorioEmparejamiento;

    @Autowired
    public ServicioRegistro(IRepositorioUsuario repositorioUsuario,IRepositorioEmparejamiento repositorioEmparejamiento){

        this.repositorioUsuario = repositorioUsuario;
        this.repositorioEmparejamiento = repositorioEmparejamiento;
    }

    @Override
    public Boolean verificarUsoDeMail(String email) {
        if(repositorioUsuario.buscarPorMail(email) != null)
            return true;
        else
            return false;
    }

    @Override
    public void registrarNuevoUsuario(DatosRegistro datosRegistro) {
        if(datosRegistro.getRol().equals("roomie")){
            repositorioUsuario.guardarNuevoUsuario(pasarDatosRegistroARoomie(datosRegistro));
            Usuario usuario = repositorioUsuario.buscarPorMail(datosRegistro.getEmail());
            List<Atributo> atributoList = datosRegistro.getAtributos();
            for (Atributo atributo: atributoList) {
                repositorioEmparejamiento.guardarAtributosRoomie(pasarDatosRegistroARoomieAtributos(usuario.getId(),atributo));
            }
        }
        else
            repositorioUsuario.guardarNuevoUsuario(pasarDatosRegistroAPropietario(datosRegistro));
    }

    private RoomieAtributos pasarDatosRegistroARoomieAtributos(Long id, Atributo atributos) {
        return new RoomieAtributos(id,atributos);
    }

    public Roomie pasarDatosRegistroARoomie(DatosRegistro datosRegistro) {
        return new Roomie(datosRegistro.getNombre(),datosRegistro.getApellido(),datosRegistro.getEdad(),datosRegistro.getEmail(),datosRegistro.getPassword(),
                datosRegistro.getRol(),datosRegistro.getRecibirDonaciones(),datosRegistro.getIngreso());
    }

    public Propietario pasarDatosRegistroAPropietario(DatosRegistro datosRegistro) {
        return new Propietario(datosRegistro.getNombre(), datosRegistro.getApellido(), datosRegistro.getEdad(), datosRegistro.getEmail(), datosRegistro.getPassword(), datosRegistro.getRol());
    }
}
