package pl.dmcs.mordaka.arkadiusz.app.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.dmcs.mordaka.arkadiusz.app.exception.UserNotFoundException;
import pl.dmcs.mordaka.arkadiusz.app.model.User;
import pl.dmcs.mordaka.arkadiusz.app.repository.UserRepository;

@Component
public class UserToUserView implements Converter<Object, User> {

    private static final Logger logger = LoggerFactory.getLogger(UserToUserView.class);

    private final UserRepository userRepository;

    public UserToUserView(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User convert(Object element) {
        Integer id = Integer.parseInt((String) element);
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(String.valueOf(id)));
        logger.info("User : {}", user);
        return user;
    }
}
