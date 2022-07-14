package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.IServicioDonaciones;
import ar.edu.unlam.tallerweb1.servicios.ServicioDonacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class ControladorDonaciones {

    private IServicioDonaciones servicioDeDonacion;
    private ServicioLogin servicioLogin;
    private Boolean pudoDonar = false;

    @Autowired
    public ControladorDonaciones(IServicioDonaciones servicioDeDonacion, ServicioLogin servicioLogin ) {
        this.servicioDeDonacion=servicioDeDonacion;
        this.servicioLogin=servicioLogin;
    }

    @RequestMapping(path = "/donatarios")
    public ModelAndView listar(Boolean recibe) {
        ModelMap model = new ModelMap();
        List<Roomie> resultado = null;
        try { //busco a los usuarioqe que tengan que reciben donación
            resultado = servicioDeDonacion.buscarDonatarios(recibe);
        }catch (Exception e){
            model.put("msg-error", "No hay Roomies que acepten donaciones");
        }
        model.put("donatarios", resultado);
        return new ModelAndView("donatarios", model);
    }
//Debo modificar los casos de prueba de servicios y acomodar mejor este metodo para que se vea el aumento en la billetera
    @RequestMapping(path = "/ver-billetera")
   public ModelAndView mostrarBilletera(String roomieDonatario) {
        ModelMap model = new ModelMap();
       //double billetera = servicioDeDonacion.billeteraDelRoomie(roomieDonatario);
       // model.put("billetera", billetera); //muestro un atributo
        //Podemos agregar otro model por ejemplo model.put("nombre", roomieDoanatari.getnombr..)
        return new ModelAndView("ver-billetera", model);
    }

    @RequestMapping("/darDonacion")
    public ModelAndView irADarDonacion() {
        ModelMap modelo = new ModelMap();
        modelo.put("DatosDonacion", new Roomie());
        return new ModelAndView("darDonacion", modelo);
    }
    @RequestMapping(path = "/darDonacionValidacion", method = RequestMethod.POST)
    public ModelAndView MensajeDeExito(@ModelAttribute ("DatosDonacion") DatosDonacion datos)
    {
        ModelMap model= new ModelMap();
        Roomie roomie = new Roomie();
        roomie.setEmail(datos.getEmail());
        double suma = servicioDeDonacion.incrementaBilletera(roomie, datos.getBilleteraDeDonaciones());

        if(servicioDeDonacion.darDonacion(datos.getEmail(), datos.getBilleteraDeDonaciones())) {
            model.put("email",datos.getEmail());
            model.put("error","Se dono correctamente al roomie");
            model.put("billetera",suma);
            return new ModelAndView("ver-billetera", model);

        }else{
            model.put("error","Los datos ingresados son incorrectos.");
        }
        return new ModelAndView("darDonacion",model);
    }
    @RequestMapping("/activarDonacion")
    public ModelAndView irAactivarDonacion() {
        ModelMap modelo = new ModelMap();
        modelo.put("datosLogin", new DatosLogin());
        return new ModelAndView("activarDonacion", modelo);
    }
    @RequestMapping(path = "/activarDonacionValidacion", method = RequestMethod.POST)
    public ModelAndView activarDonacion(@ModelAttribute("datosLogin") DatosLogin datosLogin, HttpServletRequest request) {
        ModelMap model = new ModelMap();
        Boolean activoDonacion = servicioDeDonacion.activarDonacion(datosLogin.getEmail(), datosLogin.getAceptodonacion());
        if (activoDonacion){
            model.put("email", datosLogin.getEmail());
            model.put("error", "se aplicaron los cambios");
            return new ModelAndView("activarDonacion", model);
        } else {
            model.put("error", "No se aplicaron los cambios");
        }
        return new ModelAndView("activarDonacion", model);

    }
}

