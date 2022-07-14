package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioRoomie;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioDeGamification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicioDeGamification implements IServicioDeGamification {

    private IRepositorioRoomie repositorioRoomies;
    private Integer cantidad = 1;
    private String nivel = "";

    @Autowired
    public ServicioDeGamification(IRepositorioRoomie repositorioRoomies) {
        this.repositorioRoomies = repositorioRoomies;
    }

    @Override
    //ActualizarPuntaje nombre mas claros
    public Integer generarPuntajeGamification(String email) {
        Roomie roomie = repositorioRoomies.ObtenerUnRoomie(email);

        if (roomie.getBilleteraDeDonaciones() >= 1.0) {
            roomie.setPuntajeGamification(roomie.getPuntajeGamification() + 1);
        }
        if (roomie.getCantidadDeDenuncias() >= 1) {
            roomie.setPuntajeGamification(roomie.getPuntajeGamification() - 1);
        }
        if (roomie.getPuntaje() >= 1) {
            roomie.setPuntajeGamification(roomie.getPuntajeGamification() + 1);
        }
        repositorioRoomies.actualizar(roomie);
        return roomie.getPuntajeGamification();
    }

    @Override
    public String obtenerNivel(String mail) {

        if (generarPuntajeGamification(mail) >= 1 && generarPuntajeGamification(mail) < 3) {
            nivel = "RoomieBasico";
        }
        if (generarPuntajeGamification(mail) >= 4 && generarPuntajeGamification(mail) < 5) {
            nivel = "RoomieMedio";
        } else {
            nivel = "RoomieFantastico";
        }
        return nivel;
    }
}
