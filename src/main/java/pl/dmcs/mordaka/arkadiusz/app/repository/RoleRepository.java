package pl.dmcs.mordaka.arkadiusz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dmcs.mordaka.arkadiusz.app.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
