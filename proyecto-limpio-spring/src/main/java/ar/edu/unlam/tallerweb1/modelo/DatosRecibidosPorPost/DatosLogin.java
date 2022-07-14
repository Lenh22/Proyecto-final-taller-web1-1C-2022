package ar.edu.unlam.tallerweb1.modelo.DatosRecibidosPorPost;

public class DatosLogin {
    private String email;
    private String password;
    private Boolean aceptodonacion;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAceptodonacion() {
        return aceptodonacion;
    }

    public void setAceptodonacion(Boolean aceptodonacion) {
        this.aceptodonacion = aceptodonacion;
    }
}
