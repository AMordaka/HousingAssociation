package pl.dmcs.mordaka.arkadiusz.app.exception;

import pl.dmcs.mordaka.arkadiusz.app.model.User;

public class RoleNotFoundException extends AbstractNotFoundException {

    public RoleNotFoundException(String code) {
        super(User.class, code);
    }
}
