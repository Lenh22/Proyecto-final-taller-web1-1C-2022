package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Excepciones.UsuarioExistente;
import ar.edu.unlam.tallerweb1.modelo.Excepciones.ViviendaExistente;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vivienda;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioBuscador;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioBuscador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service @Transactional
public class ServicioBuscador implements IServicioBuscador{

    private IRepositorioBuscador repositorioBuscador;

    private List<Vivienda> viviendas = new ArrayList<>();
    private List<Roomie> roomiesCompatibles = new LinkedList<>();

    @Autowired
    public ServicioBuscador(IRepositorioBuscador repositorioBuscador){
        this.repositorioBuscador = repositorioBuscador;
    }

    @Override
    public void saveRoomie(Roomie roomie) {
        repositorioBuscador.AgregarRoomie(roomie);
    }


    @Override
    public List<Usuario> ListarRoomies() {
        List<Usuario> roomies = repositorioBuscador.ObtenerRoomies();
        return roomies;
    }
    @Override
    public List<Usuario> ListarRoomiesPorFiltro(Long id) throws UsuarioExistente{
        List<Usuario> roomies = repositorioBuscador.ObtenerRoomiesPorFiltro(id);
        if(roomies == null){
            throw new UsuarioExistente();
        }
        return roomies;
    }
    @Override
    public List<Roomie> ListarRoomiesPorFiltro2(String nombre) throws UsuarioExistente{
        List<Roomie> roomies = repositorioBuscador.ObtenerRoomiesPorFiltro2(nombre);
        if(roomies == null){
            throw new UsuarioExistente();
        }
        return roomies;
    }

    @Override
    public Integer getTotalRoomies(){
        return repositorioBuscador.ObtenerRoomies().size();
    }
    @Override
    public Roomie buscarRoomiePorNombre(String nombre){
        return repositorioBuscador.buscarRoomie(nombre);
    }




    @Override
    public void saveAlquiler(Vivienda vivienda) {
        repositorioBuscador.AgregarAlquiler(vivienda);
    }

    @Override
    public Vivienda buscarAlquilerPorDireccion(String direccion){
        Vivienda buscada = repositorioBuscador.buscarAlquiler(direccion);

        if (buscada != null) {
            return buscada;
        }
        return null;
    }

    @Override
    public List<Vivienda> ListarAlquileres() {
        List<Vivienda> viviendas = repositorioBuscador.ObtenerAlquileres();
        return viviendas;
    }

    @Override
    public List<Vivienda> ListarAlquileresPorFiltro(Integer id) throws ViviendaExistente {
        List<Vivienda> viviendas = repositorioBuscador.ObtenerAlquileresPorFiltro(id);
        if(viviendas == null){
            throw new ViviendaExistente();
        }
        return viviendas;
    }
    @Override
    public List<Vivienda> ListarAlquileresPorFiltro2(String direccion) throws ViviendaExistente {
        List<Vivienda> viviendas = repositorioBuscador.ObtenerAlquileresPorFiltro2(direccion);
        if(viviendas == null){
            throw new ViviendaExistente();
        }
        return viviendas;
    }
    @Override
    public Integer getTotalViviendas(){
        return repositorioBuscador.ObtenerAlquileres().size();
    }
}
