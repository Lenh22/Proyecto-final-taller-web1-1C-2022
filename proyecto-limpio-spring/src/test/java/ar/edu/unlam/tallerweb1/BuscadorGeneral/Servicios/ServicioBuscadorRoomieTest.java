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

        dadoQueExistenLosRoomies();

        roomies = cuandoQuieroListarlo();

        entoncesPuedoVerLaListaDeRoomies();
    }

    @Test
    public void queSePuedanListarPorFiltroRoomiesDisponibles(){

        dadoQueExistenLosRoomies();

        roomies = cuandoQuieroListarloPorFiltro();

        entoncesPuedoVerLaListaDeRoomiesFiltradas();
    }

    @Test (expected = UsuarioExistente.class)
    public void queNoSePuedaListarUnRoomieInexistente(){
        dadoQueNoExisteElRoomie(roomie2);

        roomies = cuandoNoQuieroListarlo();

        entoncesLaListaEstaVacia();
    }

    private void entoncesPuedoVerLaListaDeRoomiesFiltradas() {
        assertThat(servicioBuscador.ListarRoomiesPorFiltro2(nombre2)).isEqualTo(roomies);
    }

    private List<Usuario> cuandoQuieroListarloPorFiltro() {
        return servicioBuscador.ListarRoomiesPorFiltro2(nombre2);
    }

    private List<Usuario> cuandoNoQuieroListarlo() throws UsuarioExistente{
        servicioBuscador.ListarAlquileres();
        throw new UsuarioExistente();
    }

    private void dadoQueExistenLosRoomies() {
        when(repositorioBuscador.buscarRoomie(nombre1)).thenReturn(roomie1);
        when(repositorioBuscador.buscarRoomie(nombre2)).thenReturn(roomie2);
        when(repositorioBuscador.buscarRoomie(nombre3)).thenReturn(roomie3);
        when(repositorioBuscador.buscarRoomie(nombre4)).thenReturn(roomie4);
    }

    private List<Usuario> cuandoQuieroListarlo() {
        return servicioBuscador.ListarRoomies();
    }

    private void entoncesPuedoVerLaListaDeRoomies() {
        assertThat(servicioBuscador.ListarRoomies()).isEqualTo(roomies);
    }

    private void entoncesLaListaEstaVacia() {
        assertThat(servicioBuscador.ListarRoomies()).isEqualTo(roomies);
    }

    private void dadoQueNoExisteElRoomie(Roomie roomie){
        when(repositorioBuscador.buscarRoomie(roomie.getNombre())).thenReturn(null);
    }
}
