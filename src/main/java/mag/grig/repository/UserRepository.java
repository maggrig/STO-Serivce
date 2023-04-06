package mag.grig.repository;

import mag.grig.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
//    long deleteByNameIgnoreCaseAllIgnoreCase(String name);
    User findByEmail(String email);
}
