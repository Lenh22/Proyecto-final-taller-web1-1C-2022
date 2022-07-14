package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioRoomie;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioDenuncia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicioDenuncia implements IServicioDenuncia {
    private IRepositorioRoomie repositorioRoomie;
    private RepositorioUsuario repositorioUsuario;
    @Autowired
    public ServicioDenuncia(IRepositorioRoomie repositorioRoomies, RepositorioUsuario repositorioUsuario) {
        this.repositorioRoomie=repositorioRoomies;
        this.repositorioUsuario=repositorioUsuario;
    }

    @Override
    public Boolean obtenerEstadoDelUsuario(String email) {
        if(email !=null){
            return repositorioRoomie.obtenerEstadoDelUsuario(email);
        }
        return false;
    }

    @Override
    public Object cambiarEstado(String email, Boolean estado) {
        Roomie roomie2 = repositorioRoomie.ObtenerUnRoomie(email);
        roomie2.setActivo(false);
        return roomie2.getActivo();
    }

    @Override
    public Usuario consultarUsuario(String email) {
        return repositorioRoomie.ObtenerUnRoomie(email);
    }

    @Override
    public void aumentarDenuncia (String email){
        Roomie roomie2=repositorioRoomie.ObtenerUnRoomie(email);
        Integer cantidadActual = roomie2.getCantidadDeDenuncias();
        Integer catidadTotal = cantidadActual+1;
        roomie2.setCantidadDeDenuncias(catidadTotal);
    }

    @Override
    public void inactivarRoomiePorCantidadDeDenuncia(String email){
        Roomie roomie2=repositorioRoomie.ObtenerUnRoomie(email);
        if(roomie2.getCantidadDeDenuncias()>=10) {
            roomie2.setActivo(false);
        }
        else {
            roomie2.setActivo(true);
        }
    }


}