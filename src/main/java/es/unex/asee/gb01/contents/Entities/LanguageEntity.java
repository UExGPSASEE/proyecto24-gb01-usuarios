package es.unex.asee.gb01.contents.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "languages")
public class LanguageEntity {

    @Id
    @GeneratedValue
    private Long idLanguage;

    
    @Column(name = "name", nullable = false)
    private String name;

    // Constructor sin argumentos
    public LanguageEntity() {}

    // Constructor con argumentos
    public LanguageEntity(Long idLanguage, String name) {
        this.idLanguage = idLanguage;
        this.name = name;
    }

    // Getters y Setters
    public Long getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(Long idLanguage) {
        this.idLanguage = idLanguage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LanguageEntity that = (LanguageEntity) o;
        return Objects.equals(idLanguage, that.idLanguage) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLanguage, name);
    }

    // Método toString
    @Override
    public String toString() {
        return "LanguageEntity{" +
                "idLanguage=" + idLanguage +
                ", name='" + name + '\'' +
                '}';
    }
}

