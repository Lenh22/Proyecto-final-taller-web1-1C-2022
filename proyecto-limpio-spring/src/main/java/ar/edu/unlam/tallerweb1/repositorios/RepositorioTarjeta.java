package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Tarjeta;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioTarjeta;
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
    public Tarjeta buscarTarjeta(int numeroTarjeta) {
        return (Tarjeta) sessionFactory.getCurrentSession()
                .createQuery("From Tarjeta Where numeroTarjeta=:numeroTarjeta")
                .setParameter("numeroTarjeta",numeroTarjeta);
    }
}
