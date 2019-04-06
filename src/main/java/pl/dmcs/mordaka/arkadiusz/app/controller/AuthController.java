package pl.dmcs.mordaka.arkadiusz.app.controller;

import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class AuthController {

    private static final String LOGIN = "login";
    private static final String REDIRECT_HOMEPAGE = "redirect:/";

    private final AuthenticationTrustResolver authenticationTrustResolver;


    public AuthController(AuthenticationTrustResolver authenticationTrustResolver) {
        this.authenticationTrustResolver = authenticationTrustResolver;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        if (isCurrentAuthenticationAnonymous()) {
            return LOGIN;
        }
        return REDIRECT_HOMEPAGE;
    }

    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }
}


