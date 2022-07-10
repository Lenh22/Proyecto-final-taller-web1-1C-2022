package ar.edu.unlam.tallerweb1.BuscadorGeneral.Controlador;

import ar.edu.unlam.tallerweb1.controladores.ControladorBuscador;
import ar.edu.unlam.tallerweb1.modelo.DatosBuscadorAlquiler;
import ar.edu.unlam.tallerweb1.modelo.DatosBuscadorRoomie;
import ar.edu.unlam.tallerweb1.modelo.Excepciones.UsuarioExistente;
import ar.edu.unlam.tallerweb1.modelo.Excepciones.ViviendaExistente;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.Vivienda;
import ar.edu.unlam.tallerweb1.servicios.ServicioBuscador;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorBuscadorRoomieTest {
/*
    private ControladorBuscador controladorBuscador;
    private ServicioBuscador servicioBuscador;
    private DatosBuscadorRoomie datos;
    private static final String VISTA_LISTA_ROOMIES = "validar-buscador-roomie";
    private static final String MENSAJE_TIPO_INVALIDO = "La vivienda buscada no existe";
    private static final String MENSAJE_TIPO_VALIDO = "listaRoomies";
    private List<Roomie> listaRoomies;
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
    }

    @Test
    public void queAlPedirAlquilerDevuelvaUnaLista(){
        //prepracion
        dadoQueExisteRoomie(nombre1);
        datos.setNombre(nombre1);

        //ejecución
        ModelAndView mav = controladorBuscador.MostrarListaRoomies(datos);

        //verificacion
        entoncesEncuentro((List<Roomie>) mav.getModel().get(MENSAJE_TIPO_VALIDO));
        entoncesMeLLevaALaVista(VISTA_LISTA_ROOMIES,mav.getViewName());
    }

    @Test
    public void alPedirListaInvalidaLleveAPantallaDeError(){

        dadoQueNoExisteRoomie(nombre1);
        datos.setNombre(nombre1);

        ModelAndView mav = EntoncesMeDevuelveUnaVistaConError(datos);
        //entoncesEncuentro((List<Vivienda>) mav.getModel().get("listaAlquileres"));
        entoncesMeLLevaALaVista(VISTA_LISTA_ROOMIES,mav.getViewName());
        //EntoncesObtengoElMensajeDeErrorDeLaVista(mav.getViewName(), mav.getModelMap());
    }

    private void dadoQueExisteRoomie(String nombre) {
        when(servicioBuscador.buscarRoomies(nombre)).thenReturn(listaRoomies);
    }

    private void dadoQueNoExisteRoomie(String nombre){
        when(servicioBuscador.buscarRoomies(nombre)).thenThrow(new UsuarioExistente());
    }

    private void entoncesEncuentro(List<Roomie> lista) {
        assertThat(servicioBuscador.obtenerRoomies()).isEqualTo(lista);
    }

    private void entoncesMeLLevaALaVista(String vistaEsperada, String vistasRecibida) {
        assertThat(vistaEsperada).isEqualTo(vistasRecibida);
    }
    private void EntoncesObtengoElMensajeDeErrorDeLaVista(String viewName, ModelMap modelMap) {
        assertThat(viewName).isEqualTo(VISTA_LISTA_ROOMIES);
        //assertThat(modelMap.get("msg-error")).isEqualTo(MENSAJE_TIPO_INVALIDO);
    }

    private ModelAndView EntoncesMeDevuelveUnaVistaConError(DatosBuscadorRoomie nombre) {
        return controladorBuscador.MostrarListaRoomies(nombre);
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

