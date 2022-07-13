package ar.edu.unlam.tallerweb1.BuscadorGeneral.Controlador;

import ar.edu.unlam.tallerweb1.controladores.ControladorBuscador;
import ar.edu.unlam.tallerweb1.modelo.DatosBuscadorAlquiler;
import ar.edu.unlam.tallerweb1.modelo.Excepciones.ViviendaExistente;
import ar.edu.unlam.tallerweb1.modelo.Vivienda;
import ar.edu.unlam.tallerweb1.servicios.ServicioBuscador;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import java.util.LinkedList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ControladorBuscadorAlquilerTest {

    private ControladorBuscador controladorBuscador;
    private ServicioBuscador servicioBuscador;
    private static final String VISTA_LISTA_ALQUILERES = "buscador-alquiler";
    private static final String VISTA_LISTA_ALQUILERES_FILTRADOS = "validar-buscador-alquiler";
    private static final String NOMBRE_INVALIDO = "invalido";
    private static final String MENSAJE_TIPO_INVALIDO = "La vivienda buscada no existe";
    private static final String MENSAJE_TIPO_VALIDO = "listaAlquileres";
    LinkedList<Vivienda> viviendas = new LinkedList<>();
    private Vivienda vivienda;
    private Vivienda vivienda2;
    private Vivienda vivienda3;
    private Vivienda vivienda4;
    private Integer direccion1;
    private Integer direccion2;
    private Integer direccion3;
    private Integer direccion4;
    private DatosBuscadorAlquiler datos;


    @Before
    public void init(){
        servicioBuscador = mock(ServicioBuscador.class);
        controladorBuscador = new ControladorBuscador(servicioBuscador);
        direccion1 = 1;
        direccion2 = 2;
        direccion3 = 3;
        direccion4 = 4;
        vivienda = new Vivienda();
        vivienda2 =new Vivienda();
        vivienda3 =new Vivienda();
        vivienda4 =new Vivienda();
        datos = new DatosBuscadorAlquiler();
    }

    @Test
    public void queAlIrABuscadorDeAlquileresMeDevuelvaUnaLista(){

        vivienda.setVivienda(direccion1);
        dadoQueExistenViviendas(direccion1);

        ModelAndView mav = mostrarAlquileresDisponibles();

        entoncesMeLLevaALaVista(VISTA_LISTA_ALQUILERES,mav.getViewName());

    }

    @Test
    public void queAlFiltrarBuscadorDeAlquileresDevuelvaLosAlquileresDisponiblesFiltrados(){

        //PREPARACION
        vivienda.setVivienda(direccion1);
        datos.setId(vivienda.getVivienda());
        dadoQueExisteLaVivienda(direccion1, vivienda);

        ModelAndView mav = mostrarAlquileresFiltrados(datos);

       // entoncesMeDevuelve(direccion1);

        entoncesMeLLevaALaVista(VISTA_LISTA_ALQUILERES_FILTRADOS,mav.getViewName());
    }

    //agg boton que vaya a alquiler
    //agg boton denuncia
    //agg boton dar donacion

    @Test(expected = ViviendaExistente.class)
    public void alPedirListaFiltradaInvalidaLleveAPantallaDeError(){

        vivienda.setVivienda(direccion1);
        datos.setId(vivienda.getVivienda());
        dadoQueNoExistenViviendas();

        ModelAndView mav = EntoncesMeDevuelveUnaVistaConError(datos);

        entoncesMeLLevaALaVista(VISTA_LISTA_ALQUILERES,mav.getViewName());
        EntoncesObtengoElMensajeDeErrorDeLaVista(mav.getViewName(), mav.getModelMap());
    }

    private ModelAndView mostrarAlquileresFiltrados(DatosBuscadorAlquiler datos) {
        return controladorBuscador.MostrarListaAlquileres(datos);
    }

    private void dadoQueExisteLaVivienda(Integer direccion1, Vivienda vivienda) {
        when(servicioBuscador.buscarAlquilerPorDireccion(direccion1)).thenReturn(vivienda);
    }

    private ModelAndView EntoncesMeDevuelveUnaVistaConError(DatosBuscadorAlquiler datos) throws ViviendaExistente{
        controladorBuscador.MostrarListaAlquileres(datos);
        throw new ViviendaExistente();
    }

    private ModelAndView mostrarAlquileresDisponibles() {
        return controladorBuscador.irABuscadorAlquiler();
    }

    private void dadoQueExistenViviendas(Integer id) {
        when(servicioBuscador.buscarAlquilerPorDireccion(id)).thenReturn(vivienda);
    }

    private void dadoQueNoExistenViviendas(){
        when(servicioBuscador.ListarAlquileres()).thenReturn(null);
    }

    private void entoncesMeLLevaALaVista(String vistaEsperada, String vistasRecibida) {
        assertThat(vistaEsperada).isEqualTo(vistasRecibida);
    }
    private void EntoncesObtengoElMensajeDeErrorDeLaVista(String viewName, ModelMap modelMap) throws ViviendaExistente{
        assertThat(modelMap.get("error")).isEqualTo("La vivienda buscada no existe");
    }
}

