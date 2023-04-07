package mag.grig.service.security;

import mag.grig.entity.security.Role;

import java.util.List;

public interface RoleService {

//    Role findByRole(String role);

    List<Role> findAllRoles();

 //  List<Role> findAll();
}
