package ar.edu.unlam.tallerweb1.Gamification.Controlador.Servicio;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.repositorios.IRepositorioRoomie;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.servicios.IServicioDeGamification;
import ar.edu.unlam.tallerweb1.servicios.ServicioDeGamification;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioTest {

    private IRepositorioRoomie repositorioRoomies;

    private RepositorioUsuario repositorioUsuario;

    private IServicioDeGamification servicioDeGamification;

    private String mail = "maria@maria.com";

    private String pass ="123";

    private Roomie roomie2;

    @Before
    public void init(){
        this.roomie2 = new Roomie("Maria", "Gonzalez", 20, mail, pass,"roomie",true,true,1.0,1.0,1.0,10.0,5,1);
        repositorioRoomies = mock(IRepositorioRoomie.class);
        servicioDeGamification = new ServicioDeGamification(repositorioRoomies);
    }

    @Test
    public void CalcularPuntaje(){
        dadoQueExiteUnUsuarioConDistintosValores();
        LeCalculoElPuntaje();
        entoncesTieneElSiguientePuntaje();
    }

    private void LeCalculoElPuntaje() {
        servicioDeGamification.ReCalcularPuntajeGamification(roomie2.getEmail());
    }

    private void entoncesTieneElSiguientePuntaje() {
        assertThat(roomie2.getPuntajeGamification()).isEqualTo(1);
    }

    private Roomie dadoQueExiteUnUsuarioConDistintosValores() {
        when(repositorioRoomies.ObtenerUnRoomie(mail)).thenReturn(roomie2);
        return repositorioRoomies.ObtenerUnRoomie(mail);
    }
}
