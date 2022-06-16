package ar.edu.unlam.tallerweb1.persistencia.Puntuacion.Controlador;

import ar.edu.unlam.tallerweb1.controladores.ControladorPuntuaciones;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.IServicioPuntuaciones;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorTest {

    public ControladorPuntuaciones controladorPuntuaciones;
    public IServicioPuntuaciones servicioDePuntuacion;
    private String mail = "maria@maria.com";
    private String pass = "12345";
    public Usuario roomie2 = new Roomie("Maria", "Gonzalez", 20, mail, pass, "", true);
    public Boolean puntuacion = false;
    public Double puntaje;
    public static final String VISTA_PUNTUACION = "ver-puntuacion";
    public static final String MENSAJE_TIPO_INVALIDO = "no se puede mostrar puntuacion";

    @Before
    public void init(){
        servicioDePuntuacion = mock(IServicioPuntuaciones.class);
        controladorPuntuaciones = new ControladorPuntuaciones(servicioDePuntuacion);
    }
    @Test
    public void queAlPedirPuntuacionDeRoomiesDevuelvaPuntaje(){
        //prepracion
        dadoQueExisteRoomiePuntuado ((Roomie) roomie2, puntuacion);

        //ejecución
        ModelAndView mav = mostrarPuntuacion((Roomie) roomie2, puntuacion);

        //verificacion

        entoncesEncuentro((Double) mav.getModel().get("puntaje"), 0.0);
        entoncesMeLLevaALaVista(VISTA_PUNTUACION,mav.getViewName());

    }

    @Test
    public void alPedirPuntuacionInvalidaLleveAPantallaDeError(){
        when(servicioDePuntuacion.puntuacionRoomie((Roomie) roomie2, puntuacion)).thenThrow(new RuntimeException());

        ModelAndView mav = mostrarPuntuacion((Roomie) roomie2, puntuacion);

        entoncesMeLLevaALaVista("ver-puntuacion",mav.getViewName());
        entoncesSeRecibeMensaje(MENSAJE_TIPO_INVALIDO, mav.getModel());
    }

    private void entoncesSeRecibeMensaje(String mensaje, Map<String, Object> model) {
        assertThat(model.get("msg-error")).isEqualTo(mensaje);
    }

    private void entoncesEncuentro(Double puntaje, double cantidadEsperada) {
        puntaje = servicioDePuntuacion.puntuacionRoomie((Roomie) roomie2, puntuacion);
        assertThat(puntaje).isEqualTo(cantidadEsperada);
    }

    private ModelAndView mostrarPuntuacion(Roomie roomie2, Boolean puntuacion) {
        return controladorPuntuaciones.MostrarPuntuacion(roomie2, puntuacion);
    }

    private void dadoQueExisteRoomiePuntuado(Roomie roomie, Boolean puntuacion) {

        puntaje = servicioDePuntuacion.puntuacionRoomie(roomie, puntuacion);
//doThrow (Excepcion.class).when(servicioDePuntuacion).puntuacionRoomie();
        when(servicioDePuntuacion.puntuacionRoomie(roomie, puntuacion)).thenReturn(puntaje);
    }

    private void entoncesMeLLevaALaVista(String vistaEsperada, String vistasRecibida) {
        assertThat(vistasRecibida).isEqualTo(vistasRecibida);

    }
}
