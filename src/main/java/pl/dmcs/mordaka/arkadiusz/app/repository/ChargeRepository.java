package pl.dmcs.mordaka.arkadiusz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dmcs.mordaka.arkadiusz.app.model.Charge;
import pl.dmcs.mordaka.arkadiusz.app.model.Local;

import java.util.List;
import java.util.Optional;

public interface ChargeRepository extends JpaRepository<Charge, Integer> {

    Optional<List<Charge>> getAllByLocal(Local local);
}
