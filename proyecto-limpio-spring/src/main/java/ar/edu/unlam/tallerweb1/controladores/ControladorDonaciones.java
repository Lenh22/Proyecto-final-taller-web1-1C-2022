package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import java.util.LinkedList;
import java.util.List;

@Controller
public class ControladorDonaciones {
    //Lo agrego solo para entender controladores
    private static List<Roomie>lista = new LinkedList<>();
    public ControladorDonaciones(int catidadExistente) {

        for (int i = 0; i<catidadExistente; i++)
            lista.add(new Roomie("nombre","apellido",12,"mail","pass",true,10000,0.0,0.0,0.0));
    }

    /*listarDonatarios, como no va a devolver un donatario especifico no pongo el path como variable
    y no hace falta agregar el pathVariable
    */
    /*podriamos agregar que vaya a la página /donatarios/email cuando selecione un usuario del listado?
    asi puede darle una donacion

     */


    @RequestMapping(path= "/home/donatarios" )//por default es get
    public static ModelAndView listar() {
        ModelMap model = new ModelMap();
        model.put("donatarios", lista);
        ModelAndView modelAndView = new ModelAndView( "listadoDeDonatarios", model);

        //return new LinkedList<>();
        return modelAndView;
    }


    //tipo de retorno de una accion : datos+vista (model+vista)
}
