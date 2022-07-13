package ar.edu.unlam.tallerweb1.Puntuacion.Controlador;

import ar.edu.unlam.tallerweb1.controladores.ControladorPuntuaciones;
import ar.edu.unlam.tallerweb1.modelo.Excepciones.UsuarioExistente;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.DatosPuntuar;
import ar.edu.unlam.tallerweb1.servicios.ServicioPuntuacion;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorTest {

    public ControladorPuntuaciones controladorPuntuaciones;
    public ServicioPuntuacion servicioDePuntuacion;
    private String mail = "maria@maria.com";
    private String pass = "12345";
    public Usuario roomie2;
    public Boolean puntuacion = false;
    public Double puntaje;
    private Long id = 1L;
    public static final String VISTA_PUNTUACION = "ver-puntuacion";
    public static final String MENSAJE_TIPO_INVALIDO = "El usuario buscado no existe";
    private DatosPuntuar datos;

    @Before
    public void init(){
        servicioDePuntuacion = mock(ServicioPuntuacion.class);
        controladorPuntuaciones = new ControladorPuntuaciones(servicioDePuntuacion);
        roomie2 = new Roomie("Maria", "Gonzalez", 20, mail, pass, "", true);
        datos = new DatosPuntuar();
    }

    @Test
    public void queAlPedirPuntuacionDeRoomiesDevuelvaPuntaje(){
        //prepracion
        dadoQueExisteRoomiePuntuado (id, puntuacion);

        //ejecución
        datos.setPuntuacion(puntuacion);
        datos.setId(id);

        ModelAndView mav = mostrarPuntuacion(datos);

        //verificacion
        entoncesEncuentro();
        entoncesMeLLevaALaVista(VISTA_PUNTUACION,mav.getViewName());

    }

    @Test (expected = UsuarioExistente.class)
    public void alPedirPuntuacionInvalidaLleveAPantallaDeError(){

        dadoQueNoExisteUnRoomiePuntuado();

        ModelAndView mav = NomostrarPuntuacion(datos);

        entoncesMeLLevaALaVista(VISTA_PUNTUACION,mav.getViewName());
        entoncesSeRecibeMensaje(MENSAJE_TIPO_INVALIDO, mav.getModel());
    }

    private void dadoQueNoExisteUnRoomiePuntuado() {
        when(servicioDePuntuacion.puntuacionRoomie(roomie2.getId(), puntuacion)).thenReturn(null);
    }

    private void entoncesSeRecibeMensaje(String mensaje, Map<String, Object> model) {
        assertThat(model.get("error")).isEqualTo(mensaje);
    }

    private void entoncesEncuentro() {
        puntaje = servicioDePuntuacion.puntuacionRoomie(roomie2.getId(), puntuacion);
        assertThat(puntaje).isEqualTo(0.0);
    }

    private ModelAndView mostrarPuntuacion(DatosPuntuar datos) {
        return controladorPuntuaciones.MostrarPuntuacion(datos);
    }

    private ModelAndView NomostrarPuntuacion(DatosPuntuar datos) throws UsuarioExistente{
        controladorPuntuaciones.MostrarPuntuacion(datos);
        throw new UsuarioExistente();
    }

    private void dadoQueExisteRoomiePuntuado(long id, Boolean puntuacion) {
        puntaje = servicioDePuntuacion.puntuacionRoomie(id, puntuacion);
        when(servicioDePuntuacion.puntuacionRoomie(id, puntuacion)).thenReturn(puntaje);
    }

    private void entoncesMeLLevaALaVista(String vistaEsperada, String vistasRecibida) {
        assertThat(vistaEsperada).isEqualTo(vistasRecibida);

    }
}
