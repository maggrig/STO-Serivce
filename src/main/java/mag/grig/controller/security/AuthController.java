package mag.grig.controller.security;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import mag.grig.RabbitMQ.MessageConsumer;
import mag.grig.RabbitMQ.MessageProducer;
import mag.grig.classes.OrderObject;
import mag.grig.entity.dto.security.UserDTO;
import mag.grig.entity.security.Role;
import mag.grig.entity.security.User;
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

import static java.lang.Thread.sleep;

@Log4j2
@Controller
public final class AuthController {
    private final UserService userService;
    private final RoleService roleService;
    private MessageProducer messageProducer;

    public AuthController(UserService userService, RoleService roleService, MessageProducer messageProducer) {
        this.userService = userService;
        this.roleService = roleService;
        this.messageProducer = messageProducer;
    }

    @Autowired
    public void RabbitMQExampleApplication(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @Contract(pure = true)
    @GetMapping("index")
    public @NotNull String home() {
        return "index_new";

    }

    @Contract(pure = true)
    @GetMapping("/")
    public String index() {
        OrderObject orderObject = new OrderObject();
        orderObject.setID(1L);
        messageProducer.sendMessage("123456");
        String message = null;
        try {
            sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "login";
    }

    @Contract(pure = true)
    @GetMapping("/login")
    public String loginForm() {
        String message = null;
        MessageConsumer messageConsumer = new MessageConsumer();
        messageConsumer.processMessage(message);
        return "login";
    }

    // handler method to handle user registration request
    @GetMapping("register")
    public String showRegistrationForm(final @NotNull Model model) {
        UserDTO user = new UserDTO();
        List<Role> roles = roleService.findAllRoles();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);

        return "register";
    }

    // handler method to handle register user form submit request
    @PostMapping("/register/save")
    public String registration(final @Valid @ModelAttribute("user") @NotNull UserDTO userDto,
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
