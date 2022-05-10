package ar.edu.unlam.tallerweb1.Roomie;

public class Vivienda {
    private Integer id;
    private Integer id_alquiler;
    private Integer cantidadMaximaRoomies;
    private String direccion;

    public Vivienda(Integer id, Integer id_alquiler, Integer cantidadMaximaRoomies, String direccion) {
        this.id = id;
        this.id_alquiler = id_alquiler;
        this.cantidadMaximaRoomies = cantidadMaximaRoomies;
        this.direccion = direccion;
    }
}
