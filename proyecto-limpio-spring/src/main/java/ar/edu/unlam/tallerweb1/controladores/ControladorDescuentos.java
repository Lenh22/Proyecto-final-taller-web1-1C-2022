package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.DatosDescuento;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.servicios.IServicioDescuento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorDescuentos {

    private IServicioDescuento servicioDeDescuento;
    private Boolean descuento = false;

    @Autowired
    public ControladorDescuentos(IServicioDescuento servicioDeDescuento) {
        this.servicioDeDescuento = servicioDeDescuento;
    }

    @RequestMapping("/generar-descuento")
    public ModelAndView irAGenerarDescuento() {
        ModelMap modelo = new ModelMap();
        modelo.put("datosDescuento", new DatosDescuento());
        return new ModelAndView("generar-descuento", modelo);
    }

    @RequestMapping(path = "validar-descuento", method = RequestMethod.POST)
    public ModelAndView MostrarDescuentoDisponible(@ModelAttribute("datosDescuento") DatosDescuento datos) {
        ModelMap model = new ModelMap();


        Roomie roomieBuscado = new Roomie();
        roomieBuscado.setEmail(datos.getEmail());
        roomieBuscado.setPassword(datos.getPassword());
        //servicioDeDescuento.saveRoomie(roomieBuscado);
        servicioDeDescuento.consultarRoomie(datos.getEmail(), datos.getPassword());

        if (roomieBuscado != null) {
            Boolean descuento = servicioDeDescuento.verificarAplicacionADescuento(roomieBuscado);
            model.put("descuento", descuento);
        } else {
            model.put("msg-error", "El usuario buscado no existe");
        }
        return new ModelAndView("validar-descuento", model);
    }
}
