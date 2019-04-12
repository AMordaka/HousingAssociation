package pl.dmcs.mordaka.arkadiusz.app.service.impl;

import org.springframework.stereotype.Service;
import pl.dmcs.mordaka.arkadiusz.app.exception.TokenNotFoundException;
import pl.dmcs.mordaka.arkadiusz.app.model.ConfirmationToken;
import pl.dmcs.mordaka.arkadiusz.app.repository.ConfirmationTokenRepository;
import pl.dmcs.mordaka.arkadiusz.app.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService {

    private final ConfirmationTokenRepository tokenRepository;

    public TokenServiceImpl(ConfirmationTokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public ConfirmationToken findByConfirmationToken(String confirmationToken) {
        return tokenRepository.findByConfirmationToken(confirmationToken).orElseThrow(() -> new TokenNotFoundException(confirmationToken));
    }
}
