package com.telecom.services;

import com.telecom.entities.CDR;
import com.telecom.repository.CDRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CDRServiceImpl implements CDRService {

    private CDRRepository cdrRepository;

    private UserService userService;

    @Autowired
    public CDRServiceImpl(CDRRepository cdrRepository,
                          UserService userService) {
        this.cdrRepository = cdrRepository;
        this.userService = userService;
    }

    @Override
    public Mono<CDR> save(CDR cdr) {
        return this.cdrRepository.save(cdr);
    }

    @Override
    public Mono<CDR> findById(String id) {
        return this.cdrRepository.findById(id);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return this.cdrRepository.deleteById(id);
    }

    @Override
    public Flux<CDR> findAll() {
        return this.cdrRepository.findAll();
    }

    @Override
    public Flux<CDR> findByMsisdnFrom(String msisdnFrom) {
        return this.cdrRepository.findByMsisdnFrom(Mono.just(msisdnFrom));
    }
}
