package ar.edu.unlam.tallerweb1.Emparejamiento.Controlador;

import ar.edu.unlam.tallerweb1.controladores.ControladorEmparejamiento;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.servicios.ServicioEmparejamiento;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ControladorTest {

    static Roomie r1;
    static Roomie r2;
    private static List<Roomie> roomieList = new LinkedList<>();
    private ServicioEmparejamiento servicioEmparejamiento;
    private ControladorEmparejamiento controladorEmparejamiento;

    @Before
    public void init(){
        servicioEmparejamiento = mock(ServicioEmparejamiento.class);
        controladorEmparejamiento = new ControladorEmparejamiento(servicioEmparejamiento);
    }

    /*____________________________________TEST____________________________*/
    @Test
    public void queElControladorMeDevuelvaUsuariosCompatible(){
        dadoQueExistenDosUsuariosCompatibles();

        ModelAndView mav = cuandoBuscoPorUnIdMeDevuelveLaVistaDeRoomies();

        entoncesMeDevuelveLaVistaConDosRoomie(mav);
    }

    @Test
    public void queElControladorDevuelvaNingunUsuarioCompatible(){
        roomieList = new LinkedList<>();
        when(servicioEmparejamiento.obtenerRoomiesCompatibles(1L)).thenReturn(roomieList);

        ModelAndView mav = cuandoBuscoPorUnIdMeDevuelveLaVistaDeRoomiesVacias();
        entoncesMeDevuelveLaVistaConUnaListaVacia(mav);
    }

    /*____________________________________DADO____________________________*/
    private void dadoQueExistenDosUsuariosCompatibles() {
        r1 = new Roomie("Leandro","Gomez",25,"leandro@leandro.com","12345","roomie",false);
        r2 = new Roomie("Ariel","Gomez",22,"ariel@ariel.com","12345","roomie",false);
        r1.setId(2L);
        r2.setId(3L);
        roomieList.add(r1);
        roomieList.add(r2);
    }

    /*____________________________________CUANDO____________________________*/

    private ModelAndView cuandoBuscoPorUnIdMeDevuelveLaVistaDeRoomies() {
        when(servicioEmparejamiento.obtenerRoomiesCompatibles(1L)).thenReturn(roomieList);
        return controladorEmparejamiento.irAResultadoRoomieCompatibles(/*1L,*/null);
    }

    private ModelAndView cuandoBuscoPorUnIdMeDevuelveLaVistaDeRoomiesVacias() {
        return  controladorEmparejamiento.irAResultadoRoomieCompatibles(/*1L,*/null);
    }

    /*____________________________________ENTONCES____________________________*/

    private void entoncesMeDevuelveLaVistaConDosRoomie(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("resultado-roomies-compatibles");
        ModelMap map = mav.getModelMap();
        List<Roomie> roomieEsperada = (List<Roomie>) map.get("RoomieEncontrado");
        assertThat(roomieEsperada.size()).isEqualTo(2);
        assertThat(roomieEsperada.get(0).getNombre()).isEqualTo("Leandro");
        assertThat(roomieEsperada.get(1).getNombre()).isEqualTo("Ariel");
    }

    private void entoncesMeDevuelveLaVistaConUnaListaVacia(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("resultado-roomies-compatibles");
        assertThat(mav.getModelMap().get("sinEmparejamiento")).isEqualTo("No se encontro un roomie compatible para usted, lo sentimos!");
    }


    private void EntoncesObtengoElMensajeDeErrorDeLaVista(String viewName, ModelMap modelMap) {
        assertThat(viewName).isEqualTo("resultado-roomies-compatibles");
        assertThat(modelMap.get("msg-error")).isEqualTo("NOT FOUND 404");
    }

    private ModelAndView EntoncesMeDevuelveUnaVistaConError(Long id) {
        return controladorEmparejamiento.irAResultadoRoomieCompatibles(/*1L,*/null);
    }

}
