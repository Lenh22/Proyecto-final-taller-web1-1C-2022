package ar.edu.unlam.tallerweb1.Donaciones.Controlador;

import ar.edu.unlam.tallerweb1.controladores.ControladorDonaciones;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioDonaciones;
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

    public static final String MENSAJE_DE_EXITO ="se ha realizado donacion con exito";

    private ControladorDonaciones controladorDonaciones;
    private IServicioDonaciones servicioDeDonacion;

    public Double billeteraDeDonaciones = 5.0;
    public Roomie roomieDonatario2 = new Roomie("Maria", "Gonzalez", 20, "mail", "pass", true, 50000.0,0.0, 0.0,billeteraDeDonaciones);

    public Boolean pudoDonar = true;

    public Double donacion = 102.0;

    public Double billeraCondonacion = donacion+billeteraDeDonaciones;

    @Before
    public void init(){
        //agregamos esto para inicializar servicio de alimentos
        servicioDeDonacion = mock(IServicioDonaciones.class);
        //mokito es una libreria para hacer test double
        //los mock no tienen estados, es una caja vacia que expone los mismo metodos
        //que definimos en servicios
        controladorDonaciones = new ControladorDonaciones(servicioDeDonacion);
    }
    @Test

    public void listarRoomiesQueAceptenDonaciones() throws Exception {
        //prepracion

        dadoQueExisteUnaListaDeDonatarios (10, true);
        //ejecución

        ModelAndView mav = controladorDonaciones.listar(true);
        //verificacion

        entoncesEncuentro((List<Roomie>) mav.getModel().get("donatarios"), 10);

        entoncesMeLLevaALaVista("listadoDeDonatarios",mav.getViewName());

    }
    @Test
    public void validarQueSiSoloHayRoomieNoDonatarioLleveAPantallaDeDonatariosYMuestreMensaje() throws Exception {

        when(servicioDeDonacion.buscarDonatarios(false)).thenThrow(new Exception());

        ModelAndView mav = controladorDonaciones.listar(false);

        entoncesMeLLevaALaVista("listadoDeDonatarios", mav.getViewName());

        entoncesReciboElMensaje(MENSAJE_SIN_DONATARIO,mav.getModel());
    }


    @Test
    public void QueAlPedirBilleteraDeUnUsuarioSeMuestre (){
        dadoQueExisteUndonatario (roomieDonatario2);
        //ejecución
        ModelAndView mav = controladorDonaciones.mostrarBilletera(roomieDonatario2);
        //verificacion
        entoncesMeLLevaALaVista("ver-billetera",mav.getViewName());

    }

    @Test
    public void DarDonacion (){
        dadoQueExisteUndonatario (roomieDonatario2);
        ModelAndView mav = controladorDonaciones.mostrarBilletera(roomieDonatario2);
        ModelAndView mav2 = ledoyUnaDonacion(roomieDonatario2,donacion);
        entoncesLaBilleteraAhoraTiene (roomieDonatario2, donacion);
        entoncesMeLLevaALaVista("ver-billetera", mav.getViewName());
        entoncesReciboElMensaje(MENSAJE_DE_EXITO,mav2.getModel());
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

    private ModelAndView ledoyUnaDonacion(Roomie roomieDonatario, Double donacion) {
        when(servicioDeDonacion.darDonacion(roomieDonatario, donacion)).thenReturn(pudoDonar);
        return controladorDonaciones.mensajeDeExito(roomieDonatario,donacion);

    }

    private void dadoQueExisteUndonatario(Roomie roomieDonatario) {

        servicioDeDonacion.buscarDonatario(roomieDonatario);

        when(servicioDeDonacion.buscarDonatario(roomieDonatario)).thenReturn(roomieDonatario2);
    }


    private void dadoQueExisteUnaListaDeDonatarios(int catidadExistente, Boolean recibirDonacion) throws Exception {
        List<Roomie> lista = new LinkedList<>();

        for (int i =0; i<catidadExistente;i++){

            lista.add(new Roomie("nombre"+i, "apellido"+i, i, "email@email"+i+".com", "password", recibirDonacion, i,i,i,i));
        }
        when(servicioDeDonacion.buscarDonatarios(recibirDonacion)).thenReturn(lista);
    }


    private void entoncesEncuentro(List<Roomie> lista, int catidadEsperada) {
        assertThat(lista).hasSize(catidadEsperada);
    }

}
