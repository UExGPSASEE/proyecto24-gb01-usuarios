package es.unex.asee.gb01.contents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.unex.asee.gb01.contents.Entities.SubscriptionTypeEntity;

@Repository
public interface SubscriptionTypeRepository extends JpaRepository<SubscriptionTypeEntity, Long> {
    // Métodos de búsqueda personalizados pueden añadirse aquí, si son necesarios.
}

