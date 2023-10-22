package jpaproject.jpabank.job;

import jpaproject.jpabank.CsvReader;
import jpaproject.jpabank.CsvWriter;
import jpaproject.jpabank.domain.dto.DepositDto;
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
public class DepositJobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private final CsvReader csvReader;
    private final CsvWriter csvWriter;

    private static final int chunkSize = 1000;

    @Bean("depositJob")
    public Job csvFileItemReaderJob(){
        return jobBuilderFactory.get("csvFileItemReaderJob")
                .start(csvFileItemReaderStep())
                .build();

    }

    @Bean("DepositJobStep")
    public Step csvFileItemReaderStep(){
        return stepBuilderFactory.get("csvFileItemReaderStep")
                .<DepositDto, DepositDto>chunk(chunkSize)
                .reader(csvReader.csvFileItemReader())
                .writer(csvWriter)
                .allowStartIfComplete(true)
                .build();
    }





}
