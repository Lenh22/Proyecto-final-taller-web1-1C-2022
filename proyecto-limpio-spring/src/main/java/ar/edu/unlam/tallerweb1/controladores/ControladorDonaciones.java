package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioDonaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorDonaciones {

    private IServicioDonaciones servicioDeDonacion;

    private Double billetera = 0.0;

    @Autowired
    public ControladorDonaciones(IServicioDonaciones servicioDeDonacion ) {
        this.servicioDeDonacion=servicioDeDonacion;

    }
    @RequestMapping(path = "home/donatarios")
    public ModelAndView listar(Boolean recibe) {
        ModelMap model = new ModelMap();
        List<Roomie> resultado = null;
        try { //busco a los usuarioqe que tengan que reciben donación
            resultado = servicioDeDonacion.buscarDonatarios(recibe);
        }catch (Exception e){
            model.put("msg-error", "No hay Roomies que acepten donaciones");
        }
        model.put("donatarios", resultado);
        return new ModelAndView("listadoDeDonatarios", model);
    }

    //@RequestMapping(path = "home/{email}")
    public ModelAndView mostrarBilletera(@PathVariable("roomie") Roomie roomieDonatario) {
        double billetera = 0.0;
        ModelMap model = new ModelMap();
        billetera = servicioDeDonacion.billeteraDelRoomie(roomieDonatario);
        model.put("billetera", billetera); //muestro un atributo
        return new ModelAndView("ver-billetera", model);

    }

   //@RequestMapping(path = "home/{email}")
    public ModelAndView mensajeDeExito(Roomie donatario, Double monto) {

        ModelMap model= new ModelMap();

        if(servicioDeDonacion.darDonacion(donatario,monto)) {

            model.put("msg-error","se ha realizado donacion con exito");
        }else{
            model.put("msg-error","no se ha realizado donacion");
        }

        return new ModelAndView("ver-billetera",model);
    }

}







//tipo de retorno de una accion : datos+vista (model+vista)
