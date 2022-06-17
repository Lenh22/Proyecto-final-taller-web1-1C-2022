package ar.edu.unlam.tallerweb1.Emparejamiento;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorEmparejamiento;
import ar.edu.unlam.tallerweb1.modelo.Atributo;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioEmparejamiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioEmparejamiento;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.LinkedList;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class TestGeneralDelSistemaDeEmparejamiento extends SpringTest {
    private ControladorEmparejamiento controller;
    private ServicioEmparejamiento service;
    @Autowired
    RepositorioEmparejamiento repositorioEmparejamiento;

    @Before
    public void Init(){

        service = new ServicioEmparejamiento(repositorioEmparejamiento);
        controller = new ControladorEmparejamiento(service);

    }


    @Test @Transactional
    @Rollback
    public  void testGeneral(){

     dadoqueExisteUnUsuarioLogeado();
     dadoQueExistenRoomiesConCaracteristicasCompatibles();
     ModelAndView mav = entoncesObtengoRoomieCompatibles();
     entoncesComparoRoomies(mav);


 }

    private void entoncesComparoRoomies(ModelAndView mav) {
         assertThat(mav.getViewName()).isEqualTo("resultado-roomies-compatibles");

    }

    private ModelAndView entoncesObtengoRoomieCompatibles() {
        return controller.irAResultadoRoomieCompatibles(1L);
    }

    private void dadoQueExistenRoomiesConCaracteristicasCompatibles() {
        Roomie r2= new Roomie();
        Roomie r3 = new Roomie();
        LinkedList<Atributo> atributos = new LinkedList<>();
        atributos.add(Atributo.FUMADOR);
        atributos.add(Atributo.VEGGIE);
        atributos.add(Atributo.WEEDFRIENDLY);
        atributos.add(Atributo.INCLUSIVO);
        atributos.add(Atributo.DIURNO);
        atributos.add(Atributo.SEXWORK);
        atributos.add(Atributo.NOCTURNO);
        r2.setNombre("Leandro");
        r2.setId(2L);
        r2.setAtributos(atributos);

        LinkedList<Atributo> atributos2 = new LinkedList<>();
        atributos2.add(Atributo.DIURNO);
        atributos2.add(Atributo.SEXWORK);
        atributos2.add(Atributo.PETFRIENDLY);
        atributos2.add(Atributo.NOCTURNO);
        r3.setNombre("Matias");
        r3.setId(3L);
        r3.setAtributos(atributos2);
        repositorioEmparejamiento.agregarRoomie(r2);
        repositorioEmparejamiento.agregarRoomie(r3);


    }

    private void dadoqueExisteUnUsuarioLogeado() {
        Roomie r1 = new Roomie();
        LinkedList<Atributo> atributos = new LinkedList<>();
        atributos.add(Atributo.FUMADOR);
        atributos.add(Atributo.DIURNO);
        atributos.add(Atributo.GAMER);
        atributos.add(Atributo.INCLUSIVO);
        atributos.add(Atributo.VEGGIE);
        atributos.add(Atributo.SEXWORK);
        r1.setNombre("Ariel");
        r1.setEmail("lean@gmail.com");
        r1.setId(1L);
        r1.setAtributos(atributos);
        repositorioEmparejamiento.agregarRoomie(r1);
    }
}
