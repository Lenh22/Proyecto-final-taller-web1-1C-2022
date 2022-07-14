package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioAlquiler;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioAlquiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicioAlquiler implements IServicioAlquiler {

    private IRepositorioAlquiler repositorioAlquiler;

    @Autowired
    public ServicioAlquiler(IRepositorioAlquiler repositorioAlquiler){
        this.repositorioAlquiler = repositorioAlquiler;
    }
}
