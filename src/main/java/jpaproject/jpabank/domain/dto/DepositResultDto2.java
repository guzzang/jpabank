package jpaproject.jpabank.domain.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DepositResultDto2 {

    private Long id;
    private String preferential_condition;
    private Double preferential_interest_rate;

    @QueryProjection
    public DepositResultDto2(Long id, String preferential_condition, Double preferential_interest_rate) {
        this.id = id;
        this.preferential_condition = preferential_condition;
        this.preferential_interest_rate = preferential_interest_rate;
    }
}
