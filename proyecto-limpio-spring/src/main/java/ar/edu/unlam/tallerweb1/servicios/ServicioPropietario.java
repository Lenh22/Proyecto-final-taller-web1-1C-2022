package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Propietario;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioPropietario;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioPropietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicioPropietario implements IServicioPropietario {

    private IRepositorioPropietario repositorioPropietario;

    @Autowired
    public ServicioPropietario(IRepositorioPropietario repositorioPropietario){
        this.repositorioPropietario=repositorioPropietario;
    }

    @Override
    public Propietario obtenerPorId(Long id) {
        return repositorioPropietario.obtenerPorId(id);
    }
}
