package mag.grig.repository.security;

import mag.grig.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //    long deleteByNameIgnoreCaseAllIgnoreCase(String name);
    User findByEmail(String email);

    User findById(Optional<User> byId);
}
