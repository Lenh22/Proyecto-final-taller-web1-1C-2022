package ar.edu.unlam.tallerweb1.SistemaDeDenuncia;

import ar.edu.unlam.tallerweb1.controladores.ControladorDenuncia;
import ar.edu.unlam.tallerweb1.controladores.DatosDenuncia;
import ar.edu.unlam.tallerweb1.servicios.IServicioDenuncia;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class controladorDenunciaTest {

    private IServicioDenuncia servicioDenuncia;
    private Boolean estado =true;

    private DatosDenuncia datos = new DatosDenuncia ("ema@mail.com", estado );
    private ControladorDenuncia controladorDenuncia;
    private String email = "ema@mail.com";

    @Before
    public void init(){
        //agregamos esto para inicializar servicio de donaciones
        servicioDenuncia = mock(IServicioDenuncia.class);
        //mokito es una libreria para hacer test double
        //los mock no tienen estados, es una caja vacia que expone los mismo metodos
        //que definimos en servicios
        controladorDenuncia = new ControladorDenuncia(servicioDenuncia);
    }

    @Test
    public void CambiarElEstadoDeUnUsuario(){
        dadoQueExisteUnUsuarioActivo(datos.getEmail());
        ModelAndView mav2 =  cuandoLoDenuncio();
        entoncesAhoraTieneElEstado ();
        entoncesMeLLevaALaVista("denuncia", mav2.getViewName());
    }

    private void dadoQueExisteUnUsuarioActivo(String email) {
        servicioDenuncia.obtenerEstadoDelUsuario(email);
        when(servicioDenuncia.obtenerEstadoDelUsuario(email)).thenReturn(true);
    }

    private ModelAndView cuandoLoDenuncio() {
        when(servicioDenuncia.cambiarEstado(datos.getEmail(), datos.getEstado())).thenReturn(false);
        return controladorDenuncia.MensajeDeExito(datos);
    }

    private void entoncesAhoraTieneElEstado() {
        servicioDenuncia.obtenerEstadoDelUsuario(email);
        when(servicioDenuncia.obtenerEstadoDelUsuario(email)).thenReturn(false);
    }

    private void entoncesMeLLevaALaVista(String recibida, String esperada) {
        assertThat(recibida).isEqualTo(esperada);

    }



}


