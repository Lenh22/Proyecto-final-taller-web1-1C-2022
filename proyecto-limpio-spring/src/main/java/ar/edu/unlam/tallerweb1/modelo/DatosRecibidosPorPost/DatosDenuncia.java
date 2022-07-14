package ar.edu.unlam.tallerweb1.modelo.DatosRecibidosPorPost;

public class DatosDenuncia {
    private String email ;
    private Boolean estado;

    public DatosDenuncia() {
    }

    public DatosDenuncia(String email, Boolean estado) {
        this.email = email;
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
