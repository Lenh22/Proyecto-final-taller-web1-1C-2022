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
        modelo.put("datos", new DatosBuscadorRoomie());
        return new ModelAndView("buscador-roomie", modelo);
    }

    @RequestMapping(path = "validar-buscador-roomie", method = RequestMethod.POST)
    public ModelAndView MostrarListaRoomies(@ModelAttribute("datos") DatosBuscadorRoomie datos) {
        ModelMap model = new ModelMap();

        try {
            List<Usuario> lista =  servicioDeBuscador.ListarRoomiesPorFiltro2(datos.getNombre());
            model.put("id", datos.getId());
            model.put("lista", lista);
        }catch (Exception e){
            model.put("error", "El usuario buscado no existe");
        }

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

        try {
            List<Vivienda> lista = servicioDeBuscador.ListarAlquileresPorFiltro2(datos.getDireccion());
            model.put("lista", lista);
        }catch (Exception e){
            model.put("error", "La vivienda buscada no existe");
        }

        return new ModelAndView("validar-buscador-alquiler", model);
    }
}
