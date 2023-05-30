package com.telecom.repository;

import com.telecom.entities.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface UserRepository extends ReactiveCrudRepository<User, String> {

    Flux<User> findByTaxId(Flux<String> taxId);

}
