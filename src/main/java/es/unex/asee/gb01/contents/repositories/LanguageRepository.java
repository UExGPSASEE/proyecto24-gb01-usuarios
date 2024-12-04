package es.unex.asee.gb01.contents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.unex.asee.gb01.contents.Entities.LanguageEntity;

@Repository
public interface LanguageRepository extends JpaRepository<LanguageEntity, Long> {
    // Aquí puedes añadir métodos de consulta personalizados si se necesitan
}
