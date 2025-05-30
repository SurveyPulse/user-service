package surveypulse.user_service.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import surveypulse.user_service.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);

}
