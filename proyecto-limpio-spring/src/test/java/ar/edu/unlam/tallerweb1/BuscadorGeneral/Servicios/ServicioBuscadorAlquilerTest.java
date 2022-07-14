package ar.edu.unlam.tallerweb1.BuscadorGeneral.Servicios;

import ar.edu.unlam.tallerweb1.modelo.Excepciones.ViviendaExistente;
import ar.edu.unlam.tallerweb1.modelo.Vivienda;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBuscador;
import ar.edu.unlam.tallerweb1.servicios.ServicioBuscador;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ServicioBuscadorAlquilerTest {

    private RepositorioBuscador repositorioBuscador;
    private ServicioBuscador servicioBuscador;
    private Vivienda vivienda;
    private Vivienda vivienda2;
    private Vivienda vivienda3;
    private Vivienda vivienda4;
    private String direccion = "calle 2";
    private String direccion2 = "calle 2";
    private String direccion3 = "calle 3";
    private String direccion4 = "calle 4";
    private List<Vivienda> viviendas;


    @Before
    public void init(){
        repositorioBuscador = mock(RepositorioBuscador.class);
        servicioBuscador = new ServicioBuscador(repositorioBuscador);
        vivienda = new Vivienda();
        vivienda2 = new Vivienda();
        vivienda3 = new Vivienda();
        vivienda4 = new Vivienda();
        viviendas = new ArrayList<>();
    }

    @Test
    public void queSePuedanListarViviendasEnAlquiler(){

        vivienda.setDireccion(direccion);
        vivienda2.setDireccion(direccion2);
        vivienda3.setDireccion(direccion3);
        vivienda4.setDireccion(direccion4);

        dadoQueExistenLosAlquileres();

        List <Vivienda> viviendas = cuandoQuieroListarlo();

        entoncesPuedoVerLaListaDeAlquileres(viviendas);
    }

    @Test
    public void queSePuedanListarPorFiltroViviendasEnAlquiler(){

        vivienda.setDireccion(direccion);
        vivienda2.setDireccion(direccion2);
        vivienda3.setDireccion(direccion3);
        vivienda4.setDireccion(direccion4);

        dadoQueExistenLosAlquileres();

        List <Vivienda> viviendas = cuandoQuieroListarloPorFiltro(direccion);

        entoncesPuedoVerLaListaDeAlquileres(viviendas);
    }

    @Test (expected = ViviendaExistente.class)
    public void queNoSePuedaListarUnAlquilerInexistente(){
        dadoQueNoExisteElAlquiler(vivienda);

        cuandoNoQuieroListarlo();

        entoncesMeLanzaExcepcionYNoPuedoListarlo();
    }

    @Test (expected = ViviendaExistente.class)
    public void queNoSePuedaListarPorFiltroUnAlquilerInexistente(){
        dadoQueNoExisteElAlquiler(vivienda);

        cuandoNoQuieroListarloPorFiltro();

        entoncesMeLanzaExcepcionYNoPuedoListarloPorFiltro();
    }

    private void cuandoNoQuieroListarlo() throws ViviendaExistente{
        servicioBuscador.ListarAlquileres();
        throw new ViviendaExistente();

    }

    private void entoncesMeLanzaExcepcionYNoPuedoListarloPorFiltro() {
        assertThat(servicioBuscador.ListarAlquileresPorFiltro2(direccion)).hasSize(0);
    }

    private void cuandoNoQuieroListarloPorFiltro() throws ViviendaExistente {
        servicioBuscador.ListarAlquileresPorFiltro2(direccion);
        throw new ViviendaExistente();
    }

    private void dadoQueExistenLosAlquileres() {
        when(repositorioBuscador.buscarAlquiler(direccion4)).thenReturn(vivienda4);
        when(repositorioBuscador.buscarAlquiler(direccion3)).thenReturn(vivienda3);
        when(repositorioBuscador.buscarAlquiler(direccion2)).thenReturn(vivienda2);
        when(repositorioBuscador.buscarAlquiler(direccion)).thenReturn(vivienda);
    }

    private List<Vivienda> cuandoQuieroListarloPorFiltro(String direccion) {
        return servicioBuscador.ListarAlquileresPorFiltro2(direccion);
    }

    private List<Vivienda> cuandoQuieroListarlo() {
        return servicioBuscador.ListarAlquileres();
    }

    private void entoncesPuedoVerLaListaDeAlquileres(List<Vivienda> viviendas) {
        assertThat(servicioBuscador.ListarAlquileres()).isEqualTo(viviendas);
    }

    private void entoncesMeLanzaExcepcionYNoPuedoListarlo() {
        assertThat(servicioBuscador.ListarAlquileres()).hasSize(0);
    }

    private void dadoQueNoExisteElAlquiler(Vivienda vivienda){
        when(repositorioBuscador.buscarAlquiler(vivienda.getDireccion())).thenReturn(null);
    }
}
