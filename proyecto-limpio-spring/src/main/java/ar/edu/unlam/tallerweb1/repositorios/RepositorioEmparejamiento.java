package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Atributo;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.RoomieAtributos;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioEmparejamiento;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        final Session session = sessionFactory.getCurrentSession();
        Roomie roomie = (Roomie) session
                .createQuery("from Roomie where id =:idAEncontrar").setParameter("idAEncontrar", idAEncontrar).uniqueResult();
        return roomie; //uniqueResult retorna solo un valor
    }

    @Override
    public void agregarRoomie(Roomie roomie) {
        sessionFactory.getCurrentSession().save(roomie);
    }

    @Override
    public void guardarAtributosRoomie(RoomieAtributos roomieAtributos) {
        sessionFactory.getCurrentSession().save(roomieAtributos);
    }

    @Override
    public List<Roomie> obtenerIdRoomies() {
        final Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("from Roomie").list();
    }

    @Override
    public List<Atributo> obtenerAtributosPorId(Long idRoomie) {
        final Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("select atributo from RoomieAtributos where idRoomie =:idRoomie")
                .setParameter("idRoomie",idRoomie).list();
    }

    @Override
    public List<Long> obtenerIdRoomiesParaComparar(long id) {
        final Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("select id from Roomie where id <>: idAEncontrar")
                .setParameter("idAEncontrar", id).list();
    }


}
