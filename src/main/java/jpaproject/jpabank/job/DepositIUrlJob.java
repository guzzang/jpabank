package jpaproject.jpabank.job;

import jpaproject.jpabank.CsvReader4;
import jpaproject.jpabank.CsvWriter4;
import jpaproject.jpabank.domain.dto.DepositUrlDto;
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
public class DepositIUrlJob {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final CsvReader4 csvReader4;
    private final CsvWriter4 csvWriter4;
    private static final int chunkSize = 1000;

    @Bean("depositUrlJob")
    public Job csvFileItemReaderJob(){
        return jobBuilderFactory.get("depositUrlJob")
                .start(csvFileItemReaderStep())
                .build();

    }

    @Bean("DepositUrlJobStep")
    public Step csvFileItemReaderStep(){
        return stepBuilderFactory.get("DepositUrlJobStep")
                .<DepositUrlDto, DepositUrlDto>chunk(chunkSize)
                .reader(csvReader4.csvFileItemReader())
                .writer(csvWriter4)
                .allowStartIfComplete(true)
                .build();
    }



}






