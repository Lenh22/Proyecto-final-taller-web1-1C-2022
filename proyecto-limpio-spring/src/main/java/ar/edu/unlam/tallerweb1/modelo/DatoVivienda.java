package ar.edu.unlam.tallerweb1.modelo;

public class DatoVivienda {

    private Integer vivienda;

   // private Propietario propietario;

    public Integer getVivienda() {
        return vivienda;
    }

    public void setVivienda(Integer vivienda) {
        this.vivienda = vivienda;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCantidadMaximaRoomies() {
        return cantidadMaximaRoomies;
    }

    public void setCantidadMaximaRoomies(Integer cantidadMaximaRoomies) {
        this.cantidadMaximaRoomies = cantidadMaximaRoomies;
    }

    private String direccion;

    //private  Alquiler alquiler;

    private  Integer cantidadMaximaRoomies;



    public  DatoVivienda(){}


}
