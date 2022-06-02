package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.repositorios.IRepositorioRoomie;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRoomie;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ServicioDonacion implements IServicioDonaciones{
    private IRepositorioRoomie repositorioRoomies;

    @Autowired
    public ServicioDonacion(IRepositorioRoomie repositorioRoomies) {
        this.repositorioRoomies = repositorioRoomies;
    }

    @Override
    public List<Roomie> buscarDonatarios(Boolean b) {

        //Primero traemlos la lista de roomies de repositorio //HayQueHacerElMetodo
        List<Roomie> roomiesADonar = repositorioRoomies.obtenerRoomies();

        //metodo para devolver usuarios que quieran recibir donacion
        for (Roomie roomieDonatarios: roomiesADonar) {
            if(roomieDonatarios.getRecibirDonacion()==true)
                roomiesADonar.add(roomieDonatarios);
        }
        return roomiesADonar;
    }
    @Override
    public Boolean darDonacion(Roomie roomieDonatario, Double donacion) {

        if (donacion>0.0 && roomieDonatario.getRecibirDonacion()){
            incrementaBilletera(roomieDonatario,donacion);
            return true;
        }
        return false;
    }
    @Override
    public Double incrementaBilletera(Roomie roomie, Double donacion) {

        Double  billeteraActual = roomie.getBilleteraDeDonaciones();
        Double  suma = billeteraActual + donacion;
        roomie.setBilleteraDeDonaciones(suma);
        return suma;
    }
    @Override
    public Roomie buscarDonatario(Roomie roomieDonatario) {
        //Puede ser que no exista, como manejo eso?
        //Primero traemlos la lista de roomies de repositorio //HayQueHacerElMetodo
        List<Roomie> roomiesADonar = repositorioRoomies.obtenerRoomies();
        Roomie econtrado = null;
        for (Roomie roomieDonatarios : roomiesADonar)
            if (roomieDonatarios.getEmail() == roomieDonatario.getEmail()){
                econtrado = roomieDonatario;
            }
        return econtrado;
    }

    //metodo para devolver usuarios que quieran recibir donacion
    @Override
    public Double billeteraDelRoomie(Roomie roomieDonatario) {

        return roomieDonatario.getBilleteraDeDonaciones();
    }


}
