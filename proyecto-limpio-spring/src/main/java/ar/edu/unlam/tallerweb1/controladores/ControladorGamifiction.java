package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioDeGamification;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorGamifiction {

    private IServicioDeGamification servicioDeGamification;
    private ServicioLogin servicioLogin;
    private  String resultado ="Roomiebasico";
    @Autowired
    public ControladorGamifiction(IServicioDeGamification servicioDeGamification) {
        this.servicioDeGamification=servicioDeGamification;
        this.servicioLogin=servicioLogin;
    }
    @RequestMapping(path = "/home")
    public ModelAndView mostrarNivel(@ModelAttribute("email") String email) {
        ModelMap model = new ModelMap();
        //try{
        servicioDeGamification.generarPuntajeGamification(email);
        resultado=servicioDeGamification.obtenerNivel(email); //nivel

        model.put("nivel", resultado);

        return new ModelAndView("home", model);
    }
}