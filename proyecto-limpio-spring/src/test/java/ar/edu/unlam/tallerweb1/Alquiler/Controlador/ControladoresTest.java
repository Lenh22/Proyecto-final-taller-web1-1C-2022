package ar.edu.unlam.tallerweb1.Alquiler.Controlador;

import ar.edu.unlam.tallerweb1.controladores.ControladorAlquiler;
import ar.edu.unlam.tallerweb1.controladores.ControladorVivienda;
import ar.edu.unlam.tallerweb1.modelo.Propietario;
import ar.edu.unlam.tallerweb1.modelo.Vivienda;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPropietario;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlquiler;
import ar.edu.unlam.tallerweb1.servicios.ServicioPropietario;
import ar.edu.unlam.tallerweb1.servicios.ServicioVivienda;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladoresTest {

    private Vivienda vivienda;
    private Propietario propietario;

    private ControladorAlquiler controladorAlquiler;
    private ControladorVivienda controladorVivienda;
    private ServicioVivienda servicioVivienda;
    private ServicioAlquiler servicioAlquiler;
    private ServicioPropietario servicioPropietario;

    @Before
    public void init(){
        servicioPropietario = mock(ServicioPropietario.class);
        servicioVivienda = mock(ServicioVivienda.class);
        servicioAlquiler = mock(ServicioAlquiler.class);
        controladorAlquiler = new ControladorAlquiler(servicioAlquiler);
        controladorVivienda = new ControladorVivienda(servicioVivienda,servicioPropietario);
    }

    /*____________________________________TEST____________________________*/
    @Test
    public void queElControladorTomeLosDatosDeLaListaDeAlquileresYMeLleveALaVista(){
        dadoQueTengoUnaViviendaEnAlquiler();
        ModelAndView mav = cuandoElijoLaViviendaMeLLevaAlControlador();
        entoncesVoyALaVistaParaRealizarElAlquiler(mav);
    }

    /*____________________________________DADO____________________________*/
    private void dadoQueTengoUnaViviendaEnAlquiler() {
        propietario = new Propietario("Leandro", "Gomez", 25, "leandro.ariel.gomez1@gmail.com", "123", "propietario");
        propietario.setId(1L);
        vivienda = new Vivienda("Baragania 6451",2,2,"Es un lugar muy comodo",true,propietario);
        vivienda.setId(1);
        when(servicioVivienda.obtenerViviendaPorId(1)).thenReturn(vivienda);
    }

    /*____________________________________CUANDO____________________________*/
    private ModelAndView cuandoElijoLaViviendaMeLLevaAlControlador() {
        return controladorVivienda.irAPerfilVivienda(1);
    }

    /*____________________________________ENTONCES____________________________*/
    private void entoncesVoyALaVistaParaRealizarElAlquiler(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("perfil-vivienda");
        assertThat(mav.getModelMap().size()).isEqualTo(1);
        assertThat(mav.getModelMap().containsAttribute("vivienda")).isTrue();
    }

}
