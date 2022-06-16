package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;

public class DatosDonacion {


        private String email ;
        private Double billeteraDeDonaciones;

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public Double getMonto() {
                return billeteraDeDonaciones;
        }

        public void setMonto(Double billeteraDeDonaciones) {
                this.billeteraDeDonaciones = billeteraDeDonaciones;
        }
}
