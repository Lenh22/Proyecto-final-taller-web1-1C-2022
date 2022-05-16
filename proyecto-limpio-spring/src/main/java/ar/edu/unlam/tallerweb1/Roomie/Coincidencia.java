package ar.edu.unlam.tallerweb1.Roomie;

import ar.edu.unlam.tallerweb1.modelo.Roomie;


;import java.util.function.Predicate;

public class Coincidencia {
    private Double coincidencia=0.0;
    public Double matcheoDeRoomie(Roomie roomie1, Roomie roomie2) {

        Double resultado = 0.0;




        if (roomie1.mostrarAtributos().contains(Atributo.FUMADOR)&&(roomie2.mostrarAtributos().contains(Atributo.FUMADOR))) {


                     this.coincidencia++;
                }
                  if (roomie1.mostrarAtributos().contains(Atributo.DIURNO)&&(roomie2.mostrarAtributos().contains(Atributo.DIURNO))) {
                    this.coincidencia++;
                }

              if (roomie1.mostrarAtributos().contains(Atributo.NOCTURNO)&&(roomie2.mostrarAtributos().contains(Atributo.NOCTURNO)))
            {

              this.coincidencia++;
        }


              resultado += ((this.coincidencia) / ((roomie1.mostrarAtributos().size()))) * ((this.coincidencia) / ((roomie2.mostrarAtributos().size()))) *100;





        return resultado;


    }











    }





