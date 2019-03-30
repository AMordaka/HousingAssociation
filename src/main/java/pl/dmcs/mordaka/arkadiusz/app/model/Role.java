package pl.dmcs.mordaka.arkadiusz.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "ROLE_T")
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseEntity {

    @NotEmpty
    @Column(name = "ROLE", unique = true, nullable = false)
    private String role = RoleType.ADMIN.getRole();

    @Override
    public String toString() {
        return this.role;
    }
}
