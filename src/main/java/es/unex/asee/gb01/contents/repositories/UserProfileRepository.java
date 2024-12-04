package es.unex.asee.gb01.contents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import es.unex.asee.gb01.contents.Entities.UserProfileEntity;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {
    List<UserProfileEntity> findByIdUser(Long idUser);
}
