package pl.dmcs.mordaka.arkadiusz.app.service;

import pl.dmcs.mordaka.arkadiusz.app.model.Role;

import java.util.Set;

public interface RoleService {

    Set<Role> findAll();

    Role findById(Integer roleId);
}
