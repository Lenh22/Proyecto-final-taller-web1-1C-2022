package ar.edu.unlam.tallerweb1.Donaciones.Controlador;

import ar.edu.unlam.tallerweb1.controladores.ControladorDonaciones;
import ar.edu.unlam.tallerweb1.controladores.DatosDonacion;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.servicios.IServicioDonaciones;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorTest {

    public static final String MENSAJE_SIN_DONATARIO ="No hay Roomies que acepten donaciones";
    private ControladorDonaciones controladorDonaciones;
    private IServicioDonaciones servicioDeDonacion;

    private ServicioLogin servicioLogin;

    private DatosDonacion  datos = new DatosDonacion("mail", 100.0);
    public Double billeteraDeDonaciones = 5.0;
    public Roomie roomieDonatario2 = new Roomie("Maria", "Gonzalez", 20, "mail", "pass","rol",true, true, 50000.0,0.0, 0.0,billeteraDeDonaciones);

    public Boolean pudoDonar = true;

    public Double donacion = 102.0;

    public Double billeraCondonacion = donacion+billeteraDeDonaciones;

    @Before
    public void init(){
        //agregamos esto para inicializar servicio de donaciones
        servicioDeDonacion = mock(IServicioDonaciones.class);
        //mokito es una libreria para hacer test double
        //los mock no tienen estados, es una caja vacia que expone los mismo metodos
        //que definimos en servicios
        controladorDonaciones = new ControladorDonaciones(servicioDeDonacion, servicioLogin);
    }
    @Test

    public void listarRoomiesQueAceptenDonaciones() throws Exception {
        //prepracion

        dadoQueExisteUnaListaDeDonatarios (10, true);
        //ejecución

        ModelAndView mav = controladorDonaciones.listar(true);
        //verificacion

        entoncesEncuentro((List<Roomie>) mav.getModel().get("donatarios"), 10);

        entoncesMeLLevaALaVista("donatarios",mav.getViewName());

    }
    @Test
    public void validarQueSiSoloHayRoomieNoDonatarioLleveAPantallaDeDonatariosYMuestreMensaje() throws Exception {

        when(servicioDeDonacion.buscarDonatarios(false)).thenThrow(new Exception());

        ModelAndView mav = controladorDonaciones.listar(false);

        entoncesMeLLevaALaVista("donatarios", mav.getViewName());

        entoncesReciboElMensaje(MENSAJE_SIN_DONATARIO,mav.getModel());
    }

//entregar una funcionalidad propia del producto la cual lo distingue de otros producto
    //si te doy varios parametros
    //algo más del servicio y probar los caminos del servicio
    @Test
    public void QueAlPedirBilleteraDeUnUsuarioSeMuestre (){
        dadoQueExisteUndonatario (roomieDonatario2);
        //ejecución
        ModelAndView mav = controladorDonaciones.mostrarBilletera(roomieDonatario2.getEmail());
        //verificacion
        entoncesMeLLevaALaVista("ver-billetera",mav.getViewName());
    }


    @Test
    public void DarDonacion (){
        dadoQueExisteUndonatario (roomieDonatario2);
        datos.setEmail(roomieDonatario2.getEmail());
        datos.setBilleteraDeDonaciones(donacion);
        ModelAndView mav2 = ledoyUnaDonacion(datos.getEmail(),datos.getBilleteraDeDonaciones());
        entoncesLaBilleteraAhoraTiene (roomieDonatario2, donacion);
        entoncesMeLLevaALaVista("ver-billetera", mav2.getViewName());

    }



    private void entoncesReciboElMensaje(String mensajeDeExito, Map<String, Object> model) {
        assertThat(model.get("msg-error")).isEqualTo(mensajeDeExito);
    }


    private void entoncesMeLLevaALaVista(String vistaEsperada, String vistasRecibida) {
        assertThat(vistasRecibida).isEqualTo(vistaEsperada);

    }
    private void entoncesLaBilleteraAhoraTiene(Roomie roomieDonatario, Double donacion) {
        when(servicioDeDonacion.incrementaBilletera(roomieDonatario, donacion)).thenReturn(billeraCondonacion);
        servicioDeDonacion.incrementaBilletera(roomieDonatario, donacion);
    }


    private ModelAndView ledoyUnaDonacion(String roomieDonatario, Double donacion) {
        when(servicioDeDonacion.darDonacion(roomieDonatario, donacion)).thenReturn(pudoDonar);
      return controladorDonaciones.MensajeDeExito(datos);

    }

    private void dadoQueExisteUndonatario(Roomie roomieDonatario) {
        servicioDeDonacion.buscarDonatario(roomieDonatario);
        when(servicioDeDonacion.buscarDonatario(roomieDonatario)).thenReturn(roomieDonatario2);
    }

    private void dadoQueExisteUnaListaDeDonatarios(int catidadExistente, Boolean recibirDonacion) throws Exception {
        List<Roomie> lista = new LinkedList<>();

        for (int i =0; i<catidadExistente;i++){

            lista.add(new Roomie("nombre"+i, "apellido"+i, i, "email@email"+i+".com", "password", "rol",true, true, i,i,i,i));
        }
        when(servicioDeDonacion.buscarDonatarios(recibirDonacion)).thenReturn(lista);
    }

    private void entoncesEncuentro(List<Roomie> lista, int catidadEsperada) {
        assertThat(lista).hasSize(catidadEsperada);
    }

}
