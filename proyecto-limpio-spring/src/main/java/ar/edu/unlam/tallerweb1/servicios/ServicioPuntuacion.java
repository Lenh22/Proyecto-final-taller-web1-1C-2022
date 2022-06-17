package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.UsuarioExistente;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioPuntuaciones;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioPuntuaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioPuntuacion implements IServicioPuntuaciones {

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

        }else{
            if (puntuacion.booleanValue()) {
                Double puntaje = subirPuntaje(roomie);
                roomie.setPuntaje(puntaje);

            } else if(puntuacion.equals(false) && verPuntuacion(roomie)>0.0){
                roomie.setPuntaje(bajarPuntaje(roomie));
            }
        }
        return roomie.getPuntaje();
    }

    @Override
    public Double verPuntuacion(Roomie roomie) {
        Double resultado = 0.0;
        Double puntos = roomie.getPuntaje();
        Double cantidadTotalPuntuada = roomie.getCantidadTotalPuntuada();
        resultado = (puntos / cantidadTotalPuntuada) * 100;
        return resultado;
    }

    @Override
    public double bajarPuntaje(Roomie roomie) {
        Double cantidadPuntuaciones = roomie.getCantidadTotalPuntuada();
        roomie.setCantidadTotalPuntuada(cantidadPuntuaciones++);
        return roomie.getPuntaje();
    }

    @Override
    public Double subirPuntaje(Roomie roomie) {
        Double cantidadPuntuaciones = roomie.getCantidadTotalPuntuada();
        Double cantidadPuntaje = roomie.getPuntaje();
        roomie.setCantidadTotalPuntuada(cantidadPuntuaciones++);
        cantidadPuntaje++;
        return cantidadPuntaje++;

    }


}

