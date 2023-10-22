package jpaproject.jpabank;


import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing // 배치 사용을 위한 선언 
@SpringBootApplication
public class JpabankApplication {

	public static void main(String[] args) {SpringApplication.run(JpabankApplication.class, args);


	}


}
