package com.telecom.services;

import com.telecom.entities.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserService {

    Mono<User> save(User user);
    Flux<User> findByMsisdn(List<String> msisdnList);
}
