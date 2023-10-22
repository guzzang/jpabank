package jpaproject.jpabank.domain.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResultUrlDto {

    private String link;

    @QueryProjection
    public ResultUrlDto(String link) {
        this.link = link;
    }
}
