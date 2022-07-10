package ar.edu.unlam.tallerweb1.Viviendas.Controlador;

import ar.edu.unlam.tallerweb1.controladores.ControladorVivienda;
import ar.edu.unlam.tallerweb1.modelo.Vivienda;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioVivienda;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorTest {

    private ControladorVivienda controladorVivienda;
    private IServicioVivienda iServicioVivienda;

    @Before
    public  void  init()
    {
        iServicioVivienda = mock(IServicioVivienda.class);
        controladorVivienda = new ControladorVivienda(iServicioVivienda);
    }
    @Test
    public  void listaDeViviendas(){

    }

    private void entoncesMeLlevaALaVista(String viviendas, String viewName) {
        assertThat(viviendas).isEqualTo(viewName);
    }

    private void entocesEncuentro(ModelMap mav) {
        assertThat(mav.get("viviendas")).isNotNull();
    }

    private void dadoQueExisteUnaListaDeVivienda(int cant) {
        List<Vivienda> lista = new LinkedList<>();
            for (int i=0; i<cant;i++){
                Vivienda vivienda = new Vivienda();
                vivienda.setDireccion("direccion"+i);
                vivienda.setCantidadMaximaRoomies(i);
                lista.add(vivienda);
            }
            when(iServicioVivienda.getViviendas()).thenReturn(lista);
    }

}
