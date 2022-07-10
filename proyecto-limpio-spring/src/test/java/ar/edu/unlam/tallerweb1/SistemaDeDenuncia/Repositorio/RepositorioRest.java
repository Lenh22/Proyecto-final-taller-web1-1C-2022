package ar.edu.unlam.tallerweb1.SistemaDeDenuncia.Repositorio;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRoomie;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioRest extends SpringTest {

    @Autowired
    RepositorioRoomie repositorioDonacion;

    @Test
    @Transactional
    @Rollback
    public void queSeActualiceElEstadoDelRoomie()
    {
        Roomie roomie1 = new Roomie();
        roomie1.setEmail("pepe@mail.com");
        roomie1.setActivo(false);
        session();
        session().save(roomie1);
        Roomie roomie2= repositorioDonacion.ObtenerUnRoomie(roomie1.getEmail());
        assertThat(roomie2.getActivo()).isEqualTo(false);
    }

}
