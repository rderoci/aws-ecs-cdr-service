package com.telecom.repository;

import com.telecom.entities.CDR;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CDRRepository extends ReactiveCrudRepository<CDR, String> {

    Flux<CDR> findByMsisdnFrom(Mono<String> msisdnCaller);

}
