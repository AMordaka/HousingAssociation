package pl.dmcs.mordaka.arkadiusz.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Entity
@Table(name = "LOCAL_T")
@AllArgsConstructor
@NoArgsConstructor
public class Local extends BaseEntity {

    @NotEmpty
    @Column(name = "NUMBER", unique = true, nullable = false)
    private String number;

    @Column(name = "IS_HOUSING", nullable = false)
    private Boolean isHousing;

    @Column(name = "SURFACE_AREA", nullable = false)
    private String surfaceArea;

    @OneToMany
    private Set<Charge> charges;
}
