package jpaproject.jpabank;

import jpaproject.jpabank.domain.dto.DepositUrlDto;
import jpaproject.jpabank.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class CsvWriter4 implements ItemWriter<DepositUrlDto> {

    private final UrlRepository urlRepository;

    @Override
    public void write(List<? extends DepositUrlDto> list) throws Exception {
        urlRepository.saveAll(new ArrayList<DepositUrlDto>(list));

    }
}