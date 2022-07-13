package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Excepciones.RoomieSinDescuento;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.repositorios.IRepositorioDescuento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicioDescuento implements IServicioDescuento{
    private IRepositorioDescuento repositorioDescuento;

    @Autowired
    public ServicioDescuento(IRepositorioDescuento repositorioDescuento){
        this.repositorioDescuento = repositorioDescuento;
    }

    @Override
    public Boolean verificarAplicacionADescuento(Roomie roomie) throws RoomieSinDescuento {
        Roomie buscado = repositorioDescuento.buscarRoomiePorMailyPass(roomie.getEmail(), roomie.getPassword());

        if(buscado == null){
            throw new RoomieSinDescuento();
        }
        if(buscado != null){
            aplicaDescuento(buscado);
        }
        return false;
    }

    @Override
    public Boolean aplicaDescuento(Roomie roomie) throws RoomieSinDescuento{
        Boolean estudiante = roomie.getEstudiante();
        Integer edad = roomie.getEdad();
        if(estudiante == true){
            if(edad >= 18 && edad<= 25){
                return true;
            }else{
                throw new RoomieSinDescuento();
            }
        }else{
            throw  new RoomieSinDescuento();
        }
    }

    @Override
    public Roomie consultarRoomie(String mail, String pass) {
        return repositorioDescuento.buscarRoomiePorMailyPass(mail, pass);
    }

    @Override
    public void saveRoomie(Roomie roomie) {
        repositorioDescuento.AgregarRoomieConDescuento(roomie);
    }
}
