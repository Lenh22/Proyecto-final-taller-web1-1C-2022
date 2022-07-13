package ar.edu.unlam.tallerweb1.Emparejamiento.Repositorio;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioEmparejamiento;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioTest extends SpringTest {
    @Autowired
    RepositorioEmparejamiento repositorioRoomie;

    /*____________________________________TEST____________________________*/
    @Test @Transactional @Rollback
    public void queSePuedaGuardarUnRoomie()
    {
        Roomie roomie1 = new Roomie();
        roomie1.setEmail("len@gmail.com");
        session().save(roomie1);
        Roomie roomie2= repositorioRoomie.obtenerRoomiePorId(roomie1.getId());
        assertThat(roomie2).isEqualTo(roomie1);
    }

    @Test @Transactional @Rollback
    public  void queDevuelvaUnaListaDeRoomie(){
        dadoQueExisteUnaListaDeRoomie();
        List<Roomie> encontrados= entoncesQueMeRetorneLaLista();
        entoncesVerificoLaLista(encontrados);
    }

    @Test @Transactional @Rollback
    public void queMeDevuelvaLosIdDeLosRoomieMenosElLogueado(){
        dadoQueExisteUnUsuarioLogueado();
        dadoQueExistenMasUsuarios();

        List<Long> idDeRoomies = cuandoConsultoEnLaBaseMeDevuelveUnaListaDeIds();

        entoncesTengoLaListaDeIdDeDosRoomiesRegistrados(idDeRoomies);
    }

    /*____________________________________DADO____________________________*/
    private void dadoQueExisteUnaListaDeRoomie() {
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
            repositorioRoomie.agregarRoomie(romie);
        }
    }

    private void dadoQueExisteUnUsuarioLogueado() {
        Roomie r1 = new Roomie("Ariel","Gomez",22,"ariel@ariel.com","12345","roomie",false);
        repositorioRoomie.agregarRoomie(r1);
    }

    private void dadoQueExistenMasUsuarios() {
        Roomie r2 = new Roomie("Leandro","Gomez",22,"leandro@leandro.com","12345","roomie",false);
        Roomie r3 = new Roomie("Emanuel","Gomez",24,"emanuel@emanuel.com","12345","roomie",false);
        repositorioRoomie.agregarRoomie(r2);
        repositorioRoomie.agregarRoomie(r3);
    }

    /*____________________________________CUANDO____________________________*/
    private List<Long> cuandoConsultoEnLaBaseMeDevuelveUnaListaDeIds() {
        return repositorioRoomie.obtenerIdRoomiesParaComparar(1L);
    }

    /*____________________________________ENTONCES____________________________*/
    private void entoncesVerificoLaLista(List<Roomie> encontrados) {
        assertThat(encontrados.size()).isEqualTo(6);
    }

    private List<Roomie> entoncesQueMeRetorneLaLista() {
        return repositorioRoomie.obtenerRoomies();
    }

    private void entoncesTengoLaListaDeIdDeDosRoomiesRegistrados(List<Long> idDeRoomies) {
        assertThat(idDeRoomies.size()).isEqualTo(2);
        assertThat(idDeRoomies.get(0)).isEqualTo(2L);
        assertThat(idDeRoomies.get(1)).isEqualTo(3L);

    }

}
