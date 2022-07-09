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
        //Primero traemlos la lista de roomies de repositorio
        Roomie roomie = repositorioEmparejamiento.obtenerRoomiePorId(id);
        List<Roomie> roomiesAComparar = repositorioEmparejamiento.obtenerIdRoomies();

        //Agregar un metodo para realizar la comparacion
        for (Roomie roomieCompatible: roomiesAComparar) {
            if(calcularCompatibilidad(id,roomieCompatible.getId()) >= 60)
                roomiesCompatibles.add(roomieCompatible);
        }
        return roomiesCompatibles;
    }

    @Override
    public Integer calcularCompatibilidad(long idRoomie, long idAComparar) {
        int coincidencia = 0;

        if(idRoomie == idAComparar){
            return 0;
        }

        List<RoomieAtributos> atributosRoomielista = repositorioEmparejamiento.obtenerAtributosPorId(idRoomie);
        List<RoomieAtributos> atributosRoomieACompararlist = repositorioEmparejamiento.obtenerAtributosPorId(idAComparar);

        List<Atributo> atributosRoomie = new LinkedList<>();
        List<Atributo> atributosRoomieAComparar = new LinkedList<>();
        for (RoomieAtributos roomie: atributosRoomielista) {
            atributosRoomie.add(roomie.getAtributo());
        }

        for (RoomieAtributos roomie: atributosRoomieACompararlist) {
            atributosRoomieAComparar.add(roomie.getAtributo());
        }

        if(atributosRoomie.size() >= atributosRoomieAComparar.size()){
            for (Atributo atributo: atributosRoomie) {
                if(atributosRoomieAComparar.contains(atributo))
                    coincidencia++;
            }
            return coincidencia * 100/atributosRoomie.size();
        }
        else{
            for (Atributo atributo: atributosRoomieAComparar) {
                if(atributosRoomie.contains(atributo))
                    coincidencia++;
            }
            return coincidencia * 100/atributosRoomieAComparar.size();
        }
    }


}
