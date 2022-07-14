package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Vivienda;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioAlquiler;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioVivienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorAlquiler {

    private IServicioAlquiler servicioAlquiler;

    @Autowired
    public ControladorAlquiler(IServicioAlquiler servicioAlquiler){
        this.servicioAlquiler = servicioAlquiler;
    }

}
