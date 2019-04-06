package pl.dmcs.mordaka.arkadiusz.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.dmcs.mordaka.arkadiusz.app.model.Role;
import pl.dmcs.mordaka.arkadiusz.app.model.User;
import pl.dmcs.mordaka.arkadiusz.app.service.ReCaptchaService;
import pl.dmcs.mordaka.arkadiusz.app.service.RoleService;
import pl.dmcs.mordaka.arkadiusz.app.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class UserController {

    private static final String RECAPTCHA = "g-recaptcha-response";
    private static final String LIST_OF_USERS = "list_of_users";
    private static final String REGISTER = "register";

    private final UserService userService;
    private final RoleService roleService;
    private final ReCaptchaService reCaptchaService;

    public UserController(UserService userService, RoleService roleService, ReCaptchaService reCaptchaService) {
        this.userService = userService;
        this.roleService = roleService;
        this.reCaptchaService = reCaptchaService;
    }

    @ModelAttribute("roles")
    public List<Role> initializeProfiles() {
        return new ArrayList<>(roleService.findAll());
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(ModelMap model) {
        model.addAttribute("user", new User());
        return REGISTER;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@Valid User user, BindingResult result, ModelMap model, HttpServletRequest request) {
        if (result.hasErrors() || !reCaptchaService.verify(request.getParameter(RECAPTCHA))) {
            return REGISTER;
        }
        userService.registerUser(user);
        return LIST_OF_USERS;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listOfUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return LIST_OF_USERS;
    }
}
