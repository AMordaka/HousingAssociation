package pl.dmcs.mordaka.arkadiusz.app.service;

import pl.dmcs.mordaka.arkadiusz.app.model.Charge;
import pl.dmcs.mordaka.arkadiusz.app.model.Local;

import java.util.List;

public interface LocalService {

    List<Local> getAllLocals();

    void registerLocal(Local local);

    List<Local> getNotRentedLocals();

    List<Local> getUserLocals(String userId);

    void fillLocalCharge(Integer localId, Charge charge);

    Charge findLatestChargeFromLocal(Integer localId);

    void confirmCharges(Integer localId, Charge charge);

    Local getLocalById(Integer localId);

    void generateAmounts();

    void acceptAllCharges();
}
