package pl.dmcs.mordaka.arkadiusz.app.exception;

import pl.dmcs.mordaka.arkadiusz.app.model.User;

public class UserNotFoundException extends AbstractNotFoundException {

    public UserNotFoundException(String code) {
        super(User.class, code);
    }
}
