package ar.edu.unlam.tallerweb1.SistemaDeDenuncia.Servicio;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.repositorios.IRepositorioRoomie;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.servicios.IServicioDenuncia;
import ar.edu.unlam.tallerweb1.servicios.ServicioDenuncia;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioTest {

    private IRepositorioRoomie repositorioRoomies;

    private RepositorioUsuario repositorioUsuario;
    private IServicioDenuncia servicioDenuncia;

    private String mail = "maria@maria.com";

    private String pass ="123";

    private Roomie roomie2 = new Roomie("Maria", "Gonzalez", 20, mail, pass,"rol",true,true,1.0,1.0,1.0,1.0);


    @Before
    public void init(){
        repositorioRoomies = mock(IRepositorioRoomie.class);
        servicioDenuncia = new ServicioDenuncia(repositorioRoomies, repositorioUsuario);
    }
//Tengo que corregir el test porque no esta funcionando
    @Test
    public void cambiarEstado(){
        dadoQueExisteElUsuarioActivo();
        cuandoLoDenuncio();
        entoncesElestadoEsInactivo();
    }

    private void dadoQueExisteElUsuarioActivo() {
        roomie2.setRecibirDonacion(true);
        when(repositorioRoomies.ObtenerUnRoomie(mail)).thenReturn(roomie2);
        //return repositorioRoomies.ObtenerUnRoomie(mail);
    }

    private void cuandoLoDenuncio() {

        servicioDenuncia.cambiarEstado(roomie2.getEmail(), roomie2.getActivo());
    }

    private void entoncesElestadoEsInactivo() {

        assertThat(roomie2.activo()).isEqualTo(false);
    }


}
