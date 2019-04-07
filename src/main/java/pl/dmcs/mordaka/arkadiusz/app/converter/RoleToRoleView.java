package pl.dmcs.mordaka.arkadiusz.app.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.dmcs.mordaka.arkadiusz.app.model.Role;
import pl.dmcs.mordaka.arkadiusz.app.service.RoleService;

@Component
public class RoleToRoleView implements Converter<Object, Role> {

    private static final Logger logger = LoggerFactory.getLogger(RoleToRoleView.class);

    private final RoleService roleService;

    public RoleToRoleView(RoleService roleService) {
        this.roleService = roleService;
    }


    public Role convert(Object element) {
        Integer id = Integer.parseInt((String) element);
        Role role = roleService.findById(id);
        logger.info("Role : {}", role);
        return role;
    }
}
