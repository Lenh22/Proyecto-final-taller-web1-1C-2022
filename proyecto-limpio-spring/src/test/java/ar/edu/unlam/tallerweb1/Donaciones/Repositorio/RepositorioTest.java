package ar.edu.unlam.tallerweb1.Donaciones.Repositorio;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Roomie;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioRoomie;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioTest extends SpringTest {

    @Autowired
   RepositorioRoomie repositorioDonacion; //no deberiamos crear un repositorio solo de donaciones?


    @Test
    @Transactional
    @Rollback
    public void queSePuedaGuardarUnRoomie()
    {
        Roomie roomie1 = new Roomie();
        roomie1.setEmail("len@gmail.com");
        session();
        session().save(roomie1);
        Roomie roomie2= repositorioDonacion.ObtenerUnRoomie(roomie1.getEmail());
        assertThat(roomie2).isEqualTo(roomie1);
    }


    //Me parece innecesario este test cases, porque nosotros no vamos a modificar roomies
    /*
    @Test
    @Transactional
    @Rollback
    public void queSePuedaModificarUnRoomie()
    {
        Roomie roomie1 = new Roomie();
        roomie1.setEmail("len@gmail.com");
        repositorioDonacion.agregarRoomie(roomie1);
        roomie1.setEmail("lenn@gmail.com");
        repositorioDonacion.actualizar(roomie1);
        Roomie roomie2= repositorioDonacion.ObtenerUnRoomie(roomie1.getEmail());
        assertThat(roomie2.getEmail()).isEqualTo("lenn@gmail.com");
    }
*/

    @Test
    @Transactional
    @Rollback
    public  void queDevuelvaUnaListaDeRoomiesDonatarios(){
        List<Roomie> Donatarios = dadoQueExisteDonatarios();
        entoncesVerificoLaLista(Donatarios);
    }

    //Pruebo que se pueda modificar la billetera de un roomie
    @Test
    @Transactional
    @Rollback

    public void QueSeAumenteLaBilleteraDeUnRoomie(){
        Roomie donatario = new Roomie();
        donatario.setRecibirDonacion(true);
        repositorioDonacion.agregarRoomie(donatario);
        LeAumentoLaBilletera(donatario);
        EntoncesObtengo(donatario);

    }

    //Pruebo que se pueda modificar que un roomie acepte donaciones
    @Test
    @Transactional
    @Rollback
    public void queSePuedaSetearUnRoomieParaQueAcepteDonaciones(){
        Roomie roomie1 = new Roomie();
        roomie1.setEmail("len@gmail.com");
        roomie1.setRecibirDonacion(false);
        repositorioDonacion.agregarRoomie(roomie1);
        cuandoCambioQueReciboDonacions(roomie1);
        entoncesVerificoSiAhoraRecibeDonaciones(roomie1);

    }

    private void entoncesVerificoSiAhoraRecibeDonaciones(Roomie roomie1) {
        assertThat(roomie1.getRecibirDonacion()).isEqualTo(true);
    }

    private void cuandoCambioQueReciboDonacions(Roomie roomie1) {
        roomie1.setRecibirDonacion(true);
        repositorioDonacion.agregarRoomie(roomie1);
    }
    private void entoncesVerificoLaLista(List<Roomie> Donatarios) {
        assertThat(Donatarios.size()).isEqualTo(3);
    }

    private List<Roomie> dadoQueExisteDonatarios() {
        Roomie roomie1 = new Roomie();
        roomie1.setRecibirDonacion(true);
        session().save(roomie1);
        Roomie roomie2 = new Roomie();
        roomie2.setRecibirDonacion(true);
        session().save(roomie2);
        Roomie roomie3 = new Roomie();
        roomie3.setRecibirDonacion(true);
        session().save(roomie3);
        Roomie roomie4 = new Roomie();
        roomie4.setRecibirDonacion(false);
        session().save(roomie4);

        List<Roomie>donatarios = repositorioDonacion.ObtenerUnRoomiDonatario(true);
        return  donatarios;
    }
    private void EntoncesObtengo(Roomie donatario) {
        assertThat(donatario.getBilleteraDeDonaciones()).isEqualTo(100);
    }
    private void LeAumentoLaBilletera(Roomie donatario) {
        donatario.setBilleteraDeDonaciones(100);
        repositorioDonacion.actualizar(donatario);
    }
}
