package es.unex.asee.gb01.contents.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "watchLater")
public class WatchLaterEntity {

    @Id
    @GeneratedValue
    private Long idWatchLater;

    
    @Column(name = "idUser", nullable = false)
    private Long idUser;

    
    @Column(name = "idContent", nullable = false)
    private Long idContent;

    // Constructor sin argumentos
    public WatchLaterEntity() {}

    // Constructor con argumentos
    public WatchLaterEntity(Long idUser, Long idContent) {
        this.idUser = idUser;
        this.idContent = idContent;
    }

    // Getters y Setters
    public Long getIdWatchLater() {
        return idWatchLater;
    }

    public void setIdWatchLater(Long idWatchLater) {
        this.idWatchLater = idWatchLater;
    }

    public Long getidUser() {
        return idUser;
    }

    public void setidUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getidContent() {
        return idContent;
    }

    public void setidContent(Long idContent) {
        this.idContent = idContent;
    }

    // Métodos equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WatchLaterEntity that = (WatchLaterEntity) o;
        return Objects.equals(idUser, that.idUser) &&
               Objects.equals(idContent, that.idContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, idContent);
    }

    // Método toString
    @Override
    public String toString() {
        return "WatchLaterEntity{" +
                "idWatchLater=" + idWatchLater +
                ", idUser=" + idUser +
                ", idContent=" + idContent +
                '}';
    }
}

