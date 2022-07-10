package ar.edu.unlam.tallerweb1.Donaciones.Servicio;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.repositorios.IRepositorioRoomie;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRoomie;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.servicios.IServicioDonaciones;
import ar.edu.unlam.tallerweb1.servicios.ServicioDonacion;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioTest {

    private IRepositorioRoomie repositorioRoomies;
    private IServicioDonaciones servicioDeDonacion;
    private String mail = "pepe@mail.com";
    private String pass = "123";
    private Roomie roomie2 = new Roomie("Maria", "Gonzalez", 20, mail, pass,"rol",true,true,1.0,1.0,1.0,1.0);

    private Double donacion = 1.00;

    @Before
    public void init(){
        repositorioRoomies = mock(IRepositorioRoomie.class);
        servicioDeDonacion = new ServicioDonacion(repositorioRoomies);
    }
    @Test
    public void IncrementarBilletera() {
        DadoQueExisteDonatario(mail) ;
        CuandoHagoLaDonacion(mail,donacion);
        EntoncesAumentaBilletera(roomie2,donacion);
    }
    private void EntoncesAumentaBilletera(Roomie roomie, Double donacion) {
        assertThat(servicioDeDonacion.incrementaBilletera(roomie,donacion)).isEqualTo(3.00);
    }
    private void CuandoHagoLaDonacion(String rommie, Double donacion) {
        servicioDeDonacion.darDonacion(rommie,donacion);

    }
    private Roomie DadoQueExisteDonatario(String mail) {
        roomie2.setRecibirDonacion(true);
       when(repositorioRoomies.ObtenerUnRoomie(mail)).thenReturn(roomie2);
        return repositorioRoomies.ObtenerUnRoomie(mail);

    }
}
