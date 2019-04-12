package pl.dmcs.mordaka.arkadiusz.app.service;

import pl.dmcs.mordaka.arkadiusz.app.model.Charge;
import pl.dmcs.mordaka.arkadiusz.app.model.Local;

import java.util.List;

public interface ChargeService {

    List<Charge> getAllCharges();

    List<Charge> getChargesFromLocal(Local local);
}
