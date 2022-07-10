package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.repositorios.IRepositorioRoomie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicioDeGamification implements IServicioDeGamification {

    private IRepositorioRoomie repositorioRoomie;

    @Autowired
    public ServicioDeGamification(IRepositorioRoomie repositorioRoomie) {

        this.repositorioRoomie = repositorioRoomie;
    }

    @Override
    public Integer generarPuntajeGamification(String mail){
        Integer cantida = repositorioRoomie.obtenerpuntajeGamification(mail);
       Roomie roomie = repositorioRoomie.ObtenerUnRoomie(mail);

        while (roomie.getActivo().equals(true) && roomie !=null) {
            if(roomie.getBilleteraDeDonaciones()>1){
                cantida++;
            }if(roomie.getCantidadDeDenuncias()>5){
                cantida--;
            }if(roomie.getCantidadTotalPuntuada()>2){
                cantida++;
            }
        }
            roomie.setPuntajeGamification(cantida);
            return  cantida;
    }
    @Override
    public String obtenerNivel(String mail) {
        String resultado = "RoomieBasico";
        return resultado;
        }


    @Override
    public void recalculoDePuntaje(){

    }
}
