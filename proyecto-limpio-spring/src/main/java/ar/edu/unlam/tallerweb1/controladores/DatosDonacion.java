package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;

import java.awt.font.TextHitInfo;

public class DatosDonacion {


        private String email ;
        private Double billeteraDeDonaciones;

        public DatosDonacion() {
        }

        @Autowired
        public DatosDonacion(String mail, double v) {
                this.email=mail;
                this.billeteraDeDonaciones=v;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public Double getBilleteraDeDonaciones() {
                return billeteraDeDonaciones;
        }

        public void setBilleteraDeDonaciones(Double billeteraDeDonaciones) {
                this.billeteraDeDonaciones = billeteraDeDonaciones;
        }
}
