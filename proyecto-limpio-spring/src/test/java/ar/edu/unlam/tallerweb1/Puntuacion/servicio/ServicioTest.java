package ar.edu.unlam.tallerweb1.Puntuacion.servicio;

import ar.edu.unlam.tallerweb1.modelo.Excepciones.UsuarioExistente;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPuntuacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPuntuacion;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ServicioTest {

    private RepositorioPuntuacion repositorioUsuario;
    private ServicioPuntuacion servicioPuntuacion;
    private String mail = "maria@maria.com";
    private String pass = "12345";
    private Roomie roomie2 = new Roomie("Maria", "Gonzalez", 20, mail, pass, "", true);
    private Boolean puntuacion = true;



    @Before
    public void init(){
        repositorioUsuario = mock(RepositorioPuntuacion.class);
        servicioPuntuacion = new ServicioPuntuacion(repositorioUsuario);
    }

    @Test
    public void queSePuedaPuntuarAUnRoomieExistenteyVerPuntuacion(){
        dadoQueExisteElRoomie(roomie2.getId());

        cuandoQuieroPuntuarlo(puntuacion);
        cuandoQuieroPuntuarlo(puntuacion);

        entoncesPuedoVerElPuntajeTotal();
    }

    @Test (expected = UsuarioExistente.class)
    public void queNoSePuedaPuntuarAUnRoomieNoExistenteyVerPuntuacion(){
        dadoQueNoExisteElRoomie();

        cuandoQuieroPuntuarlo(puntuacion);

        entoncesNoPuedoVerElPuntajeTotal();
    }

    @Test
    public void queNoPuedaTenerPuntajeNegativo(){
        dadoQueExisteElRoomie(roomie2.getId());

        cuandoQuieroPuntuarNegativo(false);
        cuandoQuieroPuntuarNegativo(false);
        cuandoQuieroPuntuarNegativo(false);
        cuandoQuieroPuntuarNegativo(false);
        cuandoQuieroPuntuarNegativo(false);


        entoncesELPuntajeTieneQueQuedarEnCero();

    }

    @Test
    public void queAlPuntuarPositivoYNegativoSoloCuenteLosPositivos(){
        dadoQueExisteElRoomie(roomie2.getId());

        cuandoQuieroPuntuarlo(true);
        cuandoQuieroPuntuarNegativo(false);
        cuandoQuieroPuntuarlo(true);
        cuandoQuieroPuntuarlo(true);
        cuandoQuieroPuntuarNegativo(false);


        entoncesELPuntajeTieneQueQuedarEnTres();

    }

    private void entoncesELPuntajeTieneQueQuedarEnTres() {
        assertThat(roomie2.getPuntaje()).isEqualTo(3.0);
    }

    private void cuandoQuieroPuntuarNegativo(boolean b) {
        servicioPuntuacion.puntuacionRoomie(roomie2.getId(), false);
    }

    private void entoncesELPuntajeTieneQueQuedarEnCero() {
        //when(servicioPuntuacion.puntuacionRoomie(roomie2, false)).thenReturn(0.0);
        assertThat(roomie2.getPuntaje()).isEqualTo(0.0);
    }

    private void dadoQueExisteElRoomie(Long id) {
        when(repositorioUsuario.ObtenerUnRoomie(id)).thenReturn(roomie2);

    }

    private void cuandoQuieroPuntuarlo(Boolean puntuacion) {
        servicioPuntuacion.puntuacionRoomie(roomie2.getId(), puntuacion);
    }

    private void entoncesPuedoVerElPuntajeTotal() {
        //when(servicioPuntuacion.puntuacionRoomie(roomie2, true)).thenReturn(1.0);
        assertThat(roomie2.getPuntaje()).isEqualTo(2.0);
    }
    private void entoncesNoPuedoVerElPuntajeTotal() {
        verify(servicioPuntuacion, never()).puntuacionRoomie(roomie2.getId(), roomie2.getPuntuacion());
    }

    private void dadoQueNoExisteElRoomie() {
        when(repositorioUsuario.buscarUsuario(mail, pass)).thenReturn(null);
    }
}

