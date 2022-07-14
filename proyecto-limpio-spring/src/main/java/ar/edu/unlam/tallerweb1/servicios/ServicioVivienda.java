package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Vivienda;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioVivienda;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioVivienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class ServicioVivienda implements IServicioVivienda {

    private IRepositorioVivienda repositorioVivienda;

    @Autowired
    public ServicioVivienda(IRepositorioVivienda repositorioVivienda){
        this.repositorioVivienda = repositorioVivienda;
    }

    @Override
    public Vivienda obtenerViviendaPorId(int idVivienda) {

        return repositorioVivienda.obtenerViviendaPorId(idVivienda);
    }
}
