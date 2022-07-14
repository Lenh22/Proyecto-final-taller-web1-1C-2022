package ar.edu.unlam.tallerweb1.BuscadorGeneral.Repositorio;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Vivienda;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBuscador;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioBuscadorAlquilerTest extends SpringTest {

    @Autowired
    RepositorioBuscador repositorioBuscador;
    Vivienda vivienda1 = new Vivienda();
    Vivienda vivienda2 = new Vivienda();
    Vivienda vivienda3 = new Vivienda();
    Vivienda vivienda4 = new Vivienda();
    Vivienda vivienda5 = new Vivienda();
    Vivienda vivienda6 = new Vivienda();
    String direccion1 = "calle 1";
    String direccion2 = "calle 1";
    String direccion3 = "calle 2";
    String direccion4 = "calle 3";
    String direccion5 = "calle 4";
    String direccion6 = "calle 1";


    @Test
    @Transactional
    @Rollback
    public void queSePuedaEncontrarUnAlquilerDisponiblePorDireccion()
    {
        Vivienda vivienda = new Vivienda();
        vivienda.setVivienda(1);
        vivienda.setDireccion("calle 1");
        repositorioBuscador.AgregarAlquiler(vivienda);
        Vivienda encontrada = repositorioBuscador.buscarAlquiler(vivienda.getDireccion());

        assertThat(encontrada).isEqualTo(vivienda);
    }

    @Test @Transactional
    @Rollback
    public  void queDevuelvaUnaListaDeViviendasEnAlquileres(){

        dadoQueExisteUnaListaDeAlquileres();

        List<Vivienda> encontrados= entoncesQueMeRetorneLaLista();

        entoncesVerificoLaLista(encontrados);
    }

    @Test @Transactional
    @Rollback
    public  void queDevuelvaUnaListaDeViviendasEnAlquileresPorFiltro(){

        dadoQueExisteUnaListaDeAlquileres();

        vivienda1.setDireccion(direccion1);
        vivienda2.setDireccion(direccion2);
        vivienda3.setDireccion(direccion3);
        vivienda4.setDireccion(direccion4);
        vivienda5.setDireccion(direccion5);
        vivienda6.setDireccion(direccion6);

        List<Vivienda> encontrados= entoncesQueMeRetorneLaListaPorFiltro();

        entoncesVerificoLaListaFiltrada(encontrados);
    }

    private void entoncesVerificoLaListaFiltrada(List<Vivienda> encontrados) {
        assertThat(encontrados.size()).isEqualTo(3);
    }

    private List<Vivienda> entoncesQueMeRetorneLaListaPorFiltro() {
        return repositorioBuscador.ObtenerAlquileresPorFiltro2(direccion2);
    }

    private void dadoQueExisteUnaListaDeAlquileres() {

        List<Vivienda> lista = new LinkedList<>();
        lista.add(vivienda1);
        lista.add(vivienda2);
        lista.add(vivienda3);
        lista.add(vivienda4);
        lista.add(vivienda5);
        lista.add(vivienda6);

        for (Vivienda vivienda : lista) {
            repositorioBuscador.AgregarAlquiler(vivienda);
        }
    }

    private List<Vivienda> entoncesQueMeRetorneLaLista() {
        return repositorioBuscador.ObtenerAlquileres();
    }

    private void entoncesVerificoLaLista(List<Vivienda> encontrados) {
        assertThat(encontrados.size()).isEqualTo(6);
    }
}

