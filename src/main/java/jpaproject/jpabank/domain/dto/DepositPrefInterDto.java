package jpaproject.jpabank.domain.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
public class DepositPrefInterDto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String item_name;
    private String preferential_condition;
    private Double preferential_interest_rate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deposit_id")
    private DepositDto depositDto;

    public DepositPrefInterDto(Long id, String item_name, String preferential_condition, Double preferential_interest_rate, DepositDto depositDto) {
        this.id = id;
        this.item_name = item_name;
        this.preferential_condition = preferential_condition;
        this.preferential_interest_rate = preferential_interest_rate;
        this.depositDto = depositDto;
    }
}
