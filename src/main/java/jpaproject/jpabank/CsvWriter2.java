package jpaproject.jpabank;

import jpaproject.jpabank.domain.dto.DepositInterRateDto;
import jpaproject.jpabank.repository.InterRateDtoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class CsvWriter2 implements ItemWriter<DepositInterRateDto> {

    private final InterRateDtoRepository interRateDtoRepository;


    @Override
    public void write(List<? extends DepositInterRateDto> list) throws Exception {
        interRateDtoRepository.saveAll(new ArrayList<DepositInterRateDto>(list));


    }
}

