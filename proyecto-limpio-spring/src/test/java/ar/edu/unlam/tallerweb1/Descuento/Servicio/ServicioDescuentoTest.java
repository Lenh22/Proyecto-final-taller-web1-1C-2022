package ar.edu.unlam.tallerweb1.Descuento.Servicio;

import ar.edu.unlam.tallerweb1.modelo.Excepciones.RoomieSinDescuento;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioDescuento;
import ar.edu.unlam.tallerweb1.servicios.ServicioDescuento;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ServicioDescuentoTest{

    private RepositorioDescuento repositorioDescuento;
    private ServicioDescuento servicioDescuento;
    private Roomie roomie;
    private Roomie roomie2;
    private Roomie roomie3;
    private Roomie roomie4;
    private Roomie roomie5;



    @Before
    public void init(){
        repositorioDescuento = mock(RepositorioDescuento.class);
        servicioDescuento = new ServicioDescuento(repositorioDescuento);
        roomie = new Roomie();
        roomie2 = new Roomie();
        roomie3 = new Roomie();
        roomie4 = new Roomie();
        roomie5 = new Roomie();
    }

    @Test
    public void queSePuedaAplicarDescuentoAUnRoomieExistente(){
        String mail = roomie2.getEmail();
        String pass = roomie2.getPassword();
        dadoQueElRoomieQueAplicaADescuentoPuedaSerEncontrado(mail, pass);

        roomie2.setEstudiante(true);
        roomie2.setEdad(22);
        cuandoQuieroVerificarSiAplicaADescuento(roomie2);

        entoncesTieneQueDevolverTrue();
    }

    @Test(expected = RoomieSinDescuento.class)
    public void queNoSePuedaAplicarDescuentoAunRoomieExistenteQueNoSeaEstudiante(){
        String mail = roomie.getEmail();
        String pass = roomie.getPassword();
        dadoQueElRoomieQueAplicaADescuentoPuedaSerEncontrado2(mail, pass);

        cuandoQuieroVerificarSiNoAplicaADescuento(roomie2);

        //entoncesTieneQueDevolverFalse2();
    }

    @Test(expected = RoomieSinDescuento.class)
    public void queNoSePuedaAplicarDescuentoAunRoomieExistenteQueNoCumplaConRangoDeEdad(){
        String mail = roomie3.getEmail();
        String pass = roomie3.getPassword();
        dadoQueElRoomieQueAplicaADescuentoPuedaSerEncontrado3(mail, pass);

        cuandoQuieroVerificarSiNoAplicaADescuento3();

        entoncesTieneQueDevolverFalse2();
    }

    @Test(expected = RoomieSinDescuento.class)
    public void queNoSePuedaAplicarDescuentoAunRoomieExistenteQueNoCumplaConRangoDeEdadNiEsEstudiante(){
        String mail = roomie4.getEmail();
        String pass = roomie4.getPassword();
        dadoQueElRoomieQueAplicaADescuentoPuedaSerEncontrado4(mail, pass);

        cuandoQuieroVerificarSiNoAplicaADescuento4();

        entoncesTieneQueDevolverFalse();
    }

    @Test(expected = RoomieSinDescuento.class)
    public void queNoSePuedaEncontrarAUnRoomieYNoSePuedaAplicarDescuento(){
        String mail = roomie5.getEmail();
        String pass = roomie5.getPassword();
        dadoQueElRoomieQueAplicaADescuentoNoPuedaSerEncontrado(mail, pass);

        cuandoQuieroVerificarSiNoAplicaADescuento5();

        entoncesTieneQueDevolverExcepcion();
    }

    private void entoncesTieneQueDevolverExcepcion() {
        verify(servicioDescuento, never()).verificarAplicacionADescuento(roomie5);
    }

    private void cuandoQuieroVerificarSiNoAplicaADescuento5() {
        servicioDescuento.verificarAplicacionADescuento(roomie5);

    }

    private void dadoQueElRoomieQueAplicaADescuentoNoPuedaSerEncontrado(String mail, String pass) {
        when(repositorioDescuento.buscarRoomiePorMailyPass(mail, pass)).thenReturn(null);
    }

    private void entoncesTieneQueDevolverFalse3() {
        assertThat(servicioDescuento.verificarAplicacionADescuento(roomie4)).isEqualTo(false);
    }

    private void cuandoQuieroVerificarSiNoAplicaADescuento4() {
        roomie4.setEstudiante(false);
        roomie4.setEdad(30);
        servicioDescuento.verificarAplicacionADescuento(roomie4);
    }

    private void dadoQueElRoomieQueAplicaADescuentoPuedaSerEncontrado4(String mail, String pass) {
        when(repositorioDescuento.buscarRoomiePorMailyPass(mail, pass)).thenReturn(roomie4);
    }

    private void entoncesTieneQueDevolverFalse2() {
        assertThat(servicioDescuento.verificarAplicacionADescuento(roomie3)).isEqualTo(false);
    }

    private void dadoQueElRoomieQueAplicaADescuentoPuedaSerEncontrado3(String mail, String pass) {
        when(repositorioDescuento.buscarRoomiePorMailyPass(mail, pass)).thenReturn(roomie3);
    }

    private void cuandoQuieroVerificarSiNoAplicaADescuento3() throws RoomieSinDescuento{
        roomie3.setEstudiante(true);
        roomie3.setEdad(26);
        servicioDescuento.verificarAplicacionADescuento(roomie3);
        throw new RoomieSinDescuento();
    }

    private void dadoQueElRoomieQueAplicaADescuentoPuedaSerEncontrado2(String mail, String pass) {
        when(repositorioDescuento.buscarRoomiePorMailyPass(mail, pass)).thenReturn(roomie);
    }

    private void entoncesTieneQueDevolverFalse() {
        assertThat(servicioDescuento.verificarAplicacionADescuento(roomie)).isEqualTo(false);
    }

    private void cuandoQuieroVerificarSiNoAplicaADescuento(Roomie roomie) throws RoomieSinDescuento{
        roomie.setEstudiante(false);
        roomie.setEdad(22);
        servicioDescuento.aplicaDescuento(roomie);
        throw new RoomieSinDescuento();
    }

    private void entoncesTieneQueDevolverTrue() {
        assertThat(servicioDescuento.aplicaDescuento(roomie2)).isEqualTo(true);
    }

    private void cuandoQuieroVerificarSiAplicaADescuento(Roomie roomie) {
        servicioDescuento.verificarAplicacionADescuento(roomie);
    }

    private void dadoQueElRoomieQueAplicaADescuentoPuedaSerEncontrado(String mail, String pass) {
        when(repositorioDescuento.buscarRoomiePorMailyPass(mail, pass)).thenReturn(roomie2);
    }
}

