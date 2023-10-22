package jpaproject.jpabank.job;

import jpaproject.jpabank.CsvReader3;
import jpaproject.jpabank.CsvWriter3;
import jpaproject.jpabank.domain.dto.DepositPrefInterDto;
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
public class DepositPreferCondJob {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final CsvReader3 csvReader3;
    private final CsvWriter3 csvWriter3;
    private static final int chunkSize = 1000;

    @Bean("depositPrefInterJob")
    public Job csvFileItemReaderJob(){
        return jobBuilderFactory.get("csvFileItemReaderJob")
                .start(csvFileItemReaderStep())
                .build();

    }

    @Bean("DepositPrefInterJobStep")
    public Step csvFileItemReaderStep(){
        return stepBuilderFactory.get("csvFileItemReaderStep")
                .<DepositPrefInterDto, DepositPrefInterDto>chunk(chunkSize)
                .reader(csvReader3.csvFileItemReader())
                .writer(csvWriter3)
                .allowStartIfComplete(true)
                .build();
    }


}
