package pl.dmcs.mordaka.arkadiusz.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Set;

@Data
@Entity
@Table(name = "BUILDING_T")
@AllArgsConstructor
@NoArgsConstructor
public class Building extends BaseEntity {

    private String address;

    @OneToMany
    private Set<Local> locals;
}
