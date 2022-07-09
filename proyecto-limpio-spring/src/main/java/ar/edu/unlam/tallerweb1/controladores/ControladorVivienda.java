package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.DatoVivienda;
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

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ControladorVivienda {

    private IServicioVivienda servicioVivienda;
    @Autowired
    public  ControladorVivienda(IServicioVivienda servicioViviendas)
    {
        this.servicioVivienda = servicioViviendas;
    }

    @RequestMapping(path = "/viviendas")
    public ModelAndView viviendas(){
        ModelMap modelMap = new ModelMap();
        List<Vivienda> todasViviendas = servicioVivienda.getViviendas();
        modelMap.put("datosVivienda",todasViviendas);
        return  new ModelAndView("viviendas",modelMap);
    }
    @RequestMapping("/crearVivienda")
    public ModelAndView crearVivienda() {
        ModelMap modelo = new ModelMap();
        modelo.put("datosVivienda", new DatoVivienda());
        return new ModelAndView("crearVivienda", modelo);
    }
    @RequestMapping(value = "crearViviendaP", method = RequestMethod.POST)
    public  ModelAndView crearVivienda(@ModelAttribute("datosVivienda") DatoVivienda datoVivienda, HttpServletRequest request){
        ModelMap modelMap = new ModelMap();
        Vivienda vivienda= new Vivienda();

        vivienda.setDireccion(datoVivienda.getDireccion());
        vivienda.setCantidadMaximaRoomies(datoVivienda.getCantidadMaximaRoomies());

        servicioVivienda.crearVivienda(vivienda);
        modelMap.put("viviendaCreada",datoVivienda);

        return new ModelAndView("crearViviendaP", modelMap);

    }
    //Debe llevar a una vista con todos los parametros q tiene desde la bd
    @RequestMapping(path = "editar/{id}", method = RequestMethod.GET)
         public  ModelAndView editar(@PathVariable("id")int id ) {
        ModelMap modelMap = new ModelMap();
        Vivienda obtenerVivienda;
        try {
            obtenerVivienda = servicioVivienda.buscarViviendaPorId(id);
        } catch (Exception e) {
            modelMap.put("Mensaje", "Error");
            return new ModelAndView("viviendas", modelMap); //ver si es en viviendas
        }
        if (obtenerVivienda!=null)
            modelMap.put("paraEditar", obtenerVivienda);
        return  new ModelAndView("viviendas",modelMap);
    }
    //Crear Editado q mande los datos por post a la vista

    @RequestMapping(path = "borrar/{id}", method = RequestMethod.GET)
    public  ModelAndView borrar(@PathVariable("id")int id ){
        ModelMap modelMap = new ModelMap();
        Vivienda obtenerVivienda;
        try {
            obtenerVivienda = servicioVivienda.buscarViviendaPorId(id);
        } catch (Exception e) {
            modelMap.put("Mensaje", e.getMessage());
            return viviendas(); //ver si es en viviendas
        }
        if (obtenerVivienda!=null){
            servicioVivienda.borrarVivienda(obtenerVivienda);
            modelMap.put("Mensaje","Borrado exitoso");

        }
        return viviendas();
    }


}
