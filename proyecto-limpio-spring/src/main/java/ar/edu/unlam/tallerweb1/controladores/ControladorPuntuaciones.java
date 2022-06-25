package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.DatosPuntuar;
import ar.edu.unlam.tallerweb1.servicios.IServicioPuntuaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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

    //MOSTRAR PUNTUACION
    @RequestMapping(path = "ver-puntuacion") //, method = RequestMethod.POST)
    //Las path variables entre "" indica a la variable nombrada en el .jsp
    //Por ende al crear la interfaz correspondiente, en la zona de puntuar, las variables
    //deberian llamarse "roomie" y "puntuacion"
    public ModelAndView MostrarPuntuacion(@ModelAttribute("puntuacion") DatosPuntuar datos, HttpServletRequest request) {
        ModelMap model = new ModelMap();
        Double puntaje = 0.0;


        Roomie roomieBuscado = new Roomie();

        servicioDePuntuacion.saveRoomie(roomieBuscado);

        datos.setPuntuacion(roomieBuscado.getPuntuacion());
        datos.setId(roomieBuscado.getId());

        servicioDePuntuacion.consultarRoomie(datos.getId(), datos.getPuntuacion());

        if (roomieBuscado != null) {

            // request.getSession().setAttribute("puntaje", roomieBuscado.getPuntaje());
            puntaje = servicioDePuntuacion.verPuntaje(roomieBuscado);
            model.put("puntaje", puntaje);
            //return new ModelAndView("redirect:/ver-puntuacion");
           /* request.getSession().setAttribute("ROL", roomieBuscado.getRol());
            return new ModelAndView("redirect:/home");*/
        } else {
            model.put("msg-error", "El usuario buscado no existe");
        }
        return new ModelAndView("ver-puntuacion", model);
    }
}
// String viewName = "home";
/*
        Usuario usuarioBuscado = servicioDePuntuacion.bs(datosLogin.getEmail(), datosLogin.getPassword());
        if (usuarioBuscado != null) {
            request.getSession().setAttribute("ROL", usuarioBuscado.getRol());
            return new ModelAndView("redirect:/home");
        } else {
            // si el usuario no existe agrega un mensaje de error en el modelo.
            model.put("error", "Usuario o clave incorrecta");
        }
        return new ModelAndView("login", model);*/
//        try{
//            puntaje = servicioDePuntuacion.puntuacionRoomie(datos.getRoomie(), datos.getPuntuacion());
//            //viewName = "puntuar";
//        } catch (Exception e){
//            model.put("msg-error", "no se puede mostrar puntuacion");
//        }
//        model.put("puntuacion", puntaje);
//        //deberia crear una interfaz "ver-puntuacion", donde se muestren la puntuacion de un roomie.
//        return new ModelAndView("puntuar", model);
//    }
    /*
    * public ModelAndView MostrarPuntuacion(@PathVariable("roomie") Roomie roomie,
                                          @PathVariable ("puntuacion") Boolean puntuacion){
        ModelMap model = new ModelMap();
        Double puntaje = 0.0;
        String viewName = "home";

        try{
            puntaje = servicioDePuntuacion.puntuacionRoomie(roomie, puntuacion);
            viewName = "ver-puntuacion";
        } catch (Exception e){
            model.put("msg-error", "no se puede mostrar puntuacion");
        }
        model.put("puntuacion", puntaje);
        //deberia crear una interfaz "ver-puntuacion", donde se muestren la puntuacion de un roomie.
        return new ModelAndView(viewName, model);
    }
}*/

