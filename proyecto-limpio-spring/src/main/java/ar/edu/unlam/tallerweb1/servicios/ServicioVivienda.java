package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Vivienda;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioVivienda;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioVivienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServicioVivienda implements IServicioVivienda {

    private RepositorioVivienda _repositorioVivienda;

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

    public  Vivienda buscarViviendaPorId(int id_vivienda){
        Vivienda viviendaEncontrada = _repositorioVivienda.buscarViviendaId(id_vivienda);
        if (viviendaEncontrada!=null){
            return viviendaEncontrada;
        }
        return null;
    }

    public  Vivienda editar(int id, String direccion, int cantidadMax)
    {
        Vivienda aEditar = buscarViviendaPorId(id);
        if (aEditar!=null){
            aEditar.setCantidadMaximaRoomies(cantidadMax);
            aEditar.setDireccion(direccion);
        }
        return aEditar;
    }

    public void eliminar(int id)
    {


    }

    public void crearVivienda(Vivienda datoVivienda) {
        _repositorioVivienda.crearVivienda(datoVivienda);
    }
///
    public  void borrarVivienda(Vivienda vivienda){
        _repositorioVivienda.eliminarVivienda(vivienda);
    }

}
