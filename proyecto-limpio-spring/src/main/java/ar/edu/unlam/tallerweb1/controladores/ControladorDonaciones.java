package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.servicios.IServicioDonaciones;
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
    private Boolean pudoDonar = false;

    @Autowired
    public ControladorDonaciones(IServicioDonaciones servicioDeDonacion ) {
        this.servicioDeDonacion=servicioDeDonacion;
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
      //public ModelAndView mostrarBilletera(@PathVariable("email") DatosDonacion datos) {
        ModelMap model = new ModelMap();
        //Roomie roomie = servicioDeDonacion.buscarDonatario(datos.getEmail())
        double billetera = servicioDeDonacion.billeteraDelRoomie(roomieDonatario);
        //double billetera = servicioDeDonacion.incrementaBilletera(datos.getEmail(),datos.getBilleteraDeDonaciones());
        model.put("billetera", billetera); //muestro un atributo
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
        pudoDonar = servicioDeDonacion.darDonacion(datos.getEmail(), datos.getBilleteraDeDonaciones());

        if(pudoDonar) {
            model.put("email",datos.getEmail());
            model.put("billetera",datos.getBilleteraDeDonaciones());
            model.put("error","Se dono correctamente al roomie");
            return new ModelAndView("ver-billetera", model);

        }else{
            model.put("error","No existe el roomie, por favor revise el listado de donatarios");
        }
        return new ModelAndView("darDonacion",model);
    }

    /*@RequestMapping(path = "/darDonacionValidacion", method = RequestMethod.POST)
    //public ModelAndView MensajeDeExito(@ModelAttribute ("DatosDonacion") DatosDonacion datos)
      public ModelAndView MensajeDeExito(@ModelAttribute("DatonDonacion") String roomie, Double monto)
    {
        ModelMap model= new ModelMap();
        pudoDonar = servicioDeDonacion.darDonacion(roomie,monto);

        if(pudoDonar) {
            //model.put(String.valueOf(model),monto);
            return new ModelAndView("redirect:/home");
            //model.put("msg-error","se ha realizado donacion con exito");
        }else{
            model.put("msg-error","no se ha realizado donacion");
        }
        return new ModelAndView("darDonacion",model);
    }
   */

}

