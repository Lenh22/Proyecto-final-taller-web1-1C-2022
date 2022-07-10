package ar.edu.unlam.tallerweb1.Descuento.Controlador;

import ar.edu.unlam.tallerweb1.controladores.ControladorDescuentos;
import ar.edu.unlam.tallerweb1.modelo.DatosDescuento;
import ar.edu.unlam.tallerweb1.modelo.Excepciones.RoomieSinDescuento;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.servicios.ServicioDescuento;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

public class ControladorDescuentoTest{

    public ControladorDescuentos controladorDescuentos;
    public ServicioDescuento servicioDeDescuentos;
    private String mail = "maria@maria.com";
    private String pass = "12345";
    private Boolean estudiante = true;
    Integer edad = 22;
    public Roomie roomie2;
    public Boolean descuento = false;
    private Long id = 1L;
    public static final String VISTA_DESCUENTO = "validar-descuento";
    public static final String MENSAJE_TIPO_INVALIDO = "El usuario buscado no existe";
    private DatosDescuento datos;

    @Before
    public void init(){
        servicioDeDescuentos = mock(ServicioDescuento.class);
        controladorDescuentos = new ControladorDescuentos(servicioDeDescuentos);
        roomie2 = new Roomie();
        datos = new DatosDescuento();
    }

    @Test
    public void queAlPedirDescuentoDevuelvaDescuentoAplicado(){
        //prepracion
        dadoQueExisteRoomieConDescuento (mail, pass);

        //ejecución
        roomie2.setEdad(edad);
        roomie2.setEstudiante(estudiante);

        datos.setEmail(mail);
        datos.setPassword(pass);

        ModelAndView mav = mostrarDescuento(datos);

        //verificacion

        entoncesSeAplicaDescuento(roomie2);
        entoncesMeLLevaALaVista(VISTA_DESCUENTO,mav.getViewName());

    }

    @Test (expected = RoomieSinDescuento.class)
    public void alPedirPuntuacionInvalidaLleveAPantallaDeError(){

        dadoQueNoExisteUnRoomieQueApliqueAlDescuento();

        ModelAndView mav = mostrarDescuento(datos);

        entoncesNoSeAplicaDescuento(roomie2);
        entoncesMeLLevaALaVista(VISTA_DESCUENTO,mav.getViewName());
        //entoncesSeRecibeMensaje(MENSAJE_TIPO_INVALIDO, mav.getModel());
    }

    private void entoncesNoSeAplicaDescuento(Roomie roomie) {
//        descuento = servicioDeDescuentos.verificarAplicacionADescuento(roomie);
//        assertThat(descuento).isEqualTo(false);
        verify(servicioDeDescuentos, never()).verificarAplicacionADescuento(roomie);
    }

    private void dadoQueNoExisteUnRoomieQueApliqueAlDescuento() {
        when(servicioDeDescuentos.consultarRoomie(roomie2.getEmail(), roomie2.getPassword())).thenReturn(null);
    }

    private void entoncesSeRecibeMensaje(String mensaje, Map<String, Object> model) {
        assertThat(model.get("msg-error")).isEqualTo(mensaje);
    }

    private void entoncesSeAplicaDescuento(Roomie roomie) {
        descuento = servicioDeDescuentos.verificarAplicacionADescuento(roomie);
        assertThat(descuento).isEqualTo(true);
    }

    private ModelAndView mostrarDescuento(DatosDescuento datos) {
        return controladorDescuentos.MostrarDescuentoDisponible(datos);
    }

    private void dadoQueExisteRoomieConDescuento(String mail, String pass) {
        when(servicioDeDescuentos.consultarRoomie(mail, pass)).thenReturn(roomie2);
    }

    private void entoncesMeLLevaALaVista(String vistaEsperada, String vistasRecibida) {
        assertThat(vistaEsperada).isEqualTo(vistasRecibida);

    }
}
