package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioEmparejamiento;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioEmparejamiento")
public class RepositorioEmparejamiento implements IRepositorioEmparejamiento {

    private SessionFactory sessionFactory;
    @Autowired
    public RepositorioEmparejamiento(SessionFactory sessionFactory)
    {
        this.sessionFactory= sessionFactory;
    }

    @Override
    public List<Roomie> obtenerRoomies() {
        //Forma Session por criteria
       final Session session = sessionFactory.getCurrentSession();
       return session.createCriteria(Roomie.class).list();

    }

    @Override
    public Roomie obtenerRoomiePorId(Long idAEncontrar) {

        return (Roomie) sessionFactory.getCurrentSession()
                .createQuery("from Roomie where id =:id").setParameter("id", idAEncontrar).uniqueResult(); //uniqueResult retorna solo un valor
    }

    @Override
    public void agregarRoomie(Roomie roomie) {
        sessionFactory.getCurrentSession().save(roomie);
    }

}
