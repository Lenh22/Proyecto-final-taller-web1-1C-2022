package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vivienda;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioBuscador implements  IRepositorioBuscador{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioBuscador(SessionFactory sessionFactory)
    {
        this.sessionFactory= sessionFactory;
    }

    @Override
    public void AgregarRoomie(Roomie roomie) {
        sessionFactory.getCurrentSession().save(roomie);
    }
    @Override
    public Roomie ObtenerUnRoomie(String nombreAEncontrar) {
        return (Roomie) sessionFactory.getCurrentSession()
                .createQuery("from Roomie where nombre =:nombre").setParameter("nombre", nombreAEncontrar).uniqueResult(); //uniqueResult retorna solo un valor
    }
    @Override
    public List<Usuario> ObtenerRoomies() {
        final Session session = sessionFactory.getCurrentSession();
        //return session.createCriteria(Vivienda.class).list();
        List<Usuario> roomies = session.createQuery("From Usuario ").list();
        return roomies;

    }
    @Override
    public Roomie buscarRoomie(String nombre) {
        final Session session = sessionFactory.getCurrentSession();
        return (Roomie) session.createCriteria(Roomie.class)
                .add(Restrictions.eq("nombre", nombre))
                .uniqueResult();
    }
    @Override
    public List<Usuario> ObtenerRoomiesPorFiltro(Integer id) {
        final Session session = sessionFactory.getCurrentSession();
        //return session.createCriteria(Vivienda.class).list();
        List<Usuario> roomies = session.createQuery("From Usuario where id= :id")
                .setParameter("id",id)
                .list();
        return roomies;
    }


    @Override
    public void AgregarAlquiler(Vivienda vivienda) {
        sessionFactory.getCurrentSession().save(vivienda);
    }

    @Override
    public List<Vivienda> ObtenerAlquileres() {
        final Session session = sessionFactory.getCurrentSession();
        //return session.createCriteria(Vivienda.class).list();
        List<Vivienda> viviendas = session.createQuery("From Vivienda").list();
        return viviendas;
    }
    @Override
    public Vivienda buscarAlquiler(String direccion) {
       /* final Session session = sessionFactory.getCurrentSession();
        return (Vivienda) session.createCriteria(Vivienda.class)
                .add(Restrictions.eq("direccion", direccion))
                .uniqueResult();*/
        return (Vivienda) sessionFactory.getCurrentSession()
                .createQuery("FROM Vivienda  WHERE direccion=:direccion")
                .setParameter("direccion",direccion)
                .uniqueResult();
    }

    @Override
    public List<Vivienda> ObtenerAlquileresPorFiltro(Integer vivienda) {
        final Session session = sessionFactory.getCurrentSession();
        //return session.createCriteria(Vivienda.class).list();
        List<Vivienda> viviendas = session.createQuery("From Vivienda where vivienda= :vivienda")
                .setParameter("vivienda",vivienda)
                .list();
        return viviendas;
    }
}
