package jpaproject.jpabank.domain.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
public class DepositDto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deposit_id")
    private Long id;
    private String item_name;
    private String bank_name;
    private Integer moneyGoe;
    private Double moneyLoe;
    private String method;
    private String who;

    public DepositDto(Long id, String item_name, String bank_name, Integer moneyGoe, Double moneyLoe, String method, String who) {
        this.id = id;
        this.item_name = item_name;
        this.bank_name = bank_name;
        this.moneyGoe = moneyGoe;
        this.moneyLoe = moneyLoe;
        this.method = method;
        this.who = who;
    }

}
