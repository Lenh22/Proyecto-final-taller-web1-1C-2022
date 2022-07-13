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
/*
    private RepositorioBuscador repositorioBuscador;
    private ServicioBuscador servicioBuscador;
    private Vivienda vivienda;
    private Vivienda vivienda2;
    private Vivienda vivienda3;
    private Vivienda vivienda4;
    private String direccion = "calle 1";
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

        dadoQueExisteElAlquiler(direccion);
        dadoQueExisteElAlquiler2(direccion2);
        dadoQueExisteElAlquiler3(direccion3);
        dadoQueExisteElAlquiler4(direccion4);
/*
        cuandoQuieroListarlo(vivienda);
        cuandoQuieroListarlo2(vivienda2);
        cuandoQuieroListarlo3(vivienda3);
        cuandoQuieroListarlo4(vivienda4);*/
/*
        servicioBuscador.ListarAlquileres();

        entoncesPuedoVerLaListaDeAlquileres();
    }

    private void cuandoQuieroListarlo4(Vivienda vivienda4) {
        servicioBuscador.saveAlquiler(vivienda4);
        servicioBuscador.ListarAlquileres();
    }

    private void cuandoQuieroListarlo3(Vivienda vivienda3) {
        servicioBuscador.saveAlquiler(vivienda3);
        servicioBuscador.ListarAlquileres();
    }

    private void cuandoQuieroListarlo2(Vivienda vivienda2) {
        servicioBuscador.saveAlquiler(vivienda2);
        servicioBuscador.ListarAlquileres();
    }

    private void cuandoQuieroListarlo(Vivienda vivienda) {
        servicioBuscador.saveAlquiler(vivienda);
        servicioBuscador.ListarAlquileres();
    }

    private void dadoQueExisteElAlquiler4(String direccion4) {
        when(repositorioBuscador.buscarAlquiler(direccion4)).thenReturn(vivienda4);
    }

    private void dadoQueExisteElAlquiler3(String direccion3) {
        when(repositorioBuscador.buscarAlquiler(direccion3)).thenReturn(vivienda3);
    }

    private void dadoQueExisteElAlquiler2(String direccion2) {
        when(repositorioBuscador.buscarAlquiler(direccion2)).thenReturn(vivienda2);
    }
    private void dadoQueExisteElAlquiler(String direccion) {
        when(repositorioBuscador.buscarAlquiler(direccion)).thenReturn(vivienda);
    }

    private void entoncesPuedoVerLaListaDeAlquileres() {
        assertThat(servicioBuscador.getTotalViviendas()).isEqualTo(6);
    }

    @Test
    public void queNoSePuedaListarUnAlquilerInexistente(){
        dadoQueNoExisteElAlquiler(vivienda);

        cuandoQuieroListarlo(vivienda);

        entoncesMeLanzaExcepcionYNoPuedoListarlo();
    }

    private void entoncesMeLanzaExcepcionYNoPuedoListarlo() {
        assertThat(servicioBuscador.ListarAlquileres()).hasSize(0);
    }

    private void dadoQueNoExisteElAlquiler(Vivienda vivienda){
        when(repositorioBuscador.buscarAlquiler(vivienda.getDireccion())).thenReturn(null);
    }*/
}
