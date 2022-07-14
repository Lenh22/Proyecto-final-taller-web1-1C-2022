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
    private String nivel = "RoomieBasico";

    @Autowired
    public ServicioDeGamification(IRepositorioRoomie repositorioRoomies) {
        this.repositorioRoomies = repositorioRoomies;
    }

    @Override
    //ActualizarPuntaje nombre mas claros
    public Integer ReCalcularPuntajeGamification(String email) {
        Roomie roomie = repositorioRoomies.ObtenerUnRoomie(email);
        roomie.setCantidadDeDenuncias(0);
        roomie.setPuntajeGamification(0);

        if (roomie.getPuntaje() >= 2) {
            roomie.setPuntajeGamification(2);
        }
        if (roomie.getBilleteraDeDonaciones() >= 5.0) {
            roomie.setPuntajeGamification(roomie.getPuntajeGamification() + 1);
        }
        if (roomie.getCantidadDeDenuncias() >= 1) {
            if(roomie.getPuntajeGamification() > 0)
                roomie.setPuntajeGamification(roomie.getPuntajeGamification() - 1);
        }
        repositorioRoomies.actualizar(roomie);
        return roomie.getPuntajeGamification();
    }

    @Override
    public String obtenerNivel(String mail) {
        nivel = "Inicial";
        if (ReCalcularPuntajeGamification(mail) >= 2 && ReCalcularPuntajeGamification(mail) < 3) {
            nivel = "Medio";
        }
        if (ReCalcularPuntajeGamification(mail) > 3){
            nivel = "Experto";
        }
        return nivel;
    }
}
