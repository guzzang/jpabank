package jpaproject.jpabank;

import jpaproject.jpabank.domain.dto.DepositPrefInterDto;
import jpaproject.jpabank.repository.PrefInterRateDtoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class CsvWriter3 implements ItemWriter<DepositPrefInterDto> {

    private final PrefInterRateDtoRepository prefInterRateDtoRepository;

    @Override
    public void write(List<? extends DepositPrefInterDto> list) throws Exception {
        prefInterRateDtoRepository.saveAll(new ArrayList<DepositPrefInterDto>(list));

    }
}