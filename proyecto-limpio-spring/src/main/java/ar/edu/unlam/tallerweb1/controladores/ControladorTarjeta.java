package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.DatosRecibidosPorPost.DatosTarjeta;
import ar.edu.unlam.tallerweb1.modelo.Tarjeta;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioTarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorTarjeta {
    private IServicioTarjeta servicioTarjeta;

    @Autowired
    public  ControladorTarjeta(IServicioTarjeta servicioTarjeta1){
        this.servicioTarjeta = servicioTarjeta1;
    }

    @RequestMapping(path = "/tarjeta")
    public ModelAndView tarjeta(){
        ModelMap modelMap = new ModelMap();
        modelMap.put("datosTarjeta", new DatosTarjeta());
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