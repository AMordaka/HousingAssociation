package pl.dmcs.mordaka.arkadiusz.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ADDRESS_T")
@AllArgsConstructor
@NoArgsConstructor
public class Address extends BaseEntity {

    @Column(name = "STREET", nullable = false)
    private String street;

    @Column(name = "NUMBER_STREET", nullable = false)
    private String numberStreet;

    @Column(name = "POSTAL_CODE", nullable = false)
    private String postalCode;

    @Column(name = "CITY", nullable = false)
    private String city;
}
