package ar.edu.unlam.tallerweb1.Puntuacion.Controlador;

import ar.edu.unlam.tallerweb1.controladores.ControladorPuntuaciones;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.DatosPuntuar;
import ar.edu.unlam.tallerweb1.servicios.IServicioPuntuaciones;
import ar.edu.unlam.tallerweb1.servicios.ServicioPuntuacion;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorTest {

    public ControladorPuntuaciones controladorPuntuaciones;
    public ServicioPuntuacion servicioDePuntuacion;
    private String mail = "maria@maria.com";
    private String pass = "12345";
    public Usuario roomie2 = new Roomie("Maria", "Gonzalez", 20, mail, pass, "", true);
    public Boolean puntuacion = false;
    public Double puntaje;
    public static final String VISTA_PUNTUACION = "ver-puntuacion";
    public static final String MENSAJE_TIPO_INVALIDO = "El usuario buscado no existe";
    private DatosPuntuar datos = new DatosPuntuar();
    private HttpServletRequest request = null;

    @Before
    public void init(){
        servicioDePuntuacion = mock(ServicioPuntuacion.class);
        controladorPuntuaciones = new ControladorPuntuaciones(servicioDePuntuacion);
    }
    @Test
    public void queAlPedirPuntuacionDeRoomiesDevuelvaPuntaje(){
        //prepracion
        dadoQueExisteRoomiePuntuado ((Roomie) roomie2, puntuacion);

        //ejecución
        datos.setPuntuacion(puntuacion);
        datos.setId(roomie2.getId());

        //request.getSession().setAttribute("puntaje", ((Roomie) roomie2).getPuntaje());
        ModelAndView mav = mostrarPuntuacion(datos, request);

        //verificacion

        entoncesEncuentro();
        entoncesMeLLevaALaVista(VISTA_PUNTUACION,mav.getViewName());

    }

    @Test
    public void alPedirPuntuacionInvalidaLleveAPantallaDeError(){

        dadoQueNoExisteUnRoomiePuntuado();

        ModelAndView mav = mostrarPuntuacion(datos, request);

        entoncesMeLLevaALaVista("ver-puntuacion",mav.getViewName());
        entoncesSeRecibeMensaje(MENSAJE_TIPO_INVALIDO, mav.getModel());
    }

    private void dadoQueNoExisteUnRoomiePuntuado() {
        when(servicioDePuntuacion.puntuacionRoomie((Roomie) roomie2, puntuacion)).thenThrow(new RuntimeException());
    }

    private void entoncesSeRecibeMensaje(String mensaje, Map<String, Object> model) {
        assertThat(model.get("msg-error")).isEqualTo(mensaje);
    }

    private void entoncesEncuentro() {
        puntaje = servicioDePuntuacion.puntuacionRoomie((Roomie) roomie2, puntuacion);
        assertThat(puntaje).isEqualTo(0.0);
    }

    private ModelAndView mostrarPuntuacion(DatosPuntuar datos, HttpServletRequest request) {
        return controladorPuntuaciones.MostrarPuntuacion(datos, request);
    }

    private void dadoQueExisteRoomiePuntuado(Roomie roomie, Boolean puntuacion) {

        puntaje = servicioDePuntuacion.puntuacionRoomie(roomie, puntuacion);
//doThrow (Excepcion.class).when(servicioDePuntuacion).puntuacionRoomie();
        when(servicioDePuntuacion.puntuacionRoomie(roomie, puntuacion)).thenReturn(puntaje);
    }

    private void entoncesMeLLevaALaVista(String vistaEsperada, String vistasRecibida) {
        assertThat(vistaEsperada).isEqualTo(vistasRecibida);

    }
}
