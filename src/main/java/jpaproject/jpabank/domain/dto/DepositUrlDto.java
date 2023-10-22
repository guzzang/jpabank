package jpaproject.jpabank.domain.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
public class DepositUrlDto {

    @Id
    private Long id;
    private String item_name;
    private String link;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deposit_id")
    private DepositDto depositDto;

    public DepositUrlDto(Long id, String item_name, String link, DepositDto depositDto) {
        this.id = id;
        this.item_name = item_name;
        this.link = link;
        this.depositDto = depositDto;
    }
}
