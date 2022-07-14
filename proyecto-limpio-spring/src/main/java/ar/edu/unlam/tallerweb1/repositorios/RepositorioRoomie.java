package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioRoomie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("repositorioRoomie")
public class RepositorioRoomie implements IRepositorioRoomie {

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
        final Session session = sessionFactory.getCurrentSession();

        List l1= session.createQuery("from Roomie where recibirDonacion=:recibirDonacion").setParameter("recibirDonacion", true).list();


        return l1;

    }

    @Override
    public Roomie ObtenerUnRoomie(String emailAEncontrar) {
        //
        return (Roomie) sessionFactory.getCurrentSession()
                .createQuery("from Roomie where email =:email").setParameter("email", emailAEncontrar).uniqueResult();
    }

    @Override
    public List<Roomie> ObtenerUnRoomiDonatario(Boolean recibe){
        final Session session = sessionFactory.getCurrentSession();
        List donatarios = session.createQuery("from Roomie where recibirDonacion =: recibe ").setParameter("recibe",
                recibe).list();

        return donatarios;
    }
    @Override
    public void actualizar(Roomie roomie1) {
        sessionFactory.getCurrentSession().update(roomie1);
    }

    @Override
    public Boolean obtenerEstadoDelUsuario(String email) {
        return null;
    }

    //Agregue esto
    //puedo castear a salida
    @Override
    public Integer obtenerpuntajeGamification(String mail) {
        final Session session = sessionFactory.getCurrentSession();
        return (int) session.createQuery("select puntajeGamification from Roomie where email = :email")
                .setParameter("email", mail)
                .uniqueResult();
    }

    @Override
    public void agregarRoomie(Roomie roomie) {
        sessionFactory.getCurrentSession().save(roomie);
    }
}
