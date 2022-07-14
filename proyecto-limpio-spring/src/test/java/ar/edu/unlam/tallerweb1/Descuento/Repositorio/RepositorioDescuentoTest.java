package ar.edu.unlam.tallerweb1.Descuento.Repositorio;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioDescuento;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioDescuentoTest extends SpringTest {

    @Autowired
    RepositorioDescuento repositorioDescuento;
    Roomie roomie1 = new Roomie();


    @Test @Rollback @Transactional
    public void queSePuedaEncontrarUnRoomiePorEmailYPassword(){
        roomie1.setEmail("arami@arami.com");
        roomie1.setPassword("1234");
        session().save(roomie1);

        String mail = roomie1.getEmail();
        String pass = roomie1.getPassword();

        Usuario encontrado = repositorioDescuento.buscarRoomiePorMailyPass(mail, pass);

        assertThat(encontrado).isEqualTo(roomie1);
    }

    @Test @Transactional
    @Rollback
    public  void queDevuelvaUnaListaDeRoomiesConDescuentos(){

        dadoQueExisteUnaListaDeRoomiesQueAplicaronAlDescuento();

        List<Roomie> encontrados= entoncesQueMeRetorneLaLista();

        entoncesVerificoLaLista(encontrados);
    }

    private void entoncesVerificoLaLista(List<Roomie> encontrados) {
        assertThat(encontrados.size()).isEqualTo(6);
    }

    private List<Roomie> entoncesQueMeRetorneLaLista() {
        return repositorioDescuento.ObtenerRoomiesConDescuento();
    }

    private void dadoQueExisteUnaListaDeRoomiesQueAplicaronAlDescuento() {
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
            repositorioDescuento.AgregarRoomieConDescuento(romie);
        }

    }
}
