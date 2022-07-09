package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Atributo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioRegistro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

@Controller
public class ControladorRegistro {

    private IServicioRegistro servicioRegistro;

    @Autowired
    public ControladorRegistro(IServicioRegistro servicioRegistro){
        this.servicioRegistro = servicioRegistro;
    }

    @RequestMapping("/registro-usuario")
    public ModelAndView irARegistro() {
        ModelMap modelo = new ModelMap();
        modelo.put("datosRegistro", new Usuario());
        return new ModelAndView("registro-usuario", modelo);
    }

    @RequestMapping(path = "/validar-registro", method = RequestMethod.POST)
    public ModelAndView validarRegistro(@ModelAttribute("datosRegistro") DatosRegistro datosRegistro, HttpServletRequest request) {
        ModelMap model = new ModelMap();
        if (servicioRegistro.verificarUsoDeMail(datosRegistro.getEmail())) {
            model.put("error", "Ya existe un usuario con el mismo mail registrado, por favor utilice otro");
            return new ModelAndView("redirect:/registro-usuario");
        }
        else {
            if(datosRegistro.getRol().equals("roomie")){
                request.getSession().setAttribute("DATOSREGISTRO", datosRegistro);
                model.put("atributos",(Atributo.values()));
                return new ModelAndView("registro-roomie", model);
            }
            else{
                servicioRegistro.registrarNuevoUsuario(datosRegistro);
                model.put("datosLogin",datosRegistro);
            }
        }
        return new ModelAndView("login", model);
    }

    @RequestMapping(path = "/validar-registro-roomie", method = RequestMethod.POST)
    public ModelAndView validarRegistroRoomie(@ModelAttribute("datosRegistro") DatosRegistro datosRegistro, HttpServletRequest request){
        ModelMap model = new ModelMap();
        DatosRegistro datosRegistro1 = new DatosRegistro();
        try{
            if(datosRegistro.getAtributos().isEmpty()){
                model.put("error","Debe seleccionar al menos un atributo");
                return new ModelAndView("redirect:/registro-roomie/");
            }
            else{
                datosRegistro1 = (DatosRegistro) request.getSession().getAttribute("DATOSREGISTRO");
                datosRegistro1.setAtributos(datosRegistro.getAtributos());
                model.put("datosLogin",datosRegistro1);
                servicioRegistro.registrarNuevoUsuario(datosRegistro1);
            }
        }catch (Exception ex){
            model.put("error","Ha surgido un error inesperado");
            return new ModelAndView("registro-roomie",model);
        }
        return new ModelAndView("login",model);
    }

}
