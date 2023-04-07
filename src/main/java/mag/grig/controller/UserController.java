package mag.grig.controller;

import mag.grig.dto.security.UserDto;
import mag.grig.repository.security.RoleRepository;
import mag.grig.repository.security.UserRepository;
import mag.grig.repository.security.UserRoleRepository;
import mag.grig.service.security.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRoleRepository userRoleRepository;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public @NotNull String listRegisteredUsers(final @NotNull Model model) {
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/users/{userId}/delete")
    public String deleteUser(@PathVariable Long userId) {

        userRoleRepository.deleteById(Long.valueOf(userId));
        userRepository.deleteById(Long.valueOf(userId));
        return "redirect:/users";
    }
}
