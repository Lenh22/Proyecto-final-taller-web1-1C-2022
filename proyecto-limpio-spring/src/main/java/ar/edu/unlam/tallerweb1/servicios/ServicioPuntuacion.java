package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Excepciones.UsuarioExistente;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
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
    public Double puntuacionRoomie(Long id, Boolean puntuacion) throws UsuarioExistente {
        Roomie buscado = repositorioUsuario.ObtenerUnRoomie(id);

        if(buscado == null) {
            throw new UsuarioExistente();
        }
        if (buscado != null && puntuacion == true) {
            subirPuntaje(buscado);
        }
        if(buscado != null && puntuacion == false && verPuntaje(buscado)>=0.0){
            bajarPuntaje(buscado);
        }
        if(buscado != null && puntuacion == false && buscado.getPuntaje()==0.0){
            Double cantidadPuntuaciones = buscado.getCantidadTotalPuntuada();
            buscado.setCantidadTotalPuntuada(++cantidadPuntuaciones);
        }
        return verPuntaje(buscado);
    }

    @Override
    public Double puntuacionRoomieMail(String email, Boolean puntuacion) throws UsuarioExistente {
        Roomie buscado = repositorioUsuario.ObtenerUnRoomieMail(email);

        if(buscado == null) {
            throw new UsuarioExistente();
        }
        if (buscado != null && puntuacion == true) {
            subirPuntaje(buscado);
        }
        if(buscado != null && puntuacion == false && verPuntaje(buscado)>=0.0){
            bajarPuntaje(buscado);
        }
        if(buscado != null && puntuacion == false && buscado.getPuntaje()==0.0){
            Double cantidadPuntuaciones = buscado.getCantidadTotalPuntuada();
            buscado.setCantidadTotalPuntuada(++cantidadPuntuaciones);
        }
        return verPuntaje(buscado);
    }

    /*Este metodo me devuelve el porcentaje total de un roomie basandose en los votos positivos, lo divide con la cantidad
     * total y multiplica por 100*/
    @Override
    public Double verPuntaje(Roomie roomie) {

        Double resultado;
        Double puntos = roomie.getPuntaje();
        Double cantidadTotalPuntuada = roomie.getCantidadTotalPuntuada();
        if(cantidadTotalPuntuada > 0.0){
            resultado = (puntos / cantidadTotalPuntuada) * 100;
        }else{
            resultado = 0.0;
        }
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

        Double cantidadPuntuaciones = roomie.getCantidadTotalPuntuada();
        Double cantidadPuntaje = roomie.getPuntaje();
        roomie.setCantidadTotalPuntuada(++cantidadPuntuaciones);
        roomie.setPuntaje(++cantidadPuntaje);
        return roomie.getPuntaje();
    }

    @Override
    public Roomie consultarRoomie(Long id) {
        return repositorioUsuario.ObtenerUnRoomie(id);
    }

    @Override
    public Roomie consultarRoomiePorMail(String mail) {
        return repositorioUsuario.ObtenerUnRoomieMail(mail);
    }

    @Override
    public void saveRoomie(Roomie roomie) {
        repositorioUsuario.AgregarRoomie(roomie);
    }

}

