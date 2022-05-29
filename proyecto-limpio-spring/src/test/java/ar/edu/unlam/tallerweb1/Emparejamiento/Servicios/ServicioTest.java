package ar.edu.unlam.tallerweb1.Emparejamiento.Servicios;

import ar.edu.unlam.tallerweb1.controladores.ControladorEmparejamiento;
import ar.edu.unlam.tallerweb1.modelo.Atributo;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.repositorios.IRepositorioEmparejamiento;
import ar.edu.unlam.tallerweb1.servicios.IServicioEmparejamiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioEmparejamiento;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioTest {

    static Roomie r1 = new Roomie();
    static Roomie r2 = new Roomie();
    static Roomie r3 = new Roomie();
    private static List<Roomie> roomieList = new LinkedList<>();
    private ServicioEmparejamiento servicioEmparejamiento;
    private IRepositorioEmparejamiento repositorioEmparejamiento;

    @Before
    public void init(){
        repositorioEmparejamiento =  mock(IRepositorioEmparejamiento.class);
        servicioEmparejamiento = new ServicioEmparejamiento(repositorioEmparejamiento);
    }

    @Test
    public void queElControladorMeDevuelvaUsuariosCompatible(){
        dadoQueExisteUnUsuarioLogueado();
        dadoQueExisteUnUsuarioCompatibles();
        List<Roomie> roomiesCompatibles = entoncesMeDevuelveUnaListaDeUsuariosCompatible();
        entoncesLosRoomiesQueTrajoSonCompatiblesEnMasDeUn70Porciento(roomiesCompatibles);
    }

    private void entoncesLosRoomiesQueTrajoSonCompatiblesEnMasDeUn70Porciento(List<Roomie> roomiesCompatibles) {
        assertThat(roomiesCompatibles.size()).isEqualTo(2);
        assertThat(roomiesCompatibles.contains(r2)).isTrue();
        assertThat(roomiesCompatibles.get(0)).isEqualTo(r2);
    }

    private List<Roomie> entoncesMeDevuelveUnaListaDeUsuariosCompatible() {
        return servicioEmparejamiento.ObtenerRoomiesCompatibles(r1.getId());
    }

    private void dadoQueExisteUnUsuarioCompatibles() {
        LinkedList<Atributo> atributos = new LinkedList<>();
        atributos.add(Atributo.FUMADOR);
        atributos.add(Atributo.VEGGIE);
        atributos.add(Atributo.WEEDFRIENDLY);
        atributos.add(Atributo.INCLUSIVO);
        atributos.add(Atributo.DIURNO);
        atributos.add(Atributo.SEXWORK);
        atributos.add(Atributo.NOCTURNO);
        r2.setNombre("Leandro");
        r2.setId(2L);
        r2.setAtributos(atributos);
        roomieList.add(r2);

        LinkedList<Atributo> atributos2 = new LinkedList<>();
        atributos2.add(Atributo.DIURNO);
        atributos2.add(Atributo.SEXWORK);
        atributos2.add(Atributo.PETFRIENDLY);
        atributos2.add(Atributo.NOCTURNO);
        r3.setNombre("Matias");
        r3.setId(3L);
        //r3.setAtributos(atributos2);
        roomieList.add(r3);

        when(repositorioEmparejamiento.ObtenerRoomies()).thenReturn(roomieList);
    }

    private void dadoQueExisteUnUsuarioLogueado() {
        LinkedList<Atributo> atributos = new LinkedList<>();
        atributos.add(Atributo.FUMADOR);
        atributos.add(Atributo.DIURNO);
        atributos.add(Atributo.GAMER);
        atributos.add(Atributo.INCLUSIVO);
        atributos.add(Atributo.VEGGIE);
        atributos.add(Atributo.SEXWORK);
        r1.setNombre("Ariel");
        r1.setId(1L);
        r1.setAtributos(atributos);

        when(repositorioEmparejamiento.ObtenerRoomiePorId(r1.getId())).thenReturn(r1);
    }
}
