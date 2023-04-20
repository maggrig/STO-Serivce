package mag.grig.service.security;

import mag.grig.entity.security.Role;

import java.util.List;

public interface RoleService {

    Role findById(Long id);

    List<Role> findAllRoles();

    //  List<Role> findAll();
}
