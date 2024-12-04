package es.unex.asee.gb01.contents.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "favorites")
public class FavoriteEntity {
    @Id
    @GeneratedValue
    private long idFavorite;

    
    @Column(name = "idUser", nullable = false)
    private long idUser;


    
    @Column(name = "idContent", nullable = false)
    private long idContent;

    private int contentType;

    // Constructor sin argumentos
    public FavoriteEntity() {}

    // Constructor con argumentos
    public FavoriteEntity(Long idUser, Long idContent, int contentType) {
        this.idUser = idUser;
        this.idContent = idContent;
        this.contentType = contentType;
    }

    // Getters y Setters
    public Long getIdFavorite() {
        return idFavorite;
    }

    public void setIdFavorite(Long idFavorite) {
        this.idFavorite = idFavorite;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdContent() {
        return idContent;
    }

    public void setIdContent(Long idContent) {
        this.idContent = idContent;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    // Métodos equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavoriteEntity that = (FavoriteEntity) o;
        return Objects.equals(idUser, that.idUser) &&
               Objects.equals(idContent, that.idContent) &&
                contentType == that.contentType
               ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, idContent, contentType);
    }

    // Método toString
    @Override
    public String toString() {
        return "FavoriteEntity{" +
                "idFavorite=" + idFavorite +
                ", idUser=" + idUser +
                ", idContent=" + idContent +
                ", contentType=" + contentType +
                '}';
    }
}

