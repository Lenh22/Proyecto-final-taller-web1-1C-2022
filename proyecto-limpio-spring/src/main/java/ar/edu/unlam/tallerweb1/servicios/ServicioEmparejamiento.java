package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Atributo;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioEmparejamiento;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioEmparejamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
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
        List<Roomie> roomiesAComparar = repositorioEmparejamiento.obtenerRoomies();

        //Agregar un metodo para realizar la comparacion
        for (Roomie roomieCompatible: roomiesAComparar) {
            if(calcularCompatibilidad(roomie.getAtributos(),roomieCompatible.getAtributos()) >= 70)
                roomiesCompatibles.add(roomieCompatible);
        }
        return roomiesCompatibles;
    }

    public Integer calcularCompatibilidad(List<Atributo> atributos, List<Atributo> atributosAComparar) {
        //implementar hash
        int coincidencia = 0;
        for (Atributo atributo: Atributo.values()) {
            if(atributos.contains(atributo))
                if (atributosAComparar.contains(atributo))
                    coincidencia++;
        }
        int cantACalcular = (atributos.size() >= atributosAComparar.size()) ? atributos.size() : atributosAComparar.size();
        int result = (coincidencia * 100)/cantACalcular;
        return result;
    }


}
