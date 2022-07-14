package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Atributo;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.RoomieAtributos;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioEmparejamiento;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioEmparejamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class ServicioEmparejamiento implements IServicioEmparejamiento {

    IRepositorioEmparejamiento repositorioEmparejamiento;
    private List<Roomie> roomiesCompatibles = new LinkedList<>();

    @Autowired
    public ServicioEmparejamiento(IRepositorioEmparejamiento repositorioEmparejamiento){
        this.repositorioEmparejamiento = repositorioEmparejamiento;
    }

    @Override
    public List<Roomie> obtenerRoomiesCompatibles(Long id) {
        Roomie roomie = repositorioEmparejamiento.obtenerRoomiePorId(id);
        List<Long> roomiesAComparar = repositorioEmparejamiento.obtenerIdRoomiesParaComparar(1L);

        roomiesCompatibles = calcularCompatibilidad(id, roomiesAComparar);

        return roomiesCompatibles;
    }

    @Override
    public List<Roomie> calcularCompatibilidad(long idRoomie, List<Long> idsAComparar) {
        int coincidencia = 0;

        List<Atributo> atributosRoomieLogueado = repositorioEmparejamiento.obtenerAtributosPorId(idRoomie);
        List<Atributo> atributosRoomieAComparar = new LinkedList<>();

        for (Long id: idsAComparar) {
            if(idRoomie == id)
                continue;
            atributosRoomieAComparar = repositorioEmparejamiento.obtenerAtributosPorId(id);

            if(atributosRoomieLogueado.size() >= atributosRoomieAComparar.size()){
                for (Atributo atributo: atributosRoomieLogueado) {
                    if(atributosRoomieAComparar.contains(atributo))
                        coincidencia++;
                }
                 if(coincidencia * 100/atributosRoomieLogueado.size() >= 70)
                     roomiesCompatibles.add(repositorioEmparejamiento.obtenerRoomiePorId(id));
                 coincidencia = 0;
            }
            else{
                for (Atributo atributo: atributosRoomieAComparar) {
                    if(atributosRoomieLogueado.contains(atributo))
                        coincidencia++;
                }
                if(coincidencia * 100/atributosRoomieAComparar.size() >= 70)
                    roomiesCompatibles.add(repositorioEmparejamiento.obtenerRoomiePorId(id));
                coincidencia = 0;
            }
        }
         return roomiesCompatibles;
    }


}
