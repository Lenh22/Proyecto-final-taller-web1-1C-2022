package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Vivienda;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioVivienda;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioVivienda;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioVivienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServicioVivienda implements IServicioVivienda {

    private IRepositorioVivienda repositorioVivienda;

    @Autowired
    public  ServicioVivienda(IRepositorioVivienda repositorioVivienda1){
        this.repositorioVivienda =repositorioVivienda1;

    }

    @Override
    public List<Vivienda> getViviendas() {
        List<Vivienda> viviendasTotales= repositorioVivienda.getViviendas();
        return  viviendasTotales;
    }

    @Override
    public List<Vivienda> getViviendasDisponibles() {
        List<Vivienda> viviendasDisponibles= repositorioVivienda.getViviendasDisponibles();
        return  viviendasDisponibles;
    }

    @Override
    public  Vivienda buscarViviendaPorId(int id_vivienda){
        Vivienda viviendaEncontrada = repositorioVivienda.buscarViviendaId(id_vivienda);
        if (viviendaEncontrada!=null){
            return viviendaEncontrada;
        }
        return null;
    }

    @Override
    public void editar(int id, String direccion, int cantidadMaxima)
    {
        Vivienda aEditar = buscarViviendaPorId(id);
        if (aEditar!=null){
            aEditar.setCantidadMaximaRoomies(cantidadMaxima);
            aEditar.setDireccion(direccion);
            repositorioVivienda.editarVivienda(aEditar);
        }
    }

    @Override
    public void crearVivienda(Vivienda datoVivienda) {
        repositorioVivienda.crearVivienda(datoVivienda);
    }
///
    @Override
    public  void borrarVivienda(Vivienda vivienda){
        repositorioVivienda.eliminarVivienda(vivienda);
    }

}
