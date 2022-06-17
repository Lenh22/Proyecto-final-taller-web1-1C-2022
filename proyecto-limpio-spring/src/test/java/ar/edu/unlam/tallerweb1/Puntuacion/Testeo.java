package ar.edu.unlam.tallerweb1.Puntuacion;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorPuntuaciones;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioPuntuaciones;
import ar.edu.unlam.tallerweb1.servicios.ServicioPuntuacion;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class Testeo extends SpringTest {


    private ControladorPuntuaciones controller;
    private ServicioPuntuacion service;

    @Autowired
    IRepositorioPuntuaciones repositorioPuntuacion;

    @Before
    public void Init(){
        service = new ServicioPuntuacion(repositorioPuntuacion);
        controller = new ControladorPuntuaciones(service);
    }
    @Test
    @Transactional
    @Rollback
    public  void testPuntuacion(){

        Roomie roomie = new Roomie();
        roomie.setEmail("algo@algo");
        roomie.setPassword("algo");

        repositorioPuntuacion.agregarRoomie(roomie);

        service.puntuacionRoomie(roomie, true);

        ModelAndView mav = controller.mostrarPuntuacion(roomie, true);

        assertThat(mav.getViewName()).isEqualTo("ver-puntuacion");

    }

}

