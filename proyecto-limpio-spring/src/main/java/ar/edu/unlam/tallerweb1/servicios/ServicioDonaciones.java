package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.repositorios.Interfaces.IRepositorioRoomie;
import ar.edu.unlam.tallerweb1.servicios.Interfaces.IServicioDonaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServicioDonaciones implements IServicioDonaciones {
    private IRepositorioRoomie repositorioRoomies;

    @Autowired
    public ServicioDonaciones(IRepositorioRoomie repositorioRoomies) {

        this.repositorioRoomies = repositorioRoomies;
    }

    @Override
    public List<Roomie> buscarDonatarios() {

        //Primero traemlos la lista de roomies de repositorio //HayQueHacerElMetodo
        List<Roomie> roomiesADonar = repositorioRoomies.obtenerRoomies();
        return roomiesADonar;
    }
    @Override
    public Boolean darDonacion(String roomieDonatario, Double donacion) {

        Roomie Donatario = repositorioRoomies.ObtenerUnRoomie(roomieDonatario);

        if (Donatario!=null && Donatario.getRecibirDonacion()!=null && donacion>0.0 && Donatario.getRecibirDonacion()==true){
            incrementaBilletera(Donatario,donacion);
            return true;
        }
        return false;
    }
    @Override
    public Double incrementaBilletera(Roomie roomie, Double donacion) {

        try {
            Roomie roomie2 = repositorioRoomies.ObtenerUnRoomie(roomie.getEmail());
            Double  billeteraActual = roomie2.getBilleteraDeDonaciones();
            Double  suma = billeteraActual + donacion;
            roomie.setBilleteraDeDonaciones(suma);
            return suma;
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        return 0.0;
    }
    @Override
    public Roomie buscarDonatario(Roomie roomieDonatario) {
        List<Roomie> roomiesADonar = repositorioRoomies.obtenerRoomies();
        Roomie econtrado = null;
        for (Roomie roomieDonatarios2 : roomiesADonar)
            if (roomieDonatarios2.getEmail() == roomieDonatario.getEmail()){
                econtrado = roomieDonatario;
            }
        return econtrado;
    }

    //metodo para devolver usuarios que quieran recibir donacion
    @Override
    public Double billeteraDelRoomie(String roomieDonatario) {
        Roomie Donatario = repositorioRoomies.buscar(roomieDonatario);
        return Donatario.getBilleteraDeDonaciones();
    }


    @Override
    public Boolean activarDonacion(String email, Boolean activar){
        try {
            Roomie roomie = repositorioRoomies.ObtenerUnRoomie(email);
            if (roomie.getActivo() == true && roomie.getBilleteraDeDonaciones()<99999.99) {
                roomie.setRecibirDonacion(activar);
                return true;
            }else{
                return false;
            }
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        return false;
    }

}
