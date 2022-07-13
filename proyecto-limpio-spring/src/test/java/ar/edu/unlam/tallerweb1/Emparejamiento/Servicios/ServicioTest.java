package ar.edu.unlam.tallerweb1.Emparejamiento.Servicios;

import ar.edu.unlam.tallerweb1.modelo.Atributo;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.RoomieAtributos;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioEmparejamiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioEmparejamiento;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioTest {

    private static Roomie r1;
    private static Roomie r2;
    private static Roomie r3;

    private static List<Roomie> roomieList = new LinkedList<>();
    private ServicioEmparejamiento servicioEmparejamiento;
    private IRepositorioEmparejamiento repositorioEmparejamiento;

    @Before
    public void init(){
        repositorioEmparejamiento =  mock(IRepositorioEmparejamiento.class);
        servicioEmparejamiento = new ServicioEmparejamiento(repositorioEmparejamiento);
    }

    /*____________________________________TEST____________________________*/
    @Test
    public void queElServicioMeDevuelvaUsuariosCompatible(){
        dadoQueExisteUnUsuarioLogueado();
        dadoQueExisteUnUsuarioCompatibles();
        List<Roomie> roomiesCompatibles = cuandoBuscoPorUnIDMeDevuelveUnaListaDeUsuariosCompatible();
        entoncesLosRoomiesQueTrajoSonCompatiblesEnMasDeUn70Porciento(roomiesCompatibles);
    }


    /*____________________________________DADO____________________________*/
    private void dadoQueExisteUnUsuarioLogueado() {
        r1 = new Roomie("Ariel","Gomez",22,"ariel@ariel.com","12345","roomie",false);
        r1.setId(1L);
        /*List<RoomieAtributos> atributosRoomieUno = new LinkedList<>();
        RoomieAtributos ra = new RoomieAtributos(1L,Atributo.FUMADOR);
        ra.setId(2L);
        RoomieAtributos ra1 = new RoomieAtributos(1L,Atributo.DIURNO);
        ra.setId(3L);
        RoomieAtributos ra2 = new RoomieAtributos(1L,Atributo.GAMER);
        ra.setId(4L);
        RoomieAtributos ra3 = new RoomieAtributos(1L,Atributo.INCLUSIVO);
        ra.setId(5L);
        RoomieAtributos ra4 = new RoomieAtributos(1L,Atributo.VEGGIE);
        ra.setId(6L);
        RoomieAtributos ra5 = new RoomieAtributos(1L,Atributo.SEXWORK);
        ra.setId(7L);
        atributosRoomieUno.add(ra);
        atributosRoomieUno.add(ra1);
        atributosRoomieUno.add(ra2);
        atributosRoomieUno.add(ra3);
        atributosRoomieUno.add(ra4);
        atributosRoomieUno.add(ra5);*/

        List<Atributo> atributosRoomieUno = new LinkedList<>();
        atributosRoomieUno.add(Atributo.FUMADOR);
        atributosRoomieUno.add(Atributo.DIURNO);
        atributosRoomieUno.add(Atributo.GAMER);
        atributosRoomieUno.add(Atributo.INCLUSIVO);
        atributosRoomieUno.add(Atributo.VEGGIE);
        atributosRoomieUno.add(Atributo.SEXWORK);

        when(repositorioEmparejamiento.obtenerRoomiePorId(1L)).thenReturn(r1);
        when(repositorioEmparejamiento.obtenerAtributosPorId(1L)).thenReturn(atributosRoomieUno);
    }

    private void dadoQueExisteUnUsuarioCompatibles() {
        List<Long> roomiesIds = new LinkedList<>();
        r2 = new Roomie("Leandro","Gomez",22,"leandro@leandro.com","12345","roomie",false);
        r2.setId(2L);
        /*List<RoomieAtributos> atributosRoomieDos = new LinkedList<>();
        RoomieAtributos ra = new RoomieAtributos(1L,Atributo.FUMADOR);
        ra.setId(8L);
        RoomieAtributos ra1 = new RoomieAtributos(1L,Atributo.DIURNO);
        ra.setId(9L);
        RoomieAtributos ra2 = new RoomieAtributos(1L,Atributo.GAMER);
        ra.setId(10L);
        RoomieAtributos ra3 = new RoomieAtributos(1L,Atributo.INCLUSIVO);
        ra.setId(11L);
        RoomieAtributos ra4 = new RoomieAtributos(1L,Atributo.VEGGIE);
        ra.setId(12L);

        atributosRoomieDos.add(ra);
        atributosRoomieDos.add(ra1);
        atributosRoomieDos.add(ra2);
        atributosRoomieDos.add(ra3);
        atributosRoomieDos.add(ra4);*/

        List<Atributo> atributosRoomieDos = new LinkedList<>();
        atributosRoomieDos.add(Atributo.FUMADOR);
        atributosRoomieDos.add(Atributo.DIURNO);
        atributosRoomieDos.add(Atributo.GAMER);
        atributosRoomieDos.add(Atributo.INCLUSIVO);
        atributosRoomieDos.add(Atributo.VEGGIE);

        when(repositorioEmparejamiento.obtenerRoomiePorId(2L)).thenReturn(r2);
        when(repositorioEmparejamiento.obtenerAtributosPorId(2L)).thenReturn(atributosRoomieDos);


        r3 = new Roomie("Emanuel","Gomez",24,"emanuel@emanuel.com","12345","roomie",false);
        r3.setId(3L);
        /*
        List<RoomieAtributos> atributosRoomieTres = new LinkedList<>();
        RoomieAtributos ra5 = new RoomieAtributos(1L,Atributo.FUMADOR);
        ra.setId(8L);
        RoomieAtributos ra6 = new RoomieAtributos(1L,Atributo.DIURNO);
        ra.setId(9L);
        RoomieAtributos ra7 = new RoomieAtributos(1L,Atributo.GAMER);
        ra.setId(10L);
        RoomieAtributos ra8 = new RoomieAtributos(1L,Atributo.VEGGIE);
        ra.setId(11L);

        atributosRoomieTres.add(ra5);
        atributosRoomieTres.add(ra6);
        atributosRoomieTres.add(ra7);
        atributosRoomieTres.add(ra8);*/

        List<Atributo> atributosRoomieTres = new LinkedList<>();
        atributosRoomieTres.add(Atributo.FUMADOR);
        atributosRoomieTres.add(Atributo.DIURNO);
        atributosRoomieTres.add(Atributo.GAMER);
        atributosRoomieTres.add(Atributo.VEGGIE);

        roomiesIds.add(r2.getId());
        roomiesIds.add(r3.getId());

        when(repositorioEmparejamiento.obtenerRoomiePorId(3L)).thenReturn(r3);
        when(repositorioEmparejamiento.obtenerAtributosPorId(3L)).thenReturn(atributosRoomieTres);

        when(repositorioEmparejamiento.obtenerIdRoomiesParaComparar(1L)).thenReturn(roomiesIds);
    }

    /*____________________________________CUANDO____________________________*/
    private List<Roomie> cuandoBuscoPorUnIDMeDevuelveUnaListaDeUsuariosCompatible() {
        return servicioEmparejamiento.obtenerRoomiesCompatibles(1L);
    }

    /*____________________________________ENTONCES____________________________*/
    private void entoncesLosRoomiesQueTrajoSonCompatiblesEnMasDeUn70Porciento(List<Roomie> roomiesCompatibles) {
        assertThat(roomiesCompatibles.size()).isEqualTo(2);
        assertThat(roomiesCompatibles.contains(r2)).isTrue();
        assertThat(roomiesCompatibles.contains(r3)).isTrue();
    }

}
