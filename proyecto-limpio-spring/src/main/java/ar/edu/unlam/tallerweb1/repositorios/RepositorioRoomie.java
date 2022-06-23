package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository("repositorioRoomie")
public class RepositorioRoomie implements IRepositorioRoomie{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioRoomie(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override
    public Roomie buscar(String roomie) {
        return null;
    }

    @Override
    public List<Roomie> obtenerRoomies() {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Roomie.class).list();
    }

    @Override
    public void agregarRoomie(Roomie roomie) {
        sessionFactory.getCurrentSession().save(roomie);

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


}

