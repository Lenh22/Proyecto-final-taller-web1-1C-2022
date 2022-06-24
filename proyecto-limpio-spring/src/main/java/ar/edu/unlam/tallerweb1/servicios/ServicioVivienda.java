package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Vivienda;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioEmparejamiento;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioVivienda;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioVivienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioVivienda implements IServicioVivienda {

    RepositorioVivienda _repositorioVivienda;

    @Autowired
    public  ServicioVivienda(RepositorioVivienda repositorioVivienda){
        this._repositorioVivienda=repositorioVivienda;

    }

    @Override
    public List<Vivienda> getViviendas() {
        List<Vivienda> viviendasTotales= _repositorioVivienda.getViviendas();
        return  viviendasTotales;
    }

    @Override
    public List<Vivienda> getViviendasDisponibles() {
        List<Vivienda> viviendasDisponibles= _repositorioVivienda.getViviendasDisponibles();
        return  viviendasDisponibles;
    }
///
    @Override
    public Boolean reservarVivienda(Long id_vivienda) {
        return null;
    }

}
