package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.IServicioDeGamification;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorGamifiction {
    private IServicioDeGamification servicioDeGamification;
    public ControladorGamifiction(IServicioDeGamification servicioDeGamification) {
        this.servicioDeGamification= servicioDeGamification;

    }

    @RequestMapping(path = "/home")
    public ModelAndView mostrarNivel(DatosGamification datos) {
        ModelMap model = new ModelMap();
        String resultado ="Roomiebasico";
        //try{
        resultado=servicioDeGamification.obtenerNivel(datos.getEmail());
        /*}catch (Exception e){
            model.put("msg-error", "No hay Roomies que acepten donaciones");
        }*/
        model.put("nivel", resultado);
        return new ModelAndView("home", model);
    }
    }

