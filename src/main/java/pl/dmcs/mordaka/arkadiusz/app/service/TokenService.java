package pl.dmcs.mordaka.arkadiusz.app.service;

import pl.dmcs.mordaka.arkadiusz.app.model.ConfirmationToken;

public interface TokenService {

    ConfirmationToken findByConfirmationToken(String confirmationToken);
}

