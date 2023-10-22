package jpaproject.jpabank;

import jpaproject.jpabank.domain.dto.DepositDto;
import jpaproject.jpabank.repository.ItemdtoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class CsvWriter implements ItemWriter<DepositDto> {

    private final ItemdtoRepository itemdtoRepository;


    @Override
    public void write(List<? extends DepositDto> list) throws Exception {
        itemdtoRepository.saveAll(new ArrayList<DepositDto>(list));


    }
}

