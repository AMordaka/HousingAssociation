package pl.dmcs.mordaka.arkadiusz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dmcs.mordaka.arkadiusz.app.model.Local;
import pl.dmcs.mordaka.arkadiusz.app.model.User;

import java.util.List;
import java.util.Optional;

public interface LocalRepository extends JpaRepository<Local, Integer> {

    Optional<List<Local>> findLocalsByUser(User user);
}
