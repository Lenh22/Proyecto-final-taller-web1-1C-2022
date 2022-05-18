package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Atributo;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import org.apache.taglibs.standard.extra.spath.Path;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.TreeSet;

@Controller
public class ControladorEmparejamiento {

    //Pasamos primeramente el id que guardaremos en la vista apra despues consultarlo en la base de datos y devolverlo
    @RequestMapping(path="/home/{id}" ,method = RequestMethod.GET)
    public ModelAndView irAResultadoRoomieCompatibles(@PathVariable("id") Integer id) {
        //Agregar Service que haga la consulta que devuelva el usuario
        ModelMap map = new ModelMap();
        TreeSet< Atributo > atributos = new TreeSet<Atributo>();
        atributos.add(Atributo.FUMADOR);
        Roomie r2 = new Roomie();
        r2.setAtributos(atributos);

        try{
            map.put("RoomieEncontrado",r2);
        }catch (Exception exception){
            map.put("msg-error", "tipo inexistente");
        }
        ModelAndView mav = new ModelAndView("resultado-roomies-compatibles",map);
        return mav;
    }
}
