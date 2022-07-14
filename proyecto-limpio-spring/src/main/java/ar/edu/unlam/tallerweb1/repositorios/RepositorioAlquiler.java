package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioAlquiler;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("repositorioAlquiler")
public class RepositorioAlquiler implements IRepositorioAlquiler {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioAlquiler(SessionFactory sessionFactory)
    {
        this.sessionFactory= sessionFactory;
    }
}
