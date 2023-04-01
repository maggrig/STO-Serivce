package mag.grig.controller;

import jakarta.validation.Valid;
import mag.grig.dto.UserDto;
import mag.grig.entity.security.User;
import mag.grig.service.UserService;
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

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("index")
    public String home() {
        return "login";
    }

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    // handler method to handle user registration request
    @GetMapping("register")
    public String showRegistrationForm(final Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);

        return "register";
    }

    // handler method to handle register user form submit request
    @PostMapping("/register/save")
    public String registration(final @Valid @ModelAttribute("user") UserDto user,
                               final BindingResult result,
                               final Model model) {
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }

    @GetMapping("/users")
    public String listRegisteredUsers(final Model model) {
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
}
