package ar.edu.unlam.tallerweb1.BuscadorGeneral.Controlador;

import ar.edu.unlam.tallerweb1.controladores.ControladorBuscador;
import ar.edu.unlam.tallerweb1.modelo.DatosRecibidosPorPost.DatosBuscadorAlquiler;
import ar.edu.unlam.tallerweb1.modelo.Excepciones.ViviendaExistente;
import ar.edu.unlam.tallerweb1.modelo.Vivienda;
import ar.edu.unlam.tallerweb1.servicios.ServicioBuscador;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ControladorBuscadorAlquilerTest {

    private ControladorBuscador controladorBuscador;
    private ServicioBuscador servicioBuscador;
    private static final String VISTA_LISTA_ALQUILERES = "buscador-alquiler";
    private static final String VISTA_LISTA_ALQUILERES_FILTRADOS = "validar-buscador-alquiler";
    private Vivienda vivienda;
    private Vivienda vivienda2;
    private Vivienda vivienda3;
    private Vivienda vivienda4;
    private String direccion1;
    private String direccion2;
    private String direccion3;
    private String direccion4;
    private DatosBuscadorAlquiler datos;

    @Before
    public void init(){
        servicioBuscador = mock(ServicioBuscador.class);
        controladorBuscador = new ControladorBuscador(servicioBuscador);
        direccion1 = "calle 1";
        direccion2 = "calle 2";
        direccion3 = "calle 3";
        direccion4 = "calle 4";
        vivienda = new Vivienda();
        vivienda2 =new Vivienda();
        vivienda3 =new Vivienda();
        vivienda4 =new Vivienda();
        datos = new DatosBuscadorAlquiler();
    }

    @Test
    public void queAlIrABuscadorDeAlquileresMeDevuelvaUnaLista(){

        vivienda.setDireccion(direccion1);
        dadoQueExistenViviendas(direccion1);

        ModelAndView mav = mostrarAlquileresDisponibles();

        entoncesMeLLevaALaVista(VISTA_LISTA_ALQUILERES,mav.getViewName());

    }

    @Test
    public void queAlFiltrarBuscadorDeAlquileresDevuelvaLosAlquileresDisponiblesFiltrados(){

        //PREPARACION
        vivienda.setDireccion(direccion1);
        datos.setId(vivienda.getVivienda());
        dadoQueExisteLaVivienda(direccion1, vivienda);

        ModelAndView mav = mostrarAlquileresFiltrados(datos);

        entoncesMeLLevaALaVista(VISTA_LISTA_ALQUILERES,mav.getViewName());
    }

    //agg boton que vaya a alquiler
    //agg boton denuncia
    //agg boton dar donacion

    @Test(expected = ViviendaExistente.class)
    public void alPedirListaFiltradaInvalidaLleveAPantallaDeError(){

        vivienda.setDireccion(direccion1);
        datos.setId(vivienda.getVivienda());
        dadoQueNoExistenViviendas();

        ModelAndView mav = EntoncesMeDevuelveUnaVistaConError(datos);

        entoncesMeLLevaALaVista(VISTA_LISTA_ALQUILERES,mav.getViewName());
        EntoncesObtengoElMensajeDeErrorDeLaVista(mav.getViewName(), mav.getModelMap());
    }

    private ModelAndView mostrarAlquileresFiltrados(DatosBuscadorAlquiler datos) {
        return controladorBuscador.MostrarListaAlquileres(datos);
    }

    private void dadoQueExisteLaVivienda(String direccion1, Vivienda vivienda) {
        when(servicioBuscador.buscarAlquilerPorDireccion(direccion1)).thenReturn(vivienda);
    }

    private ModelAndView EntoncesMeDevuelveUnaVistaConError(DatosBuscadorAlquiler datos) throws ViviendaExistente{
        controladorBuscador.MostrarListaAlquileres(datos);
        throw new ViviendaExistente();
    }

    private ModelAndView mostrarAlquileresDisponibles() {
        return controladorBuscador.irABuscadorAlquiler();
    }

    private void dadoQueExistenViviendas(String direccion) {
        when(servicioBuscador.buscarAlquilerPorDireccion(direccion)).thenReturn(vivienda);
    }

    private void dadoQueNoExistenViviendas(){
        when(servicioBuscador.ListarAlquileres()).thenReturn(null);
    }

    private void entoncesMeLLevaALaVista(String vistaEsperada, String vistasRecibida) {
        assertThat(vistaEsperada).isEqualTo(vistasRecibida);
    }
    private void EntoncesObtengoElMensajeDeErrorDeLaVista(String viewName, ModelMap modelMap) throws ViviendaExistente{
        assertThat(modelMap.get("error")).isEqualTo(viewName);
    }
}

