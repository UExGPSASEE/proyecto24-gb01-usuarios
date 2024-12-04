package es.unex.asee.gb01.contents.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.unex.asee.gb01.contents.Entities.CreditCardEntity;

@Repository
public interface CreditCardRepository extends JpaRepository <CreditCardEntity, Long>{
}
