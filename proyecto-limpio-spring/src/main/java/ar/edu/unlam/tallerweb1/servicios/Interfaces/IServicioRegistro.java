package ar.edu.unlam.tallerweb1.servicios.Interfaces;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistro;
import ar.edu.unlam.tallerweb1.modelo.Propietario;
import ar.edu.unlam.tallerweb1.modelo.Roomie;

public interface IServicioRegistro {

    Boolean verificarUsoDeMail(String email);

    void registrarNuevoUsuario(DatosRegistro datosRegistro);

    Propietario pasarDatosRegistroAPropietario(DatosRegistro datosRegistro);

    Roomie pasarDatosRegistroARoomie(DatosRegistro datosRegistro);
}
