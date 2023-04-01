package mag.grig.repository;

import mag.grig.entity.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
    Role findByName(String name);
    List<Role> findAll();
}
