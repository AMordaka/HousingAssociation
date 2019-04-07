package pl.dmcs.mordaka.arkadiusz.app.exception;

import pl.dmcs.mordaka.arkadiusz.app.model.User;

public class LocalNotFoundException extends AbstractNotFoundException {

    public LocalNotFoundException(String code) {
        super(User.class, code);
    }
}
