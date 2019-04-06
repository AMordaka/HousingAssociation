package pl.dmcs.mordaka.arkadiusz.app.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class AppController {

    private static final String LOGIN = "login";
    private static final String REGISTER = "register";
    private static final String REDIRECT_HOMEPAGE = "redirect:/";
    private static final String RECAPTCHA = "g-recaptcha-response";

    private final UserService userService;
    private final RoleService roleService;
    private final AuthenticationTrustResolver authenticationTrustResolver;
    private final ReCaptchaService reCaptchaService;

    public AppController(UserService userService, RoleService roleService, AuthenticationTrustResolver authenticationTrustResolver, ReCaptchaService reCaptchaService) {
        this.userService = userService;
        this.roleService = roleService;
        this.authenticationTrustResolver = authenticationTrustResolver;
        this.reCaptchaService = reCaptchaService;
    }

    @ModelAttribute("roles")
    public List<Role> initializeProfiles() {
        return new ArrayList<>(roleService.findAll());
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(ModelMap model) {
        if (isCurrentAuthenticationAnonymous()) {
            return LOGIN;
        }
        return REDIRECT_HOMEPAGE;
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
        return LOGIN;
    }

    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }
}


