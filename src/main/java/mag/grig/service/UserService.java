package mag.grig.service;

import mag.grig.dto.UserDto;
import mag.grig.entity.security.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
