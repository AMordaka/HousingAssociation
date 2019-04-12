package pl.dmcs.mordaka.arkadiusz.app.service.impl;

import org.springframework.stereotype.Service;
import pl.dmcs.mordaka.arkadiusz.app.exception.ChargeNotFoundException;
import pl.dmcs.mordaka.arkadiusz.app.model.Charge;
import pl.dmcs.mordaka.arkadiusz.app.model.Local;
import pl.dmcs.mordaka.arkadiusz.app.repository.ChargeRepository;
import pl.dmcs.mordaka.arkadiusz.app.service.ChargeService;

import java.util.List;

@Service
public class ChargeServiceImpl implements ChargeService {

    private final ChargeRepository chargeRepository;

    public ChargeServiceImpl(ChargeRepository chargeRepository) {
        this.chargeRepository = chargeRepository;
    }

    @Override
    public List<Charge> getAllCharges() {
        return chargeRepository.findAll();
    }

    @Override
    public List<Charge> getChargesFromLocal(Local local) {
        return  chargeRepository.getAllByLocal(local).orElseThrow(() -> new ChargeNotFoundException(""));
    }
}
