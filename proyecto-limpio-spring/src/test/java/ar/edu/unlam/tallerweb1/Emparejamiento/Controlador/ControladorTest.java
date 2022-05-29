package ar.edu.unlam.tallerweb1.Emparejamiento.Controlador;

import ar.edu.unlam.tallerweb1.controladores.ControladorEmparejamiento;
import ar.edu.unlam.tallerweb1.modelo.Atributo;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.servicios.ServicioEmparejamiento;
import org.hibernate.boot.model.source.spi.SingularAttributeSourceOneToOne;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.*;

public class ControladorTest {

    static Roomie r1 = new Roomie();
    static Roomie r2 = new Roomie();
    static Roomie r3 = new Roomie();
    private static final LinkedList<Roomie> roomieList = new LinkedList<>();
    private ServicioEmparejamiento servicioEmparejamiento;
    private ControladorEmparejamiento controladorEmparejamiento;

    @Before
    public void init(){
        servicioEmparejamiento = mock(ServicioEmparejamiento.class);
        controladorEmparejamiento = new ControladorEmparejamiento(servicioEmparejamiento);
    }

    @Test
    public void queElControladorMeDevuelvaDosUsuarioCompatible(){
        dadoQueExisteUnRoomieLogueado();
        dadoQueExisteUnRoomieCompatible();
        dadoQueExisteUnRoomieCompatibleDos();

        when(servicioEmparejamiento.ObtenerRoomiesCompatibles(r1.getId())).thenReturn(roomieList);

        ModelAndView mav = entoncesQueMeDevuelvaUnaVistaConElRoomie(r1.getId());
        entoncesMeDevuelveLaVistaConDosRoomie(mav);
    }

    @Test
    public void queElControladorMeDevuelvaUnUsuarioCompatible(){
        dadoQueExisteUnRoomieLogueado();
        dadoQueExisteUnRoomieCompatible();

        when(servicioEmparejamiento.ObtenerRoomiesCompatibles(r1.getId())).thenReturn(roomieList);

        ModelAndView mav = entoncesQueMeDevuelvaUnaVistaConElRoomie(r1.getId());
        entoncesMeDevuelveLaVistaConUnRoomie(mav);
    }

    @Test
    public void queElControladorDevuelvaNingunUsuarioCompatible(){
        dadoQueExisteUnRoomieLogueado();

        when(servicioEmparejamiento.ObtenerRoomiesCompatibles(r1.getId())).thenReturn(anyList());

        ModelAndView mav = entoncesQueMeDevuelvaUnaVistaConUnMensajeDeSinEmparejamiento(r1.getId());
        entoncesMeDevuelveLaVistaConUnaListaVacia(mav);
    }

    @Test
    public void queElControladorDevuelvaUnError(){
        when(servicioEmparejamiento.ObtenerRoomiesCompatibles(r1.getId())).thenThrow(new RuntimeException());

        ModelAndView mav = EntoncesMeDevuelveUnaVistaConError(r1.getId());
        EntoncesObtengoElMensajeDeErrorDeLaVista(mav.getViewName(), mav.getModelMap());
    }

    private void EntoncesObtengoElMensajeDeErrorDeLaVista(String viewName, ModelMap modelMap) {
        assertThat(viewName).isEqualTo("resultado-roomies-compatibles");
        assertThat(modelMap.get("msg-error")).isEqualTo("NOT FOUND 404");
    }

    private ModelAndView EntoncesMeDevuelveUnaVistaConError(Long id) {
        return controladorEmparejamiento.irAResultadoRoomieCompatibles(id);
    }

    private void dadoQueExisteUnRoomieCompatibleDos() {
        TreeSet<Atributo> atributos = new TreeSet<>();
        atributos.add(Atributo.FUMADOR);
        r3.setNombre("Matias");
        r3.setId(3L);
        r3.setAtributos(atributos);
        roomieList.add(r3);
    }

    private void dadoQueExisteUnRoomieCompatible() {
        TreeSet<Atributo> atributos = new TreeSet<>();
        atributos.add(Atributo.FUMADOR);
        r2.setNombre("Leandro");
        r2.setId(2L);
        r2.setAtributos(atributos);
        roomieList.add(r2);
    }

    private void dadoQueExisteUnRoomieLogueado() {
        TreeSet<Atributo> atributos = new TreeSet<>();
        atributos.add(Atributo.FUMADOR);
        r1.setNombre("Ariel");
        r1.setId(1L);
        r1.setAtributos(atributos);
    }

    private ModelAndView entoncesQueMeDevuelvaUnaVistaConElRoomie(Long id) {
        return controladorEmparejamiento.irAResultadoRoomieCompatibles(id);
    }

    private ModelAndView entoncesQueMeDevuelvaUnaVistaConUnMensajeDeSinEmparejamiento(Long id) {
        return controladorEmparejamiento.irAResultadoRoomieCompatibles(id);
    }

    private void entoncesMeDevuelveLaVistaConUnRoomie(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("resultado-roomies-compatibles");
        assertThat(mav.getModelMap().isEmpty()).isEqualTo(false);
        assertThat(mav.getModelMap().size()).isEqualTo(1);
        ModelMap map = mav.getModelMap();
        assertThat(map.get("RoomieEncontrado")).isEqualTo(roomieList);
        LinkedList<Roomie> roomieEsperada = new LinkedList<>();
        roomieEsperada = (LinkedList<Roomie>) map.get("RoomieEncontrado");
        assertThat(roomieEsperada.get(0)).isEqualTo(r2);
        assertThat(roomieEsperada.get(0).getAtributos()).isEqualTo(r2.getAtributos());
        System.out.println(roomieEsperada.get(0).getAtributos());
    }

    private void entoncesMeDevuelveLaVistaConDosRoomie(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("resultado-roomies-compatibles");
        LinkedList<Roomie> roomieEsperada = new LinkedList<>();
        ModelMap map = mav.getModelMap();
        roomieEsperada = (LinkedList<Roomie>) map.get("RoomieEncontrado");
        assertThat(roomieEsperada.size()).isEqualTo(2);
        assertThat(roomieEsperada.get(0).getNombre()).isEqualTo("Leandro");
        assertThat(roomieEsperada.get(1).getNombre()).isEqualTo("Matias");
    }

    private void entoncesMeDevuelveLaVistaConUnaListaVacia(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("resultado-roomies-compatibles");
        assertThat(mav.getModelMap().get("sin-emparejamiento")).isEqualTo("No se encontro un roomie compatible para usted");
    }

}
