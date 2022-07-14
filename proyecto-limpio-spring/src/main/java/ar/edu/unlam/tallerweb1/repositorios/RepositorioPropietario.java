package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Propietario;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioPropietario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPropietario implements IRepositorioPropietario {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioPropietario(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Propietario obtenerPorId(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        return  (Propietario) session
                .createQuery("from Propietario where id =:idAEncontrar").setParameter("idAEncontrar", id).uniqueResult();
    }
}
