package mag.grig.controller;

import jakarta.validation.Valid;
import mag.grig.dto.security.RoleDto;
import mag.grig.dto.security.UserDto;
import mag.grig.entity.Order;
import mag.grig.entity.security.Role;
import mag.grig.entity.security.User;
import mag.grig.repository.security.RoleRepository;
import mag.grig.repository.security.UserRepository;
import mag.grig.service.security.RoleService;
import mag.grig.service.security.UserService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public AuthController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Contract(pure = true)
    @GetMapping("index")
    public @NotNull String home() {
        return "login";
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
        Order order = new Order();  //  order   model       instance

        UserDto user = new UserDto();
        List<Role> roles = roleService.findAllRoles();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);

        return "register";
    }

    // handler method to handle register user form submit request
    @PostMapping("/register/save")
    public @NotNull String registration(final @Valid @ModelAttribute("user") @NotNull UserDto user,
                                        final @Valid @ModelAttribute("role") @NotNull RoleDto role,
                                        final BindingResult result,
                                        final Model model) {

        User existing = userService.findByEmail(user.getEmail());

//        List<Role> roles = (List<Role>) role.getRole().split(",");
//        Arrays.stream(roles).map(role);
//       map(role)-> UserServiceImpl.convertDtoToEntity(role)).collect(Collectors.toList());
//        RoleDto roleDto= Stream.of(role).collect(Collectors.toList());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
//        userService.saveUser(user, role);
        return "redirect:/register?success";
    }

}
