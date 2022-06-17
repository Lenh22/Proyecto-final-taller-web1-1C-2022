package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.servicios.ServicioEmparejamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorEmparejamiento {

    private List<Roomie> roomiesCompatibles;
    private ServicioEmparejamiento servicioEmparejamiento;

    //Aplico inyeccion de dependencia con la anotacion Autowired, indicandole que el service tambien es un bean
    @Autowired
    public ControladorEmparejamiento(ServicioEmparejamiento servicioEmparejamiento){
        this.servicioEmparejamiento = servicioEmparejamiento;
    }

    //Pasamos primeramente el id que guardaremos en la vista apra despues consultarlo en la base de datos y devolverlo
    @RequestMapping(path="/home/{id}" ,method = RequestMethod.GET)
    public ModelAndView irAResultadoRoomieCompatibles(@PathVariable("id") Long id) {
        ModelMap map = new ModelMap();
        try{
            roomiesCompatibles = servicioEmparejamiento.obtenerRoomiesCompatibles(id);
        }catch (Exception exception){
            map.put("msg-error", "NOT FOUND 404");
            return new ModelAndView("resultado-roomies-compatibles",map);
        }
        if(roomiesCompatibles.isEmpty())
            map.put("sin-emparejamiento","No se encontro un roomie compatible para usted");
        else
            map.put("RoomieEncontrado",roomiesCompatibles);

        return new ModelAndView("resultado-roomies-compatibles",map);
    }
}
