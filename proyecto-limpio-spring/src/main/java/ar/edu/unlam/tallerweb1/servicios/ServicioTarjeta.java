package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Tarjeta;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioTarjeta;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioTarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ServicioTarjeta implements IServicioTarjeta {
    private IRepositorioTarjeta repositorioTarjeta;

    @Autowired
    public ServicioTarjeta(IRepositorioTarjeta iRepositorioTarjeta){
        this.repositorioTarjeta=iRepositorioTarjeta;
    }
    @Override
    public Tarjeta consultarTarjeta(int numeroTarjeta) {
        Tarjeta tarjetaEncontrada = repositorioTarjeta.buscarTarjeta(numeroTarjeta);
        return  tarjetaEncontrada;
    }
}
