package jpaproject.jpabank.job;

import jpaproject.jpabank.CsvReader2;
import jpaproject.jpabank.CsvWriter2;
import jpaproject.jpabank.domain.dto.DepositInterRateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
@RequiredArgsConstructor
public class DepositInterRateJob {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final CsvReader2 csvReader2;
    private final CsvWriter2 csvWriter2;
    private static final int chunkSize = 1000;

    @Bean("depositInterJob")
    public Job csvFileItemReaderJob(){
        return jobBuilderFactory.get("depositInterJob")
                .start(csvFileItemReaderStep())
                .build();

    }

    @Bean("DepositInterJobStep")
    public Step csvFileItemReaderStep(){
        return stepBuilderFactory.get("DepositInterJobStep")
                .<DepositInterRateDto, DepositInterRateDto>chunk(chunkSize)
                .reader(csvReader2.csvFileItemReader())
                .writer(csvWriter2)
                .allowStartIfComplete(true)
                .build();
    }



}






