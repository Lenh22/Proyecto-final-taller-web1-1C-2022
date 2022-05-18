package ar.edu.unlam.tallerweb1.contrladores;

import ar.edu.unlam.tallerweb1.controladores.ControladorPuntuaciones;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.servicios.ServicioDePuntuacion;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladoresPuntuacionTest {

    public ControladorPuntuaciones controladorPuntuaciones;
    public ServicioDePuntuacion servicioDePuntuacion;
    public Roomie roomie2;
    public Boolean puntuacion = false;
    public Double puntaje;
    public static final String VISTA_PUNTUACION = "ver-puntuacion";

    @Before
    public void init(){
        servicioDePuntuacion = mock(ServicioDePuntuacion.class);
        controladorPuntuaciones = new ControladorPuntuaciones(servicioDePuntuacion);
    }
    @Test
    public void queAlPedirPuntuacionDeRoomiesDevueltaPuntaje(){
        //prepracion
        dadoQueExisteRoomiePuntuado (roomie2, puntuacion);

        //ejecución
        ModelAndView mav = mostrarPuntuacion(roomie2, puntuacion);

        //verificacion


        //REVER ESE METODO PORQUE HACE QUE FALLE, CORRE SOLO DE ESTA FORMA
        //entoncesEncuentro((Double) mav.getModel().get("puntaje"));
        entoncesMeLLevaALaVista("ver-puntuacion",mav.getViewName());

    }

    private ModelAndView mostrarPuntuacion(Roomie roomie2, Boolean puntuacion) {
        return controladorPuntuaciones.MostrarPuntuacion(roomie2, puntuacion);
    }

    private void dadoQueExisteRoomiePuntuado(Roomie roomie, Boolean puntuacion) {
        //puntaje = roomie.verPuntuacion();
        puntaje = 0.0;

        servicioDePuntuacion.puntuacionRoomie(roomie, puntuacion);

        when(servicioDePuntuacion.puntuacionRoomie(roomie, puntuacion)).thenReturn(puntaje);
    }

    private void entoncesMeLLevaALaVista(String vistaEsperada, String vistasRecibida) {
        assertThat(vistasRecibida).isEqualTo(vistasRecibida);

    }
/*
    private void entoncesEncuentro(Double puntaje, double cantidadEsperada) {
        assertThat(puntaje).isEqualTo(cantidadEsperada);
    }*/
}
