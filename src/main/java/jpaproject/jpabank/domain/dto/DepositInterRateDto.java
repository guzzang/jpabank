package jpaproject.jpabank.domain.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
public class DepositInterRateDto {

    @Id
    private Long id;
    private String item_name;
    private String depositPeriod;
    private Double interest_rate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deposit_id")
    private DepositDto depositDto;

    public DepositInterRateDto(Long id, String item_name, String depositPeriod, Double interest_rate, DepositDto depositDto) {
        this.id = id;
        this.item_name = item_name;
        this.depositPeriod = depositPeriod;
        this.interest_rate = interest_rate;
        this.depositDto = depositDto;
    }
}
