package pl.dmcs.mordaka.arkadiusz.app.exception;

import pl.dmcs.mordaka.arkadiusz.app.model.User;

public class TokenNotFoundException extends AbstractNotFoundException {

    public TokenNotFoundException(String code) {
        super(User.class, code);
    }
}
