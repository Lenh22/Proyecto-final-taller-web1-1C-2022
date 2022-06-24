package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Vivienda;
import ar.edu.unlam.tallerweb1.servicios.ServicioVivienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorVivienda {

    //id_vivienda,id_propietario ,direccion, id_alquiler, cantMax
    ServicioVivienda _servicioVivienda;
    @Autowired
    public  ControladorVivienda(ServicioVivienda servicioVivienda)
    {
        this._servicioVivienda= servicioVivienda;
    }

    @RequestMapping("viviendas")
    public ModelAndView viviendas(){
        ModelMap modelMap = new ModelMap();
        List<Vivienda> todasViviendas = _servicioVivienda.getViviendas();
        modelMap.put("todasViviendas",todasViviendas);
        return  new ModelAndView("viviendas",modelMap);
    }


}
