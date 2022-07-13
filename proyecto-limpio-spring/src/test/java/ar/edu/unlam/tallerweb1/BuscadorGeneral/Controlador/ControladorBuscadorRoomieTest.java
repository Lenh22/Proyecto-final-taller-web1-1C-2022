package ar.edu.unlam.tallerweb1.BuscadorGeneral.Controlador;

import ar.edu.unlam.tallerweb1.controladores.ControladorBuscador;
import ar.edu.unlam.tallerweb1.modelo.DatosBuscadorRoomie;
import ar.edu.unlam.tallerweb1.modelo.Excepciones.UsuarioExistente;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.servicios.ServicioBuscador;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorBuscadorRoomieTest {

    private ControladorBuscador controladorBuscador;
    private ServicioBuscador servicioBuscador;
    private DatosBuscadorRoomie datos;
    private static final String VISTA_LISTA_ROOMIES = "buscador-roomie";
    private static final String VISTA_LISTA_ROOMIES_FILTRO = "validar-buscador-roomie";
    private List<Roomie> listaRoomies;
    private Roomie roomie;
    private String nombre1;
    private String nombre2;
    private String nombre3;
    private String nombre4;


    @Before
    public void init(){
        servicioBuscador = mock(ServicioBuscador.class);
        controladorBuscador = new ControladorBuscador(servicioBuscador);
        datos = new DatosBuscadorRoomie();
        listaRoomies = new ArrayList<>();
        nombre1 = "Arami";
        nombre2 = "Leandro";
        nombre3 = "Emanuel";
        nombre4 = "Leandro2";
        roomie = new Roomie();
    }

    @Test
    public void queAlIrABuscadorDeRoomieDevuelvaUnaLista(){
        //prepracion
        dadoQueExisteRoomie(nombre1);
        datos.setNombre(nombre1);
        roomie.setNombre(nombre1);

        //ejecución
        ModelAndView mav = mostrarRoomiesDisponibles();

        //verificacion
        entoncesMeLLevaALaVista(VISTA_LISTA_ROOMIES,mav.getViewName());

    }

    @Test
    public void queAlIrABuscadorDeRoomieConFiltroDevuelvaUnaLista(){
        //prepracion
        dadoQueExisteRoomie(nombre1);
        datos.setNombre(nombre1);
        roomie.setNombre(nombre1);

        //ejecución
        ModelAndView mav = mostrarRoomiesDisponiblesConFiltro(datos);

        //verificacion
        entoncesMeLLevaALaVista(VISTA_LISTA_ROOMIES_FILTRO,mav.getViewName());

    }

    @Test(expected = UsuarioExistente.class)
    public void queAlIrABuscadorDeRoomieConFiltroNoDevuelvaUnaLista(){
        //prepracion
        dadoQueExisteRoomie(nombre1);
        datos.setNombre(nombre1);
        roomie.setNombre(nombre1);

        //ejecución
        ModelAndView mav = noMostrarRoomiesDisponibles(datos);

        //verificacion
        entoncesMeLLevaALaVista(VISTA_LISTA_ROOMIES,mav.getViewName());
        EntoncesObtengoElMensajeDeErrorDeLaVista(mav.getViewName(), mav.getModelMap());

    }

    private ModelAndView noMostrarRoomiesDisponibles(DatosBuscadorRoomie datos) throws UsuarioExistente{
        controladorBuscador.MostrarListaRoomies(datos);
        throw new UsuarioExistente();
    }

    private ModelAndView mostrarRoomiesDisponiblesConFiltro(DatosBuscadorRoomie datos) {
        return controladorBuscador.MostrarListaRoomies(datos);
    }

    private ModelAndView mostrarRoomiesDisponibles() {
        return controladorBuscador.irABuscadorRoomie();
    }

    private void dadoQueExisteRoomie(String nombre) {
        when(servicioBuscador.buscarRoomiePorNombre(nombre)).thenReturn(roomie);
    }

    private void entoncesMeLLevaALaVista(String vistaEsperada, String vistasRecibida) {
        assertThat(vistaEsperada).isEqualTo(vistasRecibida);
    }
    private void EntoncesObtengoElMensajeDeErrorDeLaVista(String viewName, ModelMap modelMap) {
        assertThat(modelMap.get("error")).isEqualTo(viewName);
    }
}

