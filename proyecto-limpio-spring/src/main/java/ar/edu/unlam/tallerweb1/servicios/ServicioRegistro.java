package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistro;
import ar.edu.unlam.tallerweb1.modelo.Propietario;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioUsuario;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioRegistro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class ServicioRegistro implements IServicioRegistro {

    private IRepositorioUsuario repositorioUsuario;

    @Autowired
    public ServicioRegistro(IRepositorioUsuario repositorioUsuario){
        this.repositorioUsuario = repositorioUsuario;
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
        if(datosRegistro.getRol().equals("roomie"))
            repositorioUsuario.guardarNuevoUsuario(pasarDatosRegistroARoomie(datosRegistro));
        else
            repositorioUsuario.guardarNuevoUsuario(pasarDatosRegistroAPropietario(datosRegistro));
    }

    public Roomie pasarDatosRegistroARoomie(DatosRegistro datosRegistro) {
        return new Roomie(datosRegistro.getNombre(),datosRegistro.getApellido(),datosRegistro.getEdad(),datosRegistro.getEmail(),datosRegistro.getPassword(),
                datosRegistro.getRol(),datosRegistro.getRecibirDonaciones(),datosRegistro.getIngreso(),datosRegistro.getAtributos());
    }

    public Propietario pasarDatosRegistroAPropietario(DatosRegistro datosRegistro) {
        return new Propietario(datosRegistro.getNombre(), datosRegistro.getApellido(), datosRegistro.getEdad(), datosRegistro.getEmail(), datosRegistro.getPassword(), datosRegistro.getRol());
    }
}
