package ar.edu.unlam.tallerweb1.Emparejamiento;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorEmparejamiento;
import ar.edu.unlam.tallerweb1.controladores.DatosRegistro;
import ar.edu.unlam.tallerweb1.modelo.Atributo;
import ar.edu.unlam.tallerweb1.modelo.Roomie;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioEmparejamiento;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioEmparejamiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistro;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.LinkedList;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class TestGeneralDelSistemaDeEmparejamiento extends SpringTest {

    private ServicioRegistro servicioRegistro;
    private ControladorEmparejamiento controller;
    private ServicioEmparejamiento service;

    @Autowired
    RepositorioEmparejamiento repositorioEmparejamiento;

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Before
    public void Init(){

        service = new ServicioEmparejamiento(repositorioEmparejamiento);
        controller = new ControladorEmparejamiento(service);
        servicioRegistro = new ServicioRegistro(repositorioUsuario,repositorioEmparejamiento);
    }


    @Test @Transactional
    @Rollback
    public  void testGeneralDelSistemaDeEmparejamiento(){

     dadoqueExisteUnUsuarioLogeado();
     //dadoQueExistenRoomiesConCaracteristicasCompatibles();
     ModelAndView mav = entoncesObtengoRoomieCompatibles();
     entoncesComparoRoomies(mav);
 }

 /*____________________________________Dado____________________________*/
    private void dadoqueExisteUnUsuarioLogeado() {
     DatosRegistro r1 = new DatosRegistro();
     LinkedList<Atributo> atributos = new LinkedList<>();
     atributos.add(Atributo.FUMADOR);
     atributos.add(Atributo.DIURNO);
     atributos.add(Atributo.GAMER);
     atributos.add(Atributo.INCLUSIVO);
     atributos.add(Atributo.VEGGIE);
     atributos.add(Atributo.SEXWORK);
     r1.setNombre("Ariel");
     r1.setEmail("lean@gmail.com");
     r1.setPassword("12345");
     r1.setRol("roomie");
     r1.setEdad(25);
     r1.setApellido("Gomez");
     //r1.setAtributos(atributos);

     servicioRegistro.registrarNuevoUsuario(r1);
 }

    /*private void dadoQueExistenRoomiesConCaracteristicasCompatibles() {
        DatosRegistro r2 = new DatosRegistro();
        DatosRegistro r3 = new DatosRegistro();
        LinkedList<Atributo> atributos = new LinkedList<>();
        atributos.add(Atributo.FUMADOR);
        atributos.add(Atributo.VEGGIE);
        atributos.add(Atributo.WEEDFRIENDLY);
        atributos.add(Atributo.INCLUSIVO);
        atributos.add(Atributo.DIURNO);
        atributos.add(Atributo.SEXWORK);
        atributos.add(Atributo.NOCTURNO);
        r2.setNombre("Leandro");
        r2.setEmail("leann@gmail.com");
        r2.setPassword("12345");
        r2.setRol("roomie");
        r2.setEdad(22);
        r2.setApellido("Gomez");
        r2.setAtributos(atributos);

        LinkedList<Atributo> atributos2 = new LinkedList<>();
        atributos2.add(Atributo.DIURNO);
        atributos2.add(Atributo.SEXWORK);
        atributos2.add(Atributo.PETFRIENDLY);
        atributos2.add(Atributo.NOCTURNO);
        r3.setNombre("Matias");
        r3.setEmail("mati@gmail.com");
        r3.setPassword("12345");
        r3.setRol("roomie");
        r3.setEdad(22);
        r3.setApellido("Gomez");
        r3.setAtributos(atributos2);
        servicioRegistro.registrarNuevoUsuario(r2);
        servicioRegistro.registrarNuevoUsuario(r3);

    }*/

    /*____________________________________Ejecucion____________________________*/

    private ModelAndView entoncesObtengoRoomieCompatibles() {
        return controller.irAResultadoRoomieCompatibles(1L,null);
    }

    /*____________________________________Resultado____________________________*/
    private void entoncesComparoRoomies(ModelAndView mav) {
         assertThat(mav.getViewName()).isEqualTo("resultado-roomies-compatibles");
         assertThat(mav.getModelMap()).hasSize(1);
    }






}
