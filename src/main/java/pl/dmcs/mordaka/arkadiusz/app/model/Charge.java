package pl.dmcs.mordaka.arkadiusz.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "CHARGE_T")
@AllArgsConstructor
@NoArgsConstructor
public class Charge extends BaseEntity {

    @Column(name = "DATE_TIME")
    private LocalDate date = LocalDate.now();

    @Column(name = "ELECTRICITY", nullable = false)
    private Double electricity;

    @Column(name = "GAS", nullable = false)
    private Double gas;

    @Column(name = "COLD_WATER", nullable = false)
    private Double coldWater;

    @Column(name = "HOT_WATER", nullable = false)
    private Double hotWater;

    @Column(name = "SEWAGE", nullable = false)
    private Double sewage;

    @Column(name = "FUND_RENOVATION", nullable = false)
    private Double foundRenovation;

    @Column(name = "IS_FILLED")
    private Boolean isFilled;

    @Column(name = "IS_ACCEPTED")
    private Boolean isAccepted;
}
