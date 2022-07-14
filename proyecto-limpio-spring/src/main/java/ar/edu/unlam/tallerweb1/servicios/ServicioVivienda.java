package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Vivienda;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioVivienda;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioVivienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public void guardarNuevaVivienda(Vivienda vivienda) {
        repositorioVivienda.guardarNuevaVivienda(vivienda);
    }

    @Override
    public List<Vivienda> obtenerListaViviendas() {
        return repositorioVivienda.obtenerListaViviendas();
    }

    @Override
    public List<Vivienda> obtenerListaViviendasPorIdPropietario(Long id) {
        return repositorioVivienda.obtenerListaViviendasPorIdPropietario(id);
    }

    @Override
    public void eliminarVivienda(Vivienda vivienda) {
        repositorioVivienda.eliminarVivienda(vivienda);
    }

    @Override
    public void modificarVivienda(Vivienda vivienda) {
        repositorioVivienda.modificarVivienda(vivienda);
    }
}
