package mag.grig.controller.security;

import jakarta.validation.Valid;
import mag.grig.entity.dto.security.UserDTO;
import mag.grig.entity.security.Role;
import mag.grig.entity.security.User;
import mag.grig.service.security.RoleService;
import mag.grig.service.security.UserService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public final class AuthController {
    private final UserService userService;
    private final RoleService roleService;

    public AuthController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Contract(pure = true)
    @GetMapping("index")
    public @NotNull String home() {
        return "index_new";
    }

    @Contract(pure = true)
    @GetMapping("/")
    public @NotNull String index() {
        return "login";
    }

    @Contract(pure = true)
    @GetMapping("/login")
    public @NotNull String loginForm() {
        return "login";
    }

    // handler method to handle user registration request
    @GetMapping("register")
    public @NotNull String showRegistrationForm(final @NotNull Model model) {
        UserDTO user = new UserDTO();
        List<Role> roles = roleService.findAllRoles();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);

        return "register";
    }

    // handler method to handle register user form submit request
    @PostMapping("/register/save")
    public @NotNull String registration(final @Valid @ModelAttribute("user") @NotNull UserDTO userDto,
                                        final BindingResult result,
                                        final Model model) {

        User existing = userService.findByEmail(userDto.getEmail());
//        String[] role = userDto.getRoles().split(",");
//        String role1 = List.of(roles).get(0).getRole();
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            model.addAttribute("roles", userDto.getRoles());
            model.addAttribute("errorMessage", "Registration failed. Please check the form for errors.");
            return "register";
        }
        userService.saveUser(userDto);
        return "redirect:/register?success";
    }
}
