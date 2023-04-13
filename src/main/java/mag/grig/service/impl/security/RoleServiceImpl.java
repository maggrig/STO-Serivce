package mag.grig.service.impl.security;

import mag.grig.entity.security.Role;
import mag.grig.repository.security.RoleRepository;
import mag.grig.service.security.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }
}
