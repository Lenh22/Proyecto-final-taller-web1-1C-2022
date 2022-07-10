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
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ControladorBuscadorAlquilerTest {
/*
    private ControladorBuscador controladorBuscador;
    private ServicioBuscador servicioBuscador;
    private static final String VISTA_LISTA_ALQUILERES = "validar-buscador-alquiler";
    private static final String NOMBRE_INVALIDO = "invalido";
    private static final String MENSAJE_TIPO_INVALIDO = "La vivienda buscada no existe";
    private static final String MENSAJE_TIPO_VALIDO = "listaAlquileres";
    Vivienda vivienda;
    Vivienda vivienda2;
    Vivienda vivienda3;
    Vivienda vivienda4;
    private String direccion1;
    private String direccion2;
    private String direccion3;
    private String direccion4;


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
    }

    @Test
    public void queAlPedirAlquilerDevuelvaUnaLista(){
        //prepracion
        vivienda.setDireccion(direccion1);
        dadoQueExisteVivienda(direccion1, vivienda);
        vivienda2.setDireccion(direccion2);
        dadoQueExisteVivienda(direccion2, vivienda2);
        vivienda3.setDireccion(direccion3);
        dadoQueExisteVivienda(direccion3, vivienda3);
        vivienda4.setDireccion(direccion4);
        dadoQueExisteVivienda(direccion4, vivienda4);

        //ejecución
        controladorBuscador.MostrarListaAlquileres(direccion1);
        controladorBuscador.MostrarListaAlquileres(direccion2);
        controladorBuscador.MostrarListaAlquileres(direccion3);
        ModelAndView mav = controladorBuscador.MostrarListaAlquileres(direccion4);

        //verificacion
        entoncesEncuentro((List<Vivienda>) mav.getModel().get("listaAlquileres"));
        entoncesMeLLevaALaVista(VISTA_LISTA_ALQUILERES,mav.getViewName());
    }

    @Test(expected = ViviendaExistente.class)
    public void alPedirListaInvalidaLleveAPantallaDeError(){

        vivienda.setDireccion(direccion1);
        dadoQueNoExisteVivienda(direccion1);

        ModelAndView mav = EntoncesMeDevuelveUnaVistaConError(direccion1);

        entoncesMeLLevaALaVista(VISTA_LISTA_ALQUILERES,mav.getViewName());
       EntoncesObtengoElMensajeDeErrorDeLaVista(mav.getViewName(), mav.getModelMap());
    }

    private void entoncesNoEncuentro(List<Vivienda> lista) {
        assertThat(servicioBuscador.ListarAlquileres()).isEqualTo(lista);
    }

    private void dadoQueExisteVivienda(String direccion, Vivienda vivienda) {
        when(servicioBuscador.buscarAlquilerPorDireccion(direccion)).thenReturn(vivienda);
    }

    private void dadoQueNoExisteVivienda(String direccion){
        when(servicioBuscador.buscarAlquilerPorDireccion(direccion)).thenReturn(null);
    }

    private void entoncesEncuentro(List<Vivienda> lista) {
        assertThat(servicioBuscador.ListarAlquileres()).isEqualTo(lista);
    }

    private void entoncesMeLLevaALaVista(String vistaEsperada, String vistasRecibida) {
        assertThat(vistaEsperada).isEqualTo(vistasRecibida);
    }
    private void EntoncesObtengoElMensajeDeErrorDeLaVista(String viewName, ModelMap modelMap) throws ViviendaExistente{
        assertThat(viewName).isEqualTo(VISTA_LISTA_ALQUILERES);
        assertThat(modelMap.get("msg-error")).isEqualTo("La vivienda buscada no existe");
    }

    private ModelAndView EntoncesMeDevuelveUnaVistaConError(String direccion) {
        return controladorBuscador.MostrarListaAlquileres(direccion);
    }

    private void entoncesSeRecibeMensaje(String mensaje, Map<String, Object> model) {
        assertThat(model.get(mensaje)).isEqualTo("msg-error");
    }
/*
    @Test
    public void alPedirListaInvalidaLleveAPantallaDeError(){
//        String datos = "Maria";
//
//        dadoQueExistaUnaListaDeRoomies (10, datos);
//
//        ModelAndView mav = controladorBuscador.MostrarListaRoomies(NOMBRE_INVALIDO);
        when(servicioBuscador.buscarRoomies(NOMBRE_INVALIDO)).thenThrow(new RuntimeException());

        ModelAndView mav = controladorBuscador.MostrarListaRoomies(NOMBRE_INVALIDO);
                //controladorEmparejamiento.irAResultadoRoomieCompatibles(id);

        //entoncesMeLLevaALaVista(VISTA_LISTA_ROOMIES,mav.getViewName());
        //NO MUESTRA PORQUE TOMA COMO VALIDO A NOMBRE_INVALIDO
        entoncesSeRecibeMensaje(MENSAJE_TIPO_INVALIDO, mav.getModel());
    }

    private void entoncesSeRecibeMensaje(String mensaje, Map<String, Object> model) {
        assertThat(model.get(mensaje)).isEqualTo("msg-error");
    }
*/




}

