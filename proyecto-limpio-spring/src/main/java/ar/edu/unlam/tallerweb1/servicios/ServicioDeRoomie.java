package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.IRepositorioRoomie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicioDeRoomie implements IServicioDeRoomie{

    private IRepositorioRoomie repositorioRoomie;

    @Autowired
    public ServicioDeRoomie(IRepositorioRoomie repositorioRoomie){
        this.repositorioRoomie=repositorioRoomie;

    }

    @Override
    public Usuario consultarUsuario(String email) {

        return repositorioRoomie.ObtenerUnRoomie(email);
    }
    }

