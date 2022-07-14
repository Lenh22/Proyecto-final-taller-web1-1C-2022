package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Tarjeta;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioTarjeta;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioTarjeta implements IRepositorioTarjeta {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioTarjeta(SessionFactory sessionFactoryNuevo)
    {
        this.sessionFactory=sessionFactoryNuevo;
    }


    @Override
    public Tarjeta buscarTarjeta(Long numeroTarjeta) {
        final Session session = sessionFactory.getCurrentSession();
        return (Tarjeta) session
                .createQuery("From Tarjeta Where numeroTarjeta=:numeroTarjeta")
                .setParameter("numeroTarjeta",numeroTarjeta).uniqueResult();
    }

    @Override
    public Tarjeta obtenerTarjetaRoomie(long id) {
        final Session session = sessionFactory.getCurrentSession();
        return (Tarjeta) session
                .createQuery("From Tarjeta Where idRoomie=:id")
                .setParameter("id",id).uniqueResult();
    }

}