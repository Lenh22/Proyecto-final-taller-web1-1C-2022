package ar.edu.unlam.tallerweb1.Puntuacion.Persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPuntuacion;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RepositorioTest extends SpringTest{


    @Autowired
    RepositorioPuntuacion repositorioPuntuacion;


    @Test
    @Transactional
    @Rollback
    public void queSePuedaEncontrarPuntuacionDeUnRoomie()
    {
        Roomie roomie1 = new Roomie();
        roomie1.setPuntuacion(true);
        session().save(roomie1);
        Usuario encontrado = repositorioPuntuacion.buscarRoomie(roomie1.getId(), true);
        assertThat(encontrado).isEqualTo(roomie1);
    }

    @Test
    @Transactional
    @Rollback
    public void queSePuedaEncontrarUnRoomiePorId()
    {
        Roomie roomie1 = new Roomie();
        session().save(roomie1);
        Usuario encontrado = repositorioPuntuacion.ObtenerUnRoomie(roomie1.getId());
        assertThat(encontrado).isEqualTo(roomie1);
    }

    @Test @Transactional
    @Rollback
    public  void queDevuelvaUnaListaDeRoomiesPuntuados(){

        dadoQueExisteUnaListaDeRoomiesPuntuados();

        List<Roomie> encontrados= entoncesQueMeRetorneLaLista();

        entoncesVerificoLaLista(encontrados);
    }

    private void entoncesVerificoLaLista(List<Roomie> encontrados) {
        assertThat(encontrados.size()).isEqualTo(6);
    }

    private List<Roomie> entoncesQueMeRetorneLaLista() {
        return repositorioPuntuacion.ObtenerRoomies();
    }

    private void dadoQueExisteUnaListaDeRoomiesPuntuados() {
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

        for (Roomie romie:lista) {
            repositorioPuntuacion.AgregarRoomiePuntuado(romie);
        }
    }
}