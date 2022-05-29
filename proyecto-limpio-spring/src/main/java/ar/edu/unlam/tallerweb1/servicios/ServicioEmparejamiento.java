package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Atributo;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.repositorios.IRepositorioEmparejamiento;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioEmparejamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class ServicioEmparejamiento implements IServicioEmparejamiento{

    IRepositorioEmparejamiento repositorioEmparejamiento;
    private List<Roomie> roomiesCompatibles = new LinkedList<>();

    @Autowired
    public ServicioEmparejamiento(IRepositorioEmparejamiento repositorioEmparejamiento){
        this.repositorioEmparejamiento = repositorioEmparejamiento;
    }

    @Override
    public List<Roomie> ObtenerRoomiesCompatibles(Long id) {
        //Primero traemlos la lista de roomies de repositorio
        Roomie roomie = repositorioEmparejamiento.ObtenerRoomiePorId(id);
        List<Roomie> roomiesAComparar = repositorioEmparejamiento.ObtenerRoomies();

        //Agregar un metodo para realizar la comparacion
        for (Roomie roomieCompatible: roomiesAComparar) {
            //if(CalcularCompatibilidad(roomie.getAtributos(),roomieCompatible.getAtributos()) >= 70)
                roomiesCompatibles.add(roomieCompatible);
        }
        return roomiesCompatibles;
    }

    public Integer CalcularCompatibilidad(TreeSet<Atributo> atributos, TreeSet<Atributo> atributosAComparar) {
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
