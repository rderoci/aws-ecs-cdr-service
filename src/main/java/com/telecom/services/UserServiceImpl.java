package com.telecom.services;

import com.telecom.entities.User;
import com.telecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Mono<User> save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public Flux<User> findByMsisdn(List<String> msisdnList) {
        return null;
    }

}
