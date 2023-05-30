package com.telecom.config;

import com.telecom.entities.CDR;
import com.telecom.repository.CDRRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;

@Configuration
public class MongoConfig {

    @Bean
    CommandLineRunner commandLineRunner(CDRRepository cdrRepository) {
        return strings -> {
            cdrRepository.save(CDR.newInstance("5521999999991",
                    "5521999999992",
                    LocalDate.now().minus(1, ChronoUnit.DAYS),
                    LocalTime.now().minus(1, ChronoUnit.HOURS)));
            cdrRepository.save(CDR.newInstance("5521999999992",
                    "5521999999991",
                    LocalDate.now(),
                    LocalTime.now()));
        };
    }

}
