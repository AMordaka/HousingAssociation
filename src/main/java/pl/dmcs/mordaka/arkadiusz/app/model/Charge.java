package pl.dmcs.mordaka.arkadiusz.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "CHARGE_T")
@AllArgsConstructor
@NoArgsConstructor
public class Charge extends BaseEntity {

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "VALUE", nullable = false)
    private Double value;

    @Column(name = "IS_REQUIRED", nullable = false)
    private Boolean isRequired;
}
