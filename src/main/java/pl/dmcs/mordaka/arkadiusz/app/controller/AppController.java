package pl.dmcs.mordaka.arkadiusz.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.dmcs.mordaka.arkadiusz.app.model.Address;
import pl.dmcs.mordaka.arkadiusz.app.model.Role;
import pl.dmcs.mordaka.arkadiusz.app.model.User;
import pl.dmcs.mordaka.arkadiusz.app.service.RoleService;
import pl.dmcs.mordaka.arkadiusz.app.service.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {

    private static final String LOGIN = "login";
    private static final String REGISTER = "register";
    private static final String REDIRECT_HOMEPAGE = "redirect:/";

    private final UserService userService;
    private final RoleService roleService;

    public AppController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @ModelAttribute("roles")
    public List<Role> initializeProfiles() {
        return new ArrayList<>(roleService.findAll());
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return LOGIN;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return REGISTER;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@Valid User user, BindingResult result, ModelMap model){
        if (result.hasErrors()) {
            return REGISTER;
        }
        userService.registerUser(user);
        return LOGIN;
    }
}


