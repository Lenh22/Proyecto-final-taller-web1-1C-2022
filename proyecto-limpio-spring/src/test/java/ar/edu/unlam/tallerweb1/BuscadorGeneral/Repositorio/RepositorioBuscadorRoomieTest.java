package ar.edu.unlam.tallerweb1.BuscadorGeneral.Repositorio;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBuscador;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioBuscadorRoomieTest extends SpringTest {

    @Autowired
    RepositorioBuscador repositorioBuscador;


    @Test
    @Transactional
    @Rollback
    public void queSePuedaEncontrarUnRoomieDisponiblePorNombre()
    {
        Roomie roomie = new Roomie();
        roomie.setNombre("arami");
        repositorioBuscador.AgregarRoomie(roomie);
        Roomie encontrado = repositorioBuscador.ObtenerUnRoomie(roomie.getNombre());

        assertThat(encontrado).isEqualTo(roomie);
    }

    @Test @Transactional
    @Rollback
    public  void queDevuelvaUnaListaDeRoomiesDisponibles(){

        dadoQueExisteUnaListaDeRoomies();

        List<Usuario> encontrados= entoncesQueMeRetorneLaLista();

        entoncesVerificoLaLista(encontrados);
    }
    private void dadoQueExisteUnaListaDeRoomies() {

        Roomie roomie1 = new Roomie();
        Roomie roomie2 = new Roomie();
        Roomie roomie3 = new Roomie();
        Roomie roomie4 = new Roomie();
        Roomie roomie5 = new Roomie();
        Roomie roomie6 = new Roomie();

        List<Roomie> lista = new LinkedList<>();
        lista.add(roomie1);
        lista.add(roomie2);
        lista.add(roomie3);
        lista.add(roomie4);
        lista.add(roomie5);
        lista.add(roomie6);

        for (Roomie roomie : lista) {
            repositorioBuscador.AgregarRoomie(roomie);
        }
    }

    private List<Usuario> entoncesQueMeRetorneLaLista() {
        return repositorioBuscador.ObtenerRoomies();
    }

    private void entoncesVerificoLaLista(List<Usuario> encontrados) {
        assertThat(encontrados.size()).isEqualTo(6);
    }
}


