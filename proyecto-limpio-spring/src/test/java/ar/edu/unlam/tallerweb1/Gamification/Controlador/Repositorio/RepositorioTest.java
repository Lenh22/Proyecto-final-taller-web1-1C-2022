package ar.edu.unlam.tallerweb1.Gamification.Controlador.Repositorio;


import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRoomie;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


public class RepositorioTest extends SpringTest {

    @Autowired
    RepositorioRoomie repositoriogamification;

    @Test
    @Transactional
    @Rollback
    public void probarQueSeActualiceElPuntaje(){
        Roomie roomie1 = new Roomie();
        roomie1.setEmail("pepe@mail.com");
        roomie1.setPuntajeGamification(3);
        roomie1.setCantidadDeDenuncias(2);
        roomie1.setBilleteraDeDonaciones(15.0);
        roomie1.setPuntaje(2.0);
        roomie1.setActivo(true);
        session();
        session().save(roomie1);
        assertThat(repositoriogamification.obtenerpuntajeGamification(roomie1.getEmail())).isEqualTo(3);
    }
}
