package ar.edu.unlam.tallerweb1.modelo;

public class DatoVivienda {

    private Integer vivienda;
    private Propietario propietario;
    private String direccion;
    private  Alquiler alquiler;
    private  Integer cantidadMaximaRoomies;

    public  DatoVivienda(){}


    public Integer getVivienda() {
        return vivienda;
    }

    public void setVivienda(Integer vivienda) {
        this.vivienda = vivienda;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    public Integer getCantidadMaximaRoomies() {
        return cantidadMaximaRoomies;
    }

    public void setCantidadMaximaRoomies(Integer cantidadMaximaRoomies) {
        this.cantidadMaximaRoomies = cantidadMaximaRoomies;
    }
}
