package com.telecom.services;

import com.telecom.entities.CDR;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CDRService {

    Mono<CDR> save(CDR cdr);
    Mono<CDR> findById(String id);
    Mono<Void> deleteById(String id);
    Flux<CDR> findAll();
    Flux<CDR> findByMsisdnFrom(String msisdnFrom);
}
