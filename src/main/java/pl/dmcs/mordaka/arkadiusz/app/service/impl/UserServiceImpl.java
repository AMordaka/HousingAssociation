package pl.dmcs.mordaka.arkadiusz.app.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.dmcs.mordaka.arkadiusz.app.exception.LocalNotFoundException;
import pl.dmcs.mordaka.arkadiusz.app.exception.UserNotFoundException;
import pl.dmcs.mordaka.arkadiusz.app.model.ConfirmationToken;
import pl.dmcs.mordaka.arkadiusz.app.model.DTO.UserLocalDTO;
import pl.dmcs.mordaka.arkadiusz.app.model.Local;
import pl.dmcs.mordaka.arkadiusz.app.model.User;
import pl.dmcs.mordaka.arkadiusz.app.repository.ConfirmationTokenRepository;
import pl.dmcs.mordaka.arkadiusz.app.repository.LocalRepository;
import pl.dmcs.mordaka.arkadiusz.app.repository.UserRepository;
import pl.dmcs.mordaka.arkadiusz.app.service.MailSenderService;
import pl.dmcs.mordaka.arkadiusz.app.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final String REGISTERED_USER = "Rejestracja użytkownika";

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final LocalRepository localRepository;
    private final MailSenderService mailSenderService;
    private final ConfirmationTokenRepository tokenRepository;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, LocalRepository localRepository, MailSenderService mailSenderService, ConfirmationTokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.localRepository = localRepository;
        this.mailSenderService = mailSenderService;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(String.valueOf(id)));
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login).orElseThrow(() -> new UserNotFoundException(login));
    }

    @Override
    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        ConfirmationToken confirmationToken = new ConfirmationToken(user);
        tokenRepository.save(confirmationToken);
        mailSenderService.sendEmail(user.getEmail(), REGISTERED_USER, "Aby potwierdzić rejestrację proszę klinknąć na link : "
                + "http://localhost:8080/confirm-account?token=" + confirmationToken.getConfirmationToken());
    }

    @Override
    public String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getActivatedUsers() {
        return userRepository.findAll().stream().filter(User::getIsActive).collect(Collectors.toList());
    }

    @Override
    public void assignUserToLocal(UserLocalDTO dto) {
        User user = userRepository.findById(dto.getUser().getId()).orElseThrow(() -> new UserNotFoundException(String.valueOf(dto)));
        Local local = localRepository.findById(dto.getLocal().getId()).orElseThrow(() -> new LocalNotFoundException(String.valueOf(dto)));
        local.setUser(user);
        local.setIsRented(true);
        localRepository.save(local);
    }

    @Override
    public void validateToken(ConfirmationToken token) {
        if (token != null) {
            User user = token.getUser();
            user.setIsActive(true);
            userRepository.save(user);
        }
    }
}
