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

/*
    @Test
    @Transactional
    @Rollback
    public void queSePuedaEncontrarUnAlquilerDisponiblePorId()
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
    private void dadoQueExisteUnaListaDeAlquileres() {
        Vivienda vivienda1 = new Vivienda();
        Vivienda vivienda2 = new Vivienda();
        Vivienda vivienda3 = new Vivienda();
        Vivienda vivienda4 = new Vivienda();
        Vivienda vivienda5 = new Vivienda();
        Vivienda vivienda6 = new Vivienda();

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
    }*/
}

