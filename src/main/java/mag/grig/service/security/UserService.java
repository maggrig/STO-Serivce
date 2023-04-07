package mag.grig.service.security;

import mag.grig.dto.security.UserDto;
import mag.grig.entity.security.User;

import java.util.List;

public interface UserService {
//    void saveUser(UserDto userDto, @Valid @NotNull List<RoleDto> role);

    User findByEmail(String email);

    List<UserDto> findAllUsers();

//    boolean deleteUser(Long userId);
}
