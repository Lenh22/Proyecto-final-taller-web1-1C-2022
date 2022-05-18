package ar.edu.unlam.tallerweb1.Emparejamiento.Controlador;

import ar.edu.unlam.tallerweb1.controladores.ControladorEmparejamiento;
import ar.edu.unlam.tallerweb1.modelo.Atributo;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class ControladorTest {

    static Roomie r1 = new Roomie();
    static Roomie r2 = new Roomie();
    ControladorEmparejamiento controladorEmparejamiento = new ControladorEmparejamiento();

    @Test
    public void queElControladorMeDevuelvaUnUsuarioCompatible(){
        dadoQueExisteUnRoomieLogueado();
        //dadoQueExisteUnRoomieCompatible();
        ModelAndView mav = entoncesQueMeDevuelvaUnaVistaConElRoomie();
        entoncesMeDevuelveLaVistaConUnRoomie(mav);
    }

    private void entoncesMeDevuelveLaVistaConUnRoomie(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("resultado-roomies-compatibles");
        r2 = (Roomie) mav.getModel().get("RoomieEncontrado");
        assertThat(r2.mostrarAtributos()).isEqualTo(r1.mostrarAtributos());
    }

    private void dadoQueExisteUnRoomieLogueado() {
        TreeSet<Atributo> atributos = new TreeSet<>();
        atributos.add(Atributo.FUMADOR);
        r1.setNombre("Ariel");
        r1.setAtributos(atributos);
    }

    /*private void dadoQueExisteUnRoomieCompatible() {
        TreeSet<Atributo> atributos = new TreeSet<>();
        atributos.add(Atributo.FUMADOR);
        r2.setNombre("Ariel");
        r2.setAtributos(atributos);
    }*/

    private ModelAndView entoncesQueMeDevuelvaUnaVistaConElRoomie() {
        return controladorEmparejamiento.irAResultadoRoomieCompatibles(2);
    }
}
