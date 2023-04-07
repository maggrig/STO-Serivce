package mag.grig.service.impl.security;

import jakarta.validation.Valid;
import mag.grig.dto.security.RoleDto;
import mag.grig.dto.security.UserDto;
import mag.grig.entity.security.Role;
import mag.grig.entity.security.User;
import mag.grig.repository.security.RoleRepository;
import mag.grig.repository.security.UserRepository;
import mag.grig.service.security.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto, @NotNull List<RoleDto> roleDto) {
        User user = new User();
        user.setFirst_Name(userDto.getFirstName());
        user.setLast_Name(userDto.getFirstName());
        user.setEmail(userDto.getEmail());

        //encrypt the password once we integrate spring security
        //user.setPassword(userDto.getPassword());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        Role role = roleRepository.findByRole("ROLE_ADMIN");
//        if(role == null){
//            role = checkRoleExist();
//        }

//        user.setRoles(roleDto);
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private UserDto convertEntityToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirst_Name());
        userDto.setLastName(user.getLast_Name());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRoles().get(0).getRole());

        return userDto;
    }

    private User convertDtoToEntity(@Valid @NotNull UserDto userDto) {
        User user = new User();
        userDto.setId(userDto.getId());
        userDto.setFirstName(userDto.getFirstName());
        userDto.setLastName(userDto.getLastName());
        userDto.setEmail(userDto.getEmail());
        userDto.setRole(userDto.getRole());
        return user;
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setRole("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
