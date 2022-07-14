package ar.edu.unlam.tallerweb1.Puntuacion.Persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPuntuacion;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


public class RepositorioTest extends SpringTest{


    /*@Autowired
    RepositorioPuntuacion repositorioPuntuacion;

    @Test
    @Transactional
    @Rollback
    public void queSePuedaGuardarUnRoomie()
    {
        Roomie roomie1 = new Roomie();
        roomie1.setEmail("len@gmail.com");
        session().save(roomie1);
        Roomie roomie2= repositorioPuntuacion.obtenerUnRoomie(roomie1.getEmail());
        assertThat(roomie2).isEqualTo(roomie1);
    }*/


}