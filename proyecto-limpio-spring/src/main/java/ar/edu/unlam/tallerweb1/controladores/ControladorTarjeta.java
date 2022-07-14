package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.DatosRecibidosPorPost.DatosTarjeta;
import ar.edu.unlam.tallerweb1.modelo.Tarjeta;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioTarjeta;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioVivienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorTarjeta {
    private IServicioTarjeta servicioTarjeta;
    private IServicioVivienda servicioVivienda;

    @Autowired
    public  ControladorTarjeta(IServicioTarjeta servicioTarjeta1,IServicioVivienda servicioVivienda){
        this.servicioTarjeta = servicioTarjeta1;
        this.servicioVivienda= servicioVivienda;
    }

    @RequestMapping(path = "/tarjeta/${id}")
    public ModelAndView tarjeta(@PathVariable("id") long idVivienda, HttpServletRequest request){
        ModelMap modelMap = new ModelMap();
        long id = (long) request.getSession().getAttribute("id");
        int precio = servicioVivienda.obtenerPrecioPorId(idVivienda);
        Tarjeta tarjetaBuscada = servicioTarjeta.obtenerTarjetaRoomie(id);
        modelMap.put("datosTarjeta", tarjetaBuscada);
        modelMap.put("precio",precio);
        return  new ModelAndView("tarjeta",modelMap);
    }

    @RequestMapping(path = "/pagar", method = RequestMethod.POST)
    public ModelAndView pagar(@ModelAttribute("datosTarjeta") DatosTarjeta datosTarjeta){
        ModelMap modelMap = new ModelMap();
        Tarjeta tarjetaBuscada = servicioTarjeta.consultarTarjeta(datosTarjeta.getNumeroTarjeta());
        if(tarjetaBuscada!=null){
            modelMap.put("Mensaje","Pagado exitoso");
            return new ModelAndView("redirect:/home",modelMap);
        }else{
            modelMap.put("Mensaje","Tarjeta inexistente");
            return new ModelAndView("redirect:/tarjeta");
        }
    }
}