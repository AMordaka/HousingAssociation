package pl.dmcs.mordaka.arkadiusz.app.model;

import lombok.Getter;

@Getter
public enum RoleType {
    USER("USER"),
    ADMIN("ADMIN"),
    DEALER("DEALER");

    String role;

    private RoleType(String roleType) {
        this.role = roleType;
    }
}
