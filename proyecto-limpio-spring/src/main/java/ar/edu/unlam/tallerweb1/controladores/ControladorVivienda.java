package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Vivienda;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioVivienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorVivienda {

    private IServicioVivienda servicioVivienda;

    @Autowired
    public ControladorVivienda(IServicioVivienda servicioVivienda){
        this.servicioVivienda = servicioVivienda;
    }

    @RequestMapping(path = "/ir-perfil-vivienda/{id}")
    public ModelAndView irAPerfilVivienda(@PathVariable("id") int idVivienda) {
        ModelMap model = new ModelMap();

        Vivienda vivienda = servicioVivienda.obtenerViviendaPorId(idVivienda);
        model.put("vivienda", vivienda);
        return new ModelAndView("perfil-vivienda",model);

    }
}
