package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;


import java.util.LinkedList;
import java.util.List;

public class ControladorDonaciones {
    //Lo agrego solo para entender controladores
    private static List<Roomie>lista = new LinkedList<>();
    public ControladorDonaciones(int catidadExistente) {

        for (int i = 0; i<catidadExistente; i++)
            lista.add(new Roomie("nombre","apellido",12,"mail","pass",true,10000,0.0,0.0,0.0));
    }

    //listarDonatarios
    public static ModelAndView listar() {
        ModelMap model = new ModelMap();
        model.put("donatarios", lista);
        ModelAndView modelAndView = new ModelAndView( "listadoDeDonatarios", model);

        //return new LinkedList<>();
        return modelAndView;
    }

    //tipo de retorno de una accion : datos+vista (model+vista)
}
