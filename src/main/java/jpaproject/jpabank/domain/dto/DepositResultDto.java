package jpaproject.jpabank.domain.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DepositResultDto {

    private Long id;
    private String bank_name;
    private String item_name;
    private String depositPeriod;
    private Double interest_rate;

    private String preferential_condition;
    private Double preferential_interest_rate;

    private Integer moneyGoe;
    private Double moneyLoe;

    private String method;
    private String who;
    private String link;


    @QueryProjection
    public DepositResultDto(Long id, String bank_name, String item_name, String depositPeriod, Double interest_rate, String preferential_condition, Double preferential_interest_rate, Integer moneyGoe, Double moneyLoe, String method, String who, String link) {
        this.id = id;
        this.bank_name = bank_name;
        this.item_name = item_name;
        this.depositPeriod = depositPeriod;
        this.interest_rate = interest_rate;
        this.preferential_condition = preferential_condition;
        this.preferential_interest_rate = preferential_interest_rate;
        this.moneyGoe = moneyGoe;
        this.moneyLoe = moneyLoe;
        this.method = method;
        this.who = who;
        this.link = link;
    }
}
