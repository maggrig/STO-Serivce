package mag.grig.service;

import mag.grig.dto.RoleDto;
import mag.grig.entity.security.Role;

import java.util.List;

public interface RoleService {

    Role findByRole(String role);

    List<RoleDto> findAllRoles();

 //  List<Role> findAll();
}
