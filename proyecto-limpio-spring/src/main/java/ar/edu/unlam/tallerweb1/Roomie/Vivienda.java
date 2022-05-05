package ar.edu.unlam.tallerweb1.Roomie;

public class Vivienda {

    private Integer id_vivienda;


    private String direccion;
    private Alquiler alquiler;

    private Integer cantidadMaximaRoomies;



    public Vivienda(Integer id_vivienda, String direccion ,Integer cantidadMaximaRoomies,Alquiler alquiler) {
        this.id_vivienda=id_vivienda;
        this.direccion=direccion;
        this.cantidadMaximaRoomies=cantidadMaximaRoomies;
        this.alquiler=alquiler;



    }
}
