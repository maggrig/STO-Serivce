package mag.grig.service.security;

import mag.grig.dto.security.UserDTO;
import mag.grig.entity.security.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDto, String role);

    User findByEmail(String email);

    List<UserDTO> findAllUsers();

//    boolean deleteUser(Long userId);
}
