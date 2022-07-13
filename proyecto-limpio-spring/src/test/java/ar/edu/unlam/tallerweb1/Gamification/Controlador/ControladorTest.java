package ar.edu.unlam.tallerweb1.Gamification.Controlador;


import ar.edu.unlam.tallerweb1.controladores.ControladorGamifiction;
import ar.edu.unlam.tallerweb1.controladores.DatosGamification;
import ar.edu.unlam.tallerweb1.controladores.DatosLogin;
import ar.edu.unlam.tallerweb1.servicios.IServicioDeGamification;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorTest {

    private IServicioDeGamification servicioDeGamification;
    private ControladorGamifiction controladorGamifiction;

    private DatosLogin datosLogin = new DatosLogin();
    private DatosGamification datos = new DatosGamification("pepe@mail", 1);
    private DatosGamification datos2 = new DatosGamification("pepe@mail", 4);
    private DatosGamification datos3 = new DatosGamification("pepe@mail", 6);

    @Before
    public void init(){
        servicioDeGamification = mock(IServicioDeGamification.class);
        controladorGamifiction = new ControladorGamifiction(servicioDeGamification);
    }

    @Test
    public void queElControladorMeInformeQueEstoyEnElNivel1(){
        dadoQueExisteUnRoomieLogueadoCon1punto(datos.getEmail());
        entoncesTengoElnivel(datos.getEmail());
        ModelAndView mav = entoncesQueMeDevuelvaUnaVistaConUnNivel(datos.getEmail());
        entoncesVeo(mav);
    }
    @Test
    public void queElControladorMeInformeQueEstoyEnElNivel2(){
        dadoQueExisteUnRoomieLogueadoCon2punto(datos2.getEmail());
        entoncesTengoElnivel2(datos2.getEmail());
        ModelAndView mav = entoncesQueMeDevuelvaUnaVistaConUnNivel(datos2.getEmail());
        entoncesVeo2(mav);
    }

    @Test
    public void queElControladorMeInformeQueEstoyEnElNivel3(){
        dadoQueExisteUnRoomieLogueadoCon3punto(datos3.getEmail());
        entoncesTengoElnivel3(datos3.getEmail());
        ModelAndView mav = entoncesQueMeDevuelvaUnaVistaConUnNivel(datos3.getEmail());
        entoncesVeo3(mav);
    }

    private void entoncesVeo(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("home");
        assertThat(mav.getModelMap().get("nivel")).isEqualTo("RoomieBasico");
    }
    private void entoncesVeo2(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("home");
        assertThat(mav.getModelMap().get("nivel")).isEqualTo("RoomieMedio");
    }

    private void entoncesVeo3(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("home");
        assertThat(mav.getModelMap().get("nivel")).isEqualTo("RoomieFantastico");
    }
    private ModelAndView entoncesQueMeDevuelvaUnaVistaConUnNivel(String email) {
        return controladorGamifiction.mostrarNivel(email);
    }

    private void entoncesTengoElnivel(String email) {
            servicioDeGamification.obtenerNivel(email);
            when(servicioDeGamification.obtenerNivel(email)).thenReturn("RoomieBasico");
    }
    private void entoncesTengoElnivel2(String email) {
        servicioDeGamification.obtenerNivel(email);
        when(servicioDeGamification.obtenerNivel(email)).thenReturn("RoomieMedio");
    }
    private void entoncesTengoElnivel3(String email) {
        servicioDeGamification.obtenerNivel(email);
        when(servicioDeGamification.obtenerNivel(email)).thenReturn("RoomieFantastico");
    }
    private void dadoQueExisteUnRoomieLogueadoCon1punto(String email) {
        servicioDeGamification.generarPuntajeGamification(email);
        when(servicioDeGamification.generarPuntajeGamification(email)).thenReturn(1);
    }
    private void dadoQueExisteUnRoomieLogueadoCon2punto(String email) {
        servicioDeGamification.generarPuntajeGamification(email);
        when(servicioDeGamification.generarPuntajeGamification(email)).thenReturn(4);
    }
    private void dadoQueExisteUnRoomieLogueadoCon3punto(String email) {
        servicioDeGamification.generarPuntajeGamification(email);
        when(servicioDeGamification.generarPuntajeGamification(email)).thenReturn(6);
    }

}


