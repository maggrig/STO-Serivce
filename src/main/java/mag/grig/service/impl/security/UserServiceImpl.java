package mag.grig.service.impl.security;

import mag.grig.entity.dto.security.UserDTO;
import mag.grig.entity.repository.security.RoleRepository;
import mag.grig.entity.repository.security.UserRepository;
import mag.grig.entity.repository.security.UserRoleRepository;
import mag.grig.entity.security.Role;
import mag.grig.entity.security.User;
import mag.grig.entity.security.UserRole;
import mag.grig.service.security.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository userRoleRepository;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void saveUser(UserDTO userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        //       Optional<Role> role = roleRepository.findById(1L);
//        List<Role> roles = userDto.getRoles();
        //encrypt the password once we integrate spring security
        //user.setPassword(userDto.getPassword());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

//        user.setRoles(Collections.singleton(role.get("0L").getName()));
        userRepository.save(user);
        UserRole userRole = new UserRole();
        userRole.setUser_id(user.getId());
//        userRole.setRole_id(Long.valueOf(userDto.getRoles().getId()));

//        userRoleRepository.save(userRole);


    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public List<UserDTO> findAllUsers() {
        List<User> users = userRepository.findAll();
//        List<User> users = userRepository.findByIdOrderById(Long.valueOf("id"));
        return users.stream().map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    /**
     * @param userId
     */
    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    /**
     * @return List<User>
     */
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * @param acceptorId
     * @return
     */
    @Override
    public String findById(Long acceptorId) {
        return findById(acceptorId);
    }

    private UserDTO convertEntityToDto(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setRoles(user.getRoles().get(0).getRole());
        return userDto;
    }

//    private User convertDtoToEntity(@Valid @NotNull UserDTO userDto) {
//        User user = new User();
//        userDto.setId(userDto.getId());
//        userDto.setFirstName(userDto.getFirstName());
//        userDto.setLastName(userDto.getLastName());
//        userDto.setEmail(userDto.getEmail());
//        userDto.setRoles(userDto.getRoles());
//        return user;
//    }

    private Role checkRoleExist() {
        Role role = new Role();
//        role.setRole("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
