package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.IServicioDenuncia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorDenuncia {

    private IServicioDenuncia servicioDenuncia;
   @Autowired
    public ControladorDenuncia(IServicioDenuncia servicioDenuncia) {

        this.servicioDenuncia = servicioDenuncia;

    }

    @RequestMapping("/denuncia")
    public ModelAndView irADarDonacion() {
        ModelMap modelo = new ModelMap();
        modelo.put("datosDenuncia", new DatosDenuncia());
        return new ModelAndView("denuncia", modelo);
    }
    @RequestMapping(path = "/denunciaValidacion",  method = RequestMethod.POST )
    public ModelAndView MensajeDeExito(@ModelAttribute("datosDenuncia")DatosDenuncia datosdenuncia) {
        ModelMap model = new ModelMap();
        Roomie usuarioBuscado = (Roomie) servicioDenuncia.consultarUsuario(datosdenuncia.getEmail());
        if(usuarioBuscado!=null ){
            servicioDenuncia.aumentarDenuncia(datosdenuncia.getEmail());
            servicioDenuncia.inactivarRoomiePorCantidadDeDenuncia(datosdenuncia.getEmail());

                model.put("email", datosdenuncia.getEmail());
                model.put("estado", datosdenuncia.getEstado());
                model.put("error", "Se denuncio Exitosamente");
                return new ModelAndView("denuncia", model);
            }
         else {
            model.put("error", "No se pudo denunciar al usuario. Contacta al administrador");
        }
        return new ModelAndView("denuncia", model);
    }
}
