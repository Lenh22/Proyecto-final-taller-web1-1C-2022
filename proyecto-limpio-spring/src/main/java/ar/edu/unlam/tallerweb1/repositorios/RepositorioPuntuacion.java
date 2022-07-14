package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("repositorioPuntuacion")
public class RepositorioPuntuacion implements IRepositorioPuntuaciones{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioPuntuacion(SessionFactory sessionFactory)
    {
        this.sessionFactory= sessionFactory;
    }

    @Override
    public List<Roomie> ObtenerRoomies() {
        //Forma Session por criteria
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Roomie.class).list();

    }

    @Override
    public Roomie ObtenerUnRoomie(Long id) {
        return (Roomie) sessionFactory.getCurrentSession()
                .createQuery("from Roomie where id =:id").setParameter("id", id).uniqueResult(); //uniqueResult retorna solo un valor
    }

    @Override
    public Roomie ObtenerUnRoomieMail(String email) {
        return (Roomie) sessionFactory.getCurrentSession()
                .createQuery("from Roomie where email =:email").setParameter("email", email).uniqueResult(); //uniqueResult retorna solo un valor
    }

    @Override
    public Roomie buscarUsuario(String email, String password) {
        final Session session = sessionFactory.getCurrentSession();
        return (Roomie) session.createCriteria(Roomie.class)
                .add(Restrictions.eq("email", email))
                .add(Restrictions.eq("password", password))
                .uniqueResult();
    }

    @Override
    public Roomie buscarRoomie(Long id, Boolean puntuacion) {
        final Session session = sessionFactory.getCurrentSession();
        return (Roomie) session.createCriteria(Roomie.class)
                .add(Restrictions.eq("id", id))
                .add(Restrictions.eq("puntuacion", puntuacion))
                .uniqueResult();
    }

    @Override
    public void AgregarRoomiePuntuado(Roomie roomie) {
        sessionFactory.getCurrentSession().save(roomie);
    }


    @Override
    public void AgregarRoomie(Roomie roomie) {
        sessionFactory.getCurrentSession().save(roomie);
    }
}

