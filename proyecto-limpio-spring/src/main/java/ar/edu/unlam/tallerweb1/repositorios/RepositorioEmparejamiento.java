package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioEmparejamiento")
public class RepositorioEmparejamiento implements  IRepositorioEmparejamiento{

    @Override
    public List<Roomie> ObtenerRoomies() {
        return null;
    }

    @Override
    public Roomie ObtenerRoomiePorId(Long id) {
        return null;
    }
}
