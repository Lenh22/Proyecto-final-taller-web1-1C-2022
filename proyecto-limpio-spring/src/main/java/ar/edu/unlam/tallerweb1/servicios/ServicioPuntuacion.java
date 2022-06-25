package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Excepciones.UsuarioExistente;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.IRepositorioPuntuaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class ServicioPuntuacion implements IServicioPuntuaciones{

    private IRepositorioPuntuaciones repositorioUsuario;

    @Autowired
    public ServicioPuntuacion(IRepositorioPuntuaciones repositorioUsuario){
        this.repositorioUsuario = repositorioUsuario;
    }

    @Override
    public Double puntuacionRoomie(Roomie roomie, Boolean puntuacion) throws UsuarioExistente {
        Usuario buscado = repositorioUsuario.buscarUsuario(roomie.getEmail(), roomie.getPassword());
        if(buscado == null) {
            throw new UsuarioExistente();
        }
        if (buscado != null && puntuacion == true) {
            subirPuntaje(roomie);
            //roomie.setPuntaje(puntaje);
        }
        if(buscado != null && puntuacion == false && verPuntuacion(roomie)>0.0){
            bajarPuntaje(roomie);
            //roomie.setPuntaje(bajarPuntaje(roomie));
        }
        return verPuntuacion(roomie);
    }
    /*Este metodo me devuelve el porcentaje total de un roomie basandose en los votos positivos, lo divide con la cantidad
     * total y multiplica por 100*/
    @Override
    public Double verPuntaje(Roomie roomie) {
    /*    roomie = new Roomie();
        saveRoomie(roomie);
        roomie.setPuntuacion(true);
        roomie.setId(1L);
        roomie.setCantidadTotalPuntuada(1);
        consultarRoomie(roomie.getId(), roomie.getPuntuacion());
        subirPuntaje(roomie);*/
        Double resultado = 0.0;
        Double puntos = roomie.getPuntaje();
        Double cantidadTotalPuntuada = roomie.getCantidadTotalPuntuada();
        resultado = (puntos / cantidadTotalPuntuada) * 100;
        return resultado;
    }


    public Double verPuntuacion(Roomie roomie) {
    /*    roomie = new Roomie();
        saveRoomie(roomie);
        roomie.setPuntuacion(true);
        roomie.setId(1L);
        roomie.setCantidadTotalPuntuada(1);
        consultarRoomie(roomie.getId(), roomie.getPuntuacion());
        subirPuntaje(roomie);*/
        Double resultado = 0.0;
        Double puntos = roomie.getPuntaje();
        Double cantidadTotalPuntuada = roomie.getCantidadTotalPuntuada();
        resultado = (puntos / cantidadTotalPuntuada) * 100;
        return resultado;
    }

    @Override
    public double bajarPuntaje(Roomie roomie) {
        Double cantidadPuntuaciones = roomie.getCantidadTotalPuntuada();
        roomie.setCantidadTotalPuntuada(++cantidadPuntuaciones);
        Double cantidadPuntaje = roomie.getPuntaje();
        //roomie.setPuntaje(--cantidadPuntaje);
        return cantidadPuntaje;
    }

    @Override
    public Double subirPuntaje(Roomie roomie) {
    /*    roomie = new Roomie();
        saveRoomie(roomie);
        roomie.setPuntuacion(true);
        roomie.setId(1L);
        roomie.setCantidadTotalPuntuada(1);
        consultarRoomie(roomie.getId(), roomie.getPuntuacion());
        roomie.setPuntaje(1.0);*/
        Double cantidadPuntuaciones = roomie.getCantidadTotalPuntuada();
        Double cantidadPuntaje = roomie.getPuntaje();
        roomie.setCantidadTotalPuntuada(++cantidadPuntuaciones);
        roomie.setPuntaje(++cantidadPuntaje);
        return roomie.getPuntaje();
    }

    @Override
    public Roomie consultarRoomie(Long id, Boolean puntuacion) {
    /*    Roomie roomie = new Roomie();
        saveRoomie(roomie);
        roomie.setId(1L);
        roomie.setPuntuacion(true);
        id = roomie.getId();
        puntuacion = roomie.getPuntuacion();*/
        return repositorioUsuario.buscarRoomie(id, puntuacion);
    }

    @Override
    public void saveRoomie(Roomie roomie) {
        repositorioUsuario.AgregarRoomie(roomie);
    }

}

