package mag.grig.controller.security;

import mag.grig.entity.dto.security.UserDTO;
import mag.grig.service.security.RoleService;
import mag.grig.service.security.UserRoleService;
import mag.grig.service.security.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    private final RoleService roleService;
    private final UserRoleService userRoleService;

    public UserController(UserService userService, RoleService roleService, UserRoleService userRoleService) {
        this.userService = userService;
        this.roleService = roleService;
        this.userRoleService = userRoleService;
    }

    @GetMapping("/users")
    public @NotNull String listRegisteredUsers(final @NotNull Model model, Principal principal) {
        List<UserDTO> users = userService.findAllUsers();
        model.addAttribute("users", users);
        if (principal != null)
            model.addAttribute("principal", principal.getName());
        else model.addAttribute("principal", "Вход не выполнен!!!");
        return "users";
    }

    @GetMapping("/users/{userId}/delete")
    public String deleteUser(@PathVariable Long userId) {

        userRoleService.deleteById(userId);
        userService.deleteById(userId);
        return "redirect:/users";
    }
}
