package es.unex.asee.gb01.contents.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.unex.asee.gb01.contents.Entities.WatchLaterEntity;

@Repository
public interface WatchLaterRepository extends JpaRepository<WatchLaterEntity, Long> {
    // Métodos de consulta personalizados pueden añadirse aquí
}

