package pl.dmcs.mordaka.arkadiusz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dmcs.mordaka.arkadiusz.app.model.Local;

public interface LocalRepository extends JpaRepository<Local, Integer> {
}
