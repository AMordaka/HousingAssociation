package pl.dmcs.mordaka.arkadiusz.app.service.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.dmcs.mordaka.arkadiusz.app.model.Role;
import pl.dmcs.mordaka.arkadiusz.app.model.User;
import pl.dmcs.mordaka.arkadiusz.app.service.CustomUserDetailsService;
import pl.dmcs.mordaka.arkadiusz.app.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    private final UserService userService;

    public CustomUserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.findByLogin(login);
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
        }
        return authorities;
    }

    @Override
    public UserDetails loadUserById(Long id) {
        return null;
    }
}
