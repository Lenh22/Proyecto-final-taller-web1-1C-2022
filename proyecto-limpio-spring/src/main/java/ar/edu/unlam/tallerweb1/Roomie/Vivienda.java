package ar.edu.unlam.tallerweb1.Roomie;

public class Vivienda {

    private Integer id_vivienda;
    private String direccion;
    private Integer cantidadMaximaRoomies;
    private Alquiler alquiler1;

    public Vivienda(Integer id_vivienda, String direccion, Integer cantidadMaximaRoomies, Alquiler alquiler1) {
        this.id_vivienda = id_vivienda;
        this.direccion = direccion;
        this.cantidadMaximaRoomies = cantidadMaximaRoomies;
        this.alquiler1 = alquiler1;
    }
}
