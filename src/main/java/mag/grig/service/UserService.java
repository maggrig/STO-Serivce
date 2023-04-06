package mag.grig.service;

import jakarta.validation.Valid;
import mag.grig.dto.RoleDto;
import mag.grig.dto.UserDto;
import mag.grig.entity.security.User;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto, @Valid @NotNull List<RoleDto> role);

    User findByEmail(String email);

    List<UserDto> findAllUsers();

//    boolean deleteUser(Long userId);
}
