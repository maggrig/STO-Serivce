package mag.grig.service.security;

import mag.grig.entity.dto.security.UserDTO;
import mag.grig.entity.security.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDto);

    User findByEmail(String email);

    List<UserDTO> findAllUsers();

    void deleteById(Long userId);

    List<User> findAll();

    String findById(Long acceptorId);
}
