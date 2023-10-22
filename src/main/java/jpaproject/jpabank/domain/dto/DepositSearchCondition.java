package jpaproject.jpabank.domain.dto;

import lombok.Data;

@Data
public class DepositSearchCondition {

    private Integer moneyGoe;
    private String depositPeriod;
    private String preferentialTerms;
    private String itemName;
}
