package pl.dmcs.mordaka.arkadiusz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dmcs.mordaka.arkadiusz.app.model.Building;

public interface BuildingRepository extends JpaRepository<Building, Integer> {
}
