package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Vivienda;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioVivienda")
public class RepositorioVivienda {

    private SessionFactory _sessionFactory;

    @Autowired
    public RepositorioVivienda(SessionFactory sessionFactoryNuevo){
        this._sessionFactory=sessionFactoryNuevo;
    }

    public Vivienda getViviendaID(Long id_vivienda){
        return (Vivienda) _sessionFactory.getCurrentSession()
                .createQuery("FROM Vivienda  WHERE id=:id")
                .setParameter("id",id_vivienda);
    }

    public List<Vivienda> getViviendas(){
        List<Vivienda> viviendasTotales;
        viviendasTotales = (List<Vivienda>) _sessionFactory.getCurrentSession()
                .createQuery("FROM Vivienda");//Fijarse el casteo
        return  viviendasTotales;
    }


    public List<Vivienda> getViviendasDisponibles() {
        List<Vivienda> viviendasDisponibles = null;
        List<Vivienda> viviendasTotales = (List<Vivienda>) _sessionFactory.getCurrentSession()
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
}
