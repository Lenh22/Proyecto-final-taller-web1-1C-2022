package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.servicios.IServicioPuntuaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorPuntuaciones {
    private IServicioPuntuaciones servicioDePuntuacion;

    @Autowired
    public ControladorPuntuaciones(IServicioPuntuaciones servicioDePuntuacion) {
        this.servicioDePuntuacion = servicioDePuntuacion;
    }

    //MOSTRAR PUNTUACION
    @RequestMapping(path="/home/{puntaje}")
    //Las path variables entre "" indica a la variable nombrada en el .jsp
    //Por ende al crear la interfaz correspondiente, en la zona de puntuar, las variables
    //deberian llamarse "roomie" y "puntuacion"
    public ModelAndView MostrarPuntuacion(@PathVariable("roomie") Roomie roomie,
                                          @PathVariable ("puntuacion") Boolean puntuacion){

        ModelMap model = new ModelMap();
        Double puntaje = 0.0;
        //puntaje = servicioDePuntuacion.puntuacionRoomie(roomie, puntuacion);

        try{
            puntaje = servicioDePuntuacion.puntuacionRoomie(roomie, puntuacion);
        } catch (Exception e){
            model.put("msg-error", "no se puede mostrar puntuacion");
        }
        model.put("puntuacion", puntaje);
        //deberia crear una interfaz "ver-puntuacion", donde se muestren la puntuacion de un roomie.
        return new ModelAndView("ver-puntuacion", model);
    }

}

