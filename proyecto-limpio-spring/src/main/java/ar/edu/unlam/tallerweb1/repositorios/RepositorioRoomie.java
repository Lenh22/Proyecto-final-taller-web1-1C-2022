package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("repositorioRoomie")
public class RepositorioRoomie implements IRepositorioRoomie{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioRoomie(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override @Transactional
    public Roomie buscar(String roomie) {
        return null;
    }

    @Override
    public List<Roomie> obtenerRoomies() {
        return null;
    }
}
