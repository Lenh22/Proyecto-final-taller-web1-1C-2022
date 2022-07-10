package ar.edu.unlam.tallerweb1.controladores;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.IServicioBuscador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControladorBuscador {

    private IServicioBuscador servicioDeBuscador;

    @Autowired
    public ControladorBuscador(IServicioBuscador servicioDeBuscador) {
        this.servicioDeBuscador = servicioDeBuscador;
    }

    @RequestMapping("/buscador-roomie")
    public ModelAndView irABuscadorRoomie() {
        ModelMap modelo = new ModelMap();
        List<Usuario> lista = servicioDeBuscador.ListarRoomies();
        modelo.put("datosBuscadorRoomie", lista);
        return new ModelAndView("buscador-roomie", modelo);
    }

    @RequestMapping(path = "validar-buscador-roomie", method = RequestMethod.POST)
    public ModelAndView MostrarListaRoomies(@ModelAttribute("datosBuscadorRoomie") DatosBuscadorRoomie datos) {
        ModelMap model = new ModelMap();
/*
        Roomie roomieBuscado = new Roomie();
        servicioDeBuscador.saveRoomie(roomieBuscado);
        roomieBuscado.setNombre(datos.getNombre());
       // servicioDeBuscador.consultarRoomie(datos.getNombre());

        if (roomieBuscado != null) {*/
            List<Usuario> lista =  servicioDeBuscador.ListarRoomiesPorFiltro(datos.getId());
            model.put("lista", lista);
       /* } else {
            model.put("msg-error", "El usuario buscado no existe");
        }*/
        return new ModelAndView("validar-buscador-roomie", model);
    }

    @RequestMapping("/buscador-alquiler")
    public ModelAndView irABuscadorAlquiler() {
        ModelMap modelo = new ModelMap();
        List<Vivienda> lista = servicioDeBuscador.ListarAlquileres();
        modelo.put("datosBuscadorAlquiler", lista);
        modelo.put("datos", new DatosBuscadorAlquiler());

        return new ModelAndView("buscador-alquiler", modelo);
    }

    @RequestMapping(path = "validar-buscador-alquiler", method = RequestMethod.POST)
    public ModelAndView MostrarListaAlquileres(@ModelAttribute("datos") DatosBuscadorAlquiler datos) {

        ModelMap model = new ModelMap();


       // Vivienda viviendaBuscada = servicioDeBuscador.buscarAlquilerPorDireccion(direccion.getDireccion());

       // if (viviendaBuscada != null) {
            //ACA SE DEBERIA LISTAR LOS ALQUILERES FILTRADOS
            List<Vivienda> lista = servicioDeBuscador.ListarAlquileresPorFiltro(datos.getId());
            model.put("lista", lista);
       // }
       /* if(viviendaBuscada == null){
            model.put("msg-error", "La vivienda buscada no existe");
        }*/
        return new ModelAndView("validar-buscador-alquiler", model);
    }
}
