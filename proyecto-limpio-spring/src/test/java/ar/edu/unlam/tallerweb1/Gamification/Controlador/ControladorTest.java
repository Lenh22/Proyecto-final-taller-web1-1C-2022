package ar.edu.unlam.tallerweb1.Gamification.Controlador;


import ar.edu.unlam.tallerweb1.controladores.ControladorGamifiction;
import ar.edu.unlam.tallerweb1.controladores.DatosDonacion;
import ar.edu.unlam.tallerweb1.controladores.DatosGamification;
import ar.edu.unlam.tallerweb1.controladores.DatosLogin;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.servicios.IServicioDeGamification;
import ar.edu.unlam.tallerweb1.servicios.ServicioDeGamification;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorTest {

    private IServicioDeGamification servicioDeGamification;
    private ControladorGamifiction controladorGamifiction;

    private DatosGamification datos = new DatosGamification("pepe@mail.com", 1);

    @Before
    public void init(){
        servicioDeGamification = mock(IServicioDeGamification.class);
        controladorGamifiction = new ControladorGamifiction(servicioDeGamification);

    }

    @Test
    public void queElControladorMeInformeQueEstoyEnElNivel1(){
        dadoQueExisteUnRoomieLogueadoCon1punto(datos.getEmail());
        //String email = datos.getEmail();
        ModelAndView mav = controladorGamifiction.mostrarNivel(mail);
        entoncesVeo(mav.getModel().get("nivel"), "Roomie basico" );
    }


    private void dadoQueExisteUnRoomieLogueadoCon1punto(String email) {
        servicioDeGamification.generarPuntajeGamification(email);
        when(servicioDeGamification.generarPuntajeGamification(email)).thenReturn(1);
    }

    private void entoncesVeo(Object nivel, String i) {

        assertThat(nivel).isEqualTo(i);
    }


    @Test
    public void queElControladorMeInformeQueEstoyEnElNivel2(){

    }

    @Test
    public void queElControladorMeInformeQueEstoyEnElNivel3(){

    }
}
