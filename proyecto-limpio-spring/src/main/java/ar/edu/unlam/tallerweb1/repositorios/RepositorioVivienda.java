package ar.edu.unlam.tallerweb1.repositorios;

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
    public RepositorioVivienda(SessionFactory sessionFactoryNuevo){
        this.sessionFactory =sessionFactoryNuevo;
    }
    @Override
    public Vivienda getViviendaID(int id_vivienda){
        return (Vivienda) sessionFactory.getCurrentSession()
                .createQuery("FROM Vivienda  WHERE id=:id")
                .setParameter("id",id_vivienda);
    }
@Override
    public List<Vivienda> getViviendas(){
         final Session session = sessionFactory.getCurrentSession();
        List<Vivienda> todasViviendas = session.createQuery("From Vivienda").list();
        return todasViviendas;

    }

@Override
    public List<Vivienda> getViviendasDisponibles() {
    List<Vivienda> viviendasDisponibles = null;
    List<Vivienda> viviendasTotales = (List<Vivienda>) sessionFactory.getCurrentSession()
                .createQuery("FROM Vivienda");//Fijarse el casteo
        for (Vivienda vivienda:viviendasTotales) {
            //Como saber cuanta gente hay en la vivienda???? Hacer un atributo nuevo a vivienda?
         /*   Integer conAlguien = vivienda.getCantidadMaximaRoomies()+1;
            if (conAlguien<vivienda.getCantidadMaximaRoomies()){
                viviendasDisponibles.add(vivienda);
            }*/
        }

        return  viviendasDisponibles;
    }
@Override
    public Vivienda buscarViviendaId(int id){
        Vivienda viviendaEncontrada= (Vivienda) sessionFactory.getCurrentSession()
                .createQuery("From Vivienda where vivienda=:id")
                .setParameter("id",id);
        return viviendaEncontrada;
    }
@Override
    public void crearVivienda(Vivienda datoVivienda) {

        sessionFactory.getCurrentSession().save(datoVivienda);
    }
    @Override
    public void eliminarVivienda(Vivienda datoVivineda)
    {
        sessionFactory.getCurrentSession().delete(datoVivineda);
    }
    @Override
    public void editarVivienda(Vivienda datoVivineda)
    {
        sessionFactory.getCurrentSession().delete(datoVivineda);
    }
}
