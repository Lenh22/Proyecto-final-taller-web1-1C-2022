package ar.edu.unlam.tallerweb1.Puntuacion.servicio;

import ar.edu.unlam.tallerweb1.modelo.Excepciones.UsuarioExistente;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioPuntuaciones;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioPuntuaciones;
import ar.edu.unlam.tallerweb1.servicios.ServicioPuntuacion;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ServicioTest {

    /*private IRepositorioPuntuaciones repositorioUsuario;
    private IServicioPuntuaciones servicioPuntuacion;
    private String mail = "maria@maria.com";
    private String pass = "12345";
    private Roomie roomie2 = new Roomie("Maria", "Gonzalez", 20, mail, pass, "", true);
    private Boolean puntuacion = true;



    @Before
    public void init(){
        repositorioUsuario = mock(IRepositorioPuntuaciones.class);
        servicioPuntuacion = new ServicioPuntuacion(repositorioUsuario);
    }

    @Test
    public void queSePuedaPuntuarAUnRoomieExistenteyVerPuntuacion(){
        dadoQueExisteElRoomie(roomie2);

        cuandoQuieroPuntuarlo(puntuacion);

        entoncesPuedoVerElPuntajeTotal();
    }

    @Test (expected = UsuarioExistente.class)
    public void queNoSePuedaPuntuarAUnRoomieExistenteyVerPuntuacion(){
        dadoQueNoExisteElRoomie();

        cuandoQuieroPuntuarlo(puntuacion);

        entoncesNoPuedoVerElPuntajeTotal();
    }

    @Test
    public void queNoPuedaTenerPuntajeNegativo(){
        dadoQueExisteElRoomie(roomie2);

        cuandoQuieroPuntuarlo(false);

        entoncesELPuntajeTieneQueQuedarEnCero();

    }

    private void entoncesELPuntajeTieneQueQuedarEnCero() {
        assertThat(roomie2.getPuntaje()).isEqualTo(0.0);
    }

    private void dadoQueExisteElRoomie(Usuario roomie2) {
        when(repositorioUsuario.buscarUsuario(mail, pass)).thenReturn((Roomie) roomie2);
    }

    private void cuandoQuieroPuntuarlo(Boolean puntuacion) {
        servicioPuntuacion.puntuacionRoomie(roomie2, puntuacion);
    }

    private void entoncesPuedoVerElPuntajeTotal() {
        //when(servicioPuntuacion.puntuacionRoomie(roomie2, true)).thenReturn(1.0);
        assertThat(roomie2.getPuntaje()).isEqualTo(1.0);
    }
    private void entoncesNoPuedoVerElPuntajeTotal() {
        verify(servicioPuntuacion, times(0)).verPuntuacion(roomie2);
    }

    private void dadoQueNoExisteElRoomie() {
        when(repositorioUsuario.buscarUsuario(mail, pass)).thenReturn(null);
    }*/
}

