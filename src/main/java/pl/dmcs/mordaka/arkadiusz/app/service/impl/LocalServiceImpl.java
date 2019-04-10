package pl.dmcs.mordaka.arkadiusz.app.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmcs.mordaka.arkadiusz.app.exception.LocalNotFoundException;
import pl.dmcs.mordaka.arkadiusz.app.exception.UserNotFoundException;
import pl.dmcs.mordaka.arkadiusz.app.model.Charge;
import pl.dmcs.mordaka.arkadiusz.app.model.Local;
import pl.dmcs.mordaka.arkadiusz.app.repository.ChargeRepository;
import pl.dmcs.mordaka.arkadiusz.app.repository.LocalRepository;
import pl.dmcs.mordaka.arkadiusz.app.repository.UserRepository;
import pl.dmcs.mordaka.arkadiusz.app.service.LocalService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LocalServiceImpl implements LocalService {

    private final LocalRepository localRepository;
    private final UserRepository userRepository;
    private final ChargeRepository chargeRepository;

    public LocalServiceImpl(LocalRepository localRepository, UserRepository userRepository, ChargeRepository chargeRepository) {
        this.localRepository = localRepository;
        this.userRepository = userRepository;
        this.chargeRepository = chargeRepository;
    }

    @Override
    public List<Local> getAllLocals() {
        return localRepository.findAll();
    }

    @Override
    public void registerLocal(Local local) {
        localRepository.save(local);
    }

    @Override
    public List<Local> getNotRentedLocals() {
        return localRepository.findAll().stream().filter(local -> !local.getIsRented()).collect(Collectors.toList());
    }

    @Override
    public List<Local> getUserLocals(String userId) {
        return localRepository.findLocalsByUser(userRepository.findByLogin(userId).orElseThrow(() -> new UserNotFoundException(userId))).orElseThrow(() -> new LocalNotFoundException(""));
    }

    @Override
    public void fillLocalCharge(Integer localId, Charge charge) {
        Local local = localRepository.findById(localId).orElseThrow(() -> new LocalNotFoundException(String.valueOf(localId)));
        charge.setIsFilled(true);
        local.getCharges().add(charge);
        chargeRepository.save(charge);
        localRepository.save(local);
    }
}
