package ar.edu.unlam.tallerweb1.controladores;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.DatosPuntuar;
import ar.edu.unlam.tallerweb1.servicios.IServicioPuntuaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorPuntuaciones {

    private IServicioPuntuaciones servicioDePuntuacion;

    @Autowired
    public ControladorPuntuaciones(IServicioPuntuaciones servicioDePuntuacion) {
        this.servicioDePuntuacion = servicioDePuntuacion;
    }

    @RequestMapping("/puntuar")
    public ModelAndView irAPuntuar() {
        ModelMap modelo = new ModelMap();
        modelo.put("puntuacion", new DatosPuntuar());
        return new ModelAndView("puntuar", modelo);
    }


    @RequestMapping(path = "ver-puntuacion", method = RequestMethod.POST)
    public ModelAndView MostrarPuntuacion(@ModelAttribute("puntuacion") DatosPuntuar datos) {
        ModelMap model = new ModelMap();
        Double puntaje = 0.0;

        Roomie roomieBuscado = new Roomie();
        roomieBuscado.setPuntuacion(datos.getPuntuacion());
        servicioDePuntuacion.consultarRoomie(datos.getId());
        try{
            puntaje = servicioDePuntuacion.puntuacionRoomie(datos.getId(), datos.getPuntuacion());
            model.put("id", datos.getId());
            model.put("puntaje", puntaje);
        }catch (Exception e){
            model.put("error", "El usuario buscado no existe");
        }
        return new ModelAndView("ver-puntuacion", model);
    }
}
