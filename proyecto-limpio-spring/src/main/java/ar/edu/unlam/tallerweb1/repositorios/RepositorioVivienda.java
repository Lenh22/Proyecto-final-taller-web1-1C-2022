package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.Vivienda;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioVivienda;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
