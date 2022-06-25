package ar.edu.unlam.tallerweb1.Puntuacion;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorPuntuaciones;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.DatosPuntuar;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPuntuacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPuntuacion;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class TesteoDePuntaAPunta extends SpringTest {


    private ControladorPuntuaciones controller;
    private ServicioPuntuacion service;
    private DatosPuntuar datos;
    private HttpServletRequest request;

    @Autowired
    RepositorioPuntuacion repositorioPuntuacion;

    @Before
    public void Init(){
        service = new ServicioPuntuacion(repositorioPuntuacion);
        controller = new ControladorPuntuaciones(service);
        datos = new DatosPuntuar();
    }

    @Test
    @Transactional
    @Rollback
    public  void testPuntuacion(){

        Roomie roomie = new Roomie();

        repositorioPuntuacion.AgregarRoomie(roomie);

        service.consultarRoomie(roomie.getId(), roomie.getPuntuacion());

        roomie.setEmail("roomie@roomie");
        roomie.setPassword("roomie");

        service.puntuacionRoomie(roomie, true);

        datos.setPuntuacion(true);
        datos.setId(1234L);

        ModelAndView mav = controller.MostrarPuntuacion(datos, request);

        assertThat(mav.getViewName()).isEqualTo("ver-puntuacion");

    }

}

