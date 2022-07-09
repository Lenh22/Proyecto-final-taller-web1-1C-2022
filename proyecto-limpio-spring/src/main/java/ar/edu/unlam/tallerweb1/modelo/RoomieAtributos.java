package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
public class RoomieAtributos {

    private long idRoomie;
    @Enumerated(EnumType.ORDINAL)
    private Atributo atributo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public RoomieAtributos() {
    }

    public RoomieAtributos(Long idRoomie, Atributo atributo) {
        this.idRoomie = idRoomie;
        this.atributo = atributo;
    }

    public long getIdRoomie() {
        return idRoomie;
    }

    public void setIdRoomie(long idRoomie) {
        this.idRoomie = idRoomie;
    }

    public Atributo getAtributo() {
        return atributo;
    }

    public void setAtributo(Atributo atributo) {
        this.atributo = atributo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
