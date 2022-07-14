package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioDescuento;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioDescuento implements IRepositorioDescuento {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioDescuento(SessionFactory sessionFactory)
    {
        this.sessionFactory= sessionFactory;
    }

    @Override
    public Roomie buscarRoomiePorMailyPass(String email, String password) {
        final Session session = sessionFactory.getCurrentSession();
        return (Roomie) session.createCriteria(Roomie.class)
                .add(Restrictions.eq("email", email))
                .add(Restrictions.eq("password", password))
                .uniqueResult();
    }

    @Override
    public List<Roomie> ObtenerRoomiesConDescuento() {
        //Forma Session por criteria
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Roomie.class).list();

    }

    @Override
    public void AgregarRoomieConDescuento(Roomie roomie) {
        sessionFactory.getCurrentSession().save(roomie);
    }


}
