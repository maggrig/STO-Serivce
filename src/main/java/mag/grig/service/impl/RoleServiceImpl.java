package mag.grig.service.impl;

import mag.grig.entity.security.Role;
import mag.grig.repository.RoleRepository;
import mag.grig.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByRole(String role) {
        return roleRepository.findByRole(role);
    }

    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }
}
