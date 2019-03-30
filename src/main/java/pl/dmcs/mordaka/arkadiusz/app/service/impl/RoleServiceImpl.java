package pl.dmcs.mordaka.arkadiusz.app.service.impl;

import org.springframework.stereotype.Service;
import pl.dmcs.mordaka.arkadiusz.app.exception.RoleNotFoundException;
import pl.dmcs.mordaka.arkadiusz.app.model.Role;
import pl.dmcs.mordaka.arkadiusz.app.repository.RoleRepository;
import pl.dmcs.mordaka.arkadiusz.app.service.RoleService;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Set<Role> findAll() {
        return new HashSet<>(roleRepository.findAll());
    }

    @Override
    public Role findById(Integer roleId) {
        return roleRepository.findById(roleId).orElseThrow(() -> new RoleNotFoundException(String.valueOf(roleId)));
    }
}
