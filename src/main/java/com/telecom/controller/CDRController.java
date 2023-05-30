package com.telecom.controller;

import com.telecom.dto.cdr.CDRRequestDto;
import com.telecom.dto.cdr.CDRResponseDto;
import com.telecom.dto.mapper.CDRRequestMapper;
import com.telecom.dto.mapper.CDRResponseMapper;
import com.telecom.entities.CDR;
import com.telecom.services.CDRService;
import com.telecom.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.Duration;

@Slf4j
@RestController
@RequestMapping("/api/v1/cdr")
public class CDRController {

    private CDRService cdrService;

    private UserService userService;

    private CDRRequestMapper cdrRequestMapper;
    private CDRResponseMapper cdrResponseMapper;

    @Autowired
    public CDRController(CDRService cdrService,
                         UserService userService,
                         CDRRequestMapper cdrRequestMapper,
                         CDRResponseMapper cdrResponseMapper) {
        this.cdrService = cdrService;
        this.userService = userService;
        this.cdrRequestMapper = cdrRequestMapper;
        this.cdrResponseMapper = cdrResponseMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CDRResponseDto> create(@Valid @RequestBody final CDRRequestDto cdrRequestDto) {
        return this.cdrService.save(cdrRequestMapper.toEntity(cdrRequestDto))
                .map(cdr -> cdrResponseMapper.toDto(cdr))
                .doOnNext(dto -> log.debug("New CDR created: {}", dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<Void> delete(@PathVariable final String id) {
        return this.cdrService.deleteById(id);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<CDR> getAll() {
        return this.cdrService.findAll()
                .delayElements(Duration.ofSeconds(1))
                .doOnComplete(() -> log.debug("Returning all CDRs"));
    }

}
