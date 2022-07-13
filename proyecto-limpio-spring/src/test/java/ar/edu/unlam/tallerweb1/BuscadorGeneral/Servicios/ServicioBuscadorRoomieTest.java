package ar.edu.unlam.tallerweb1.BuscadorGeneral.Servicios;

import ar.edu.unlam.tallerweb1.modelo.Excepciones.UsuarioExistente;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBuscador;
import ar.edu.unlam.tallerweb1.servicios.ServicioBuscador;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ServicioBuscadorRoomieTest {

    private RepositorioBuscador repositorioBuscador;
    private ServicioBuscador servicioBuscador;
    private Roomie roomie1;
    private Roomie roomie2;
    private Roomie roomie3;
    private Roomie roomie4;
    private String nombre1 = "Arami";
    private String nombre2 = "Leandro";
    private String nombre3 = "Leandro";
    private String nombre4 = "Emanuel";
    private List<Usuario> roomies;

/*

    @Before
    public void init(){
        repositorioBuscador = mock(RepositorioBuscador.class);
        servicioBuscador = new ServicioBuscador(repositorioBuscador);
        roomie1 = new Roomie();
        roomie2 = new Roomie();
        roomie3 = new Roomie();
        roomie4 = new Roomie();
        roomies = new ArrayList<>();
    }

    @Test
    public void queSePuedanListarRoomiesDisponibles(){

        dadoQueExisteElRoomie(nombre1);
        dadoQueExisteElRoomie2(nombre2);
        dadoQueExisteElRoomie3(nombre3);
        dadoQueExisteElRoomie4(nombre4);

        roomies = cuandoQuieroListarlo(nombre1);
        roomies = cuandoQuieroListarlo(nombre2);
        roomies = cuandoQuieroListarlo(nombre3);
        roomies = cuandoQuieroListarlo(nombre4);

        entoncesPuedoVerLaListaDeRoomies();
    }

    @Test
    public void queNoSePuedaListarUnRoomieInexistente(){
        dadoQueNoExisteElRoomie(roomie2);

        entoncesElRoomieEstaVacio();
    }

    private void dadoQueExisteElRoomie(String nombre) {
        when(repositorioBuscador.ObtenerUnRoomie(nombre)).thenReturn(roomie1);

    }
    private void dadoQueExisteElRoomie4(String nombre4) {
        when(repositorioBuscador.ObtenerUnRoomie(nombre4)).thenReturn(roomie2);
    }

    private void dadoQueExisteElRoomie3(String nombre3) {
        when(repositorioBuscador.ObtenerUnRoomie(nombre3)).thenReturn(roomie3);
    }

    private void dadoQueExisteElRoomie2(String nombre2) {
        when(repositorioBuscador.ObtenerUnRoomie(nombre2)).thenReturn(roomie4);
    }

    private List<Usuario> cuandoQuieroListarlo(String nombre) {
        return servicioBuscador.ListarRoomies();
    }

    private void entoncesPuedoVerLaListaDeRoomies() {
        assertThat(servicioBuscador.getTotalRoomies()).isEqualTo(4);
    }

    private void entoncesElRoomieEstaVacio() {
        assertThat(roomie2.getNombre()).isEqualTo(null);
    }

    private void dadoQueNoExisteElRoomie(Roomie roomie) throws UsuarioExistente {
        when(repositorioBuscador.buscarRoomie(roomie.getNombre())).thenReturn(null);
    }*/
}
