package pl.dmcs.mordaka.arkadiusz.app.exception;

import pl.dmcs.mordaka.arkadiusz.app.model.User;

public class ChargeNotFoundException extends AbstractNotFoundException {

    public ChargeNotFoundException(String code) {
        super(User.class, code);
    }
}
