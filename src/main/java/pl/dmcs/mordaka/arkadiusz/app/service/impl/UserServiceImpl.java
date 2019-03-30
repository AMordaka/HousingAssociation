package pl.dmcs.mordaka.arkadiusz.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.dmcs.mordaka.arkadiusz.app.exception.UserNotFoundException;
import pl.dmcs.mordaka.arkadiusz.app.model.User;
import pl.dmcs.mordaka.arkadiusz.app.repository.AddressRepository;
import pl.dmcs.mordaka.arkadiusz.app.repository.UserRepository;
import pl.dmcs.mordaka.arkadiusz.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public UserServiceImpl(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login).orElseThrow(() -> new UserNotFoundException(login));
    }

    @Override
    public void registerUser(User user) {
        userRepository.save(user);
    }
}
