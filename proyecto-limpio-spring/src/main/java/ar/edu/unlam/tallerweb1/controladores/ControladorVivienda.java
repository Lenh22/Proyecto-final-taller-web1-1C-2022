package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Propietario;
import ar.edu.unlam.tallerweb1.modelo.Vivienda;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioPropietario;
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
    private IServicioPropietario servicioPropietario;

    @Autowired
    public ControladorVivienda(IServicioVivienda servicioVivienda, IServicioPropietario servicioPropietario){
        this.servicioVivienda = servicioVivienda;
        this.servicioPropietario = servicioPropietario;
    }

    @RequestMapping(path = "/ir-perfil-vivienda/{id}")
    public ModelAndView irAPerfilVivienda(@PathVariable("id") int idVivienda) {
        ModelMap model = new ModelMap();

        Vivienda vivienda = servicioVivienda.obtenerViviendaPorId(idVivienda);
        model.put("vivienda", vivienda);
        return new ModelAndView("perfil-vivienda",model);
    }

    @RequestMapping(path = "/agregar-vivienda")
    public ModelAndView irAgregarVivienda() {
        ModelMap map = new ModelMap();
        map.put("datosVivienda",new Vivienda());
        return new ModelAndView("agregar-vivienda",map);
    }

    @RequestMapping(path = "/agregar-vivienda",method = RequestMethod.POST)
    public ModelAndView AgregarVivienda(@ModelAttribute("datosVivienda") Vivienda vivienda, HttpServletRequest request) {
        ModelMap map = new ModelMap();
        Long id = (long)request.getSession().getAttribute("id");
        Propietario propietario = servicioPropietario.obtenerPorId(id);
        vivienda.setPropietario(propietario);
        servicioVivienda.guardarNuevaVivienda(vivienda);
        List<Vivienda> viviendaList = servicioVivienda.obtenerListaViviendasPorIdPropietario(propietario);
        map.put("viviendas",viviendaList);
        return new ModelAndView("lista-alquileres-propietario",map);
    }

    @RequestMapping(path = "/ir-a-lista-alquileres-propietario")
    public ModelAndView irALista(HttpServletRequest request){
        ModelMap map = new ModelMap();
        Long id = (long)request.getSession().getAttribute("id");
        Propietario propietario = servicioPropietario.obtenerPorId(id);
        List<Vivienda> viviendaList = servicioVivienda.obtenerListaViviendasPorIdPropietario(propietario);
        if(viviendaList.isEmpty()){
            map.put("msg","Usted no contiene ningun alquiler publicado");
            return new ModelAndView("lista-alquileres-propietario",map);
        }
        map.put("viviendas",viviendaList);
        return new ModelAndView("lista-alquileres-propietario",map);
    }

    @RequestMapping(path = "/ir-a-eliminar-vivienda{idvivienda}")
    public ModelAndView irAEliminarVivienda(@PathVariable("idvivienda") int idVivienda, HttpServletRequest request){
        ModelMap map = new ModelMap();

        Vivienda vivienda = servicioVivienda.obtenerViviendaPorId(idVivienda);
        servicioVivienda.eliminarVivienda(vivienda);

        Long id = (long)request.getSession().getAttribute("id");
        Propietario propietario = servicioPropietario.obtenerPorId(id);
        List<Vivienda> viviendaList = servicioVivienda.obtenerListaViviendasPorIdPropietario(propietario);
        if(viviendaList.isEmpty()){
            map.put("msg","Usted no contiene ningun alquiler publicado");
            return new ModelAndView("lista-alquileres-propietario",map);
        }
        map.put("viviendas",viviendaList);
        return new ModelAndView("lista-alquileres-propietario",map);
    }

    @RequestMapping(path = "/ir-a-editar-vivienda{idvivienda}")
    public ModelAndView irAEditarVivienda(@PathVariable("idvivienda") int idVivienda, HttpServletRequest request){
        ModelMap map = new ModelMap();

        Vivienda vivienda = servicioVivienda.obtenerViviendaPorId(idVivienda);

        request.getSession().setAttribute("idVivienda",vivienda.getId());

        map.put("vivienda",vivienda);
        return new ModelAndView("editar-vivienda",map);
    }

    @RequestMapping(path = "/editar-vivienda")
    public ModelAndView EditarVivienda(@ModelAttribute("idvivienda") Vivienda vivienda, HttpServletRequest request){
        ModelMap map = new ModelMap();
        Long id = (long)request.getSession().getAttribute("id");
        Integer idVivienda = (int)request.getSession().getAttribute("idVivienda");
        Propietario propietario = servicioPropietario.obtenerPorId(id);

        vivienda.setId(idVivienda);
        vivienda.setPropietario(propietario);
        servicioVivienda.modificarVivienda(vivienda);

        List<Vivienda> viviendaList = servicioVivienda.obtenerListaViviendasPorIdPropietario(propietario);
        if(viviendaList.isEmpty()){
            map.put("msg","Usted no contiene ningun alquiler publicado");
            return new ModelAndView("lista-alquileres-propietario",map);
        }
        map.put("viviendas",viviendaList);
        return new ModelAndView("lista-alquileres-propietario",map);
    }



}
