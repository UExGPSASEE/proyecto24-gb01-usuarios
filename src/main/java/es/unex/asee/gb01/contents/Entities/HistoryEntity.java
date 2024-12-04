package es.unex.asee.gb01.contents.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "history")
public class HistoryEntity {

    @Id
    @GeneratedValue
    private Long idView;

    
    @Column(name = "idUser", nullable = false)
    private Long idUser;

    public HistoryEntity() {}

    public HistoryEntity(Long idUser, Long idView) {
        this.idUser = idUser;
        this.idView = idView;
    }

    // Getters y Setters
    public Long getIdView() {
        return idView;
    }

    public void setIdView(Long idView) {
        this.idView = idView;
    }

    public Long getidUser() {
        return idUser;
    }

    public void setidUser(Long idUser) {
        this.idUser = idUser;
    }

    // Métodos equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryEntity that = (HistoryEntity) o;
        return Objects.equals(idUser, that.idUser) &&
               Objects.equals(idView, that.idView);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, idView);
    }

    // Método toString
    @Override
    public String toString() {
        return "HistoryEntity{" +
                "idUser=" + idUser +
                ", idView=" + idView +
                '}';
    }
}
