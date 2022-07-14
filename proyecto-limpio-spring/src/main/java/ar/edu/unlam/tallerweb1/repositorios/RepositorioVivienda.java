package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Propietario;
import ar.edu.unlam.tallerweb1.modelo.Vivienda;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioVivienda;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioVivienda implements IRepositorioVivienda {

    private SessionFactory sessionFactory;
    @Autowired
    public RepositorioVivienda(SessionFactory sessionFactory)
    {
        this.sessionFactory= sessionFactory;
    }

    @Override
    public Vivienda obtenerViviendaPorId(int idVivienda) {
        final Session session = sessionFactory.getCurrentSession();
        return (Vivienda) session.createQuery("from Vivienda where id =:idVivienda").setParameter("idVivienda", idVivienda).uniqueResult();
    }

    @Override
    public void guardarNuevaVivienda(Vivienda vivienda) {
        sessionFactory.getCurrentSession().save(vivienda);
    }

    @Override
    public List<Vivienda> obtenerListaViviendas() {
        final Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Vivienda").list();
    }

    @Override
    public List<Vivienda> obtenerListaViviendasPorIdPropietario(Propietario propietario) {
        final Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Vivienda where propietario =:propietario")
                .setParameter("propietario", propietario).list();
    }

    @Override
    public void eliminarVivienda(Vivienda vivienda) {
        sessionFactory.getCurrentSession().delete(vivienda);
    }

    @Override
    public void modificarVivienda(Vivienda vivienda) {
        sessionFactory.getCurrentSession().update(vivienda);
    }

    @Override
    public int obtenerPrecioPorId(long idVivienda) {
        final Session session = sessionFactory.getCurrentSession();
        return (int) session.createQuery("select precioAlquiler from Vivienda where id =:idVivienda")
                .setParameter("idVivienda", idVivienda).uniqueResult();

    }
}
