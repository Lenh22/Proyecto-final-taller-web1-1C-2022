package ar.edu.unlam.tallerweb1.contrladores;

import ar.edu.unlam.tallerweb1.controladores.ControladorDonaciones;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import static org.assertj.core.api.Assertions.*;


public class ControladoresDonacionTest {
    private ControladorDonaciones controladorDonaciones;

    @Test

    public void listarRoomiesQueAceptenDonaciones(){
        //prepracion

        dadoQueExisteDonatario (10);
        //ejecución

        ModelAndView mav = ControladorDonaciones.listar();


        //verificacion

        entoncesEncuentro(mav.getModel().get("donatarios"));
        entoncesMeLLevaALaVista("listadoDonatario",mav.getViewName());
   
    }

    private void entoncesMeLLevaALaVista(String vistaEsperada, String vistasRecibida) {
    assertThat(vistasRecibida).isEqualTo(vistasRecibida);

    }

    private void entoncesEncuentro(Object donatarios) {
    }

    private void entoncesEncuentro(List<Roomie> lista, int catidadEsperada) {
        assertThat(lista).hasSize(catidadEsperada);
    }

    private void dadoQueExisteDonatario(int catidadExistente) {
        controladorDonaciones  = new ControladorDonaciones(catidadExistente);
    }
}
