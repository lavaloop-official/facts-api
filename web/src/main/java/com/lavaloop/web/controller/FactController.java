package com.lavaloop.web.controller;

import com.lavaloop.common.entity.DomainFact;
import com.lavaloop.common.service.FactService;
import com.lavaloop.web.wsto.FactWsTo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class FactController {

    private final FactService factService;

    @GetMapping("/facts")
    public ResponseEntity getFacts(){
        String fact = factService.getFact();

        FactWsTo factWsTo = FactWsTo
                .builder()
                .fact(fact)
                .build();

        return new ResponseEntity<>(factWsTo, HttpStatus.OK);
    }

    @PostMapping("/facts")
    public ResponseEntity postFacts(@RequestBody FactWsTo factWsTo){
        DomainFact domainFact = DomainFact
                .builder()
                .fact(factWsTo.getFact())
                .build();

        boolean success = factService.storeFact(domainFact);

        return new ResponseEntity<>(success, HttpStatus.OK);
    }

    @GetMapping("/saved-facts")
    public ResponseEntity getStoredFacts(@RequestParam int maxFacts){
        List<DomainFact> storedFacts = factService.getStoredFacts(maxFacts);

        List<FactWsTo> factWsTos = new ArrayList<>();
        for(DomainFact domainFact: storedFacts){
            factWsTos.add(
                    new FactWsTo(domainFact.getFact())
            );
        }

        return new ResponseEntity<>(factWsTos, HttpStatus.OK);
    }
}
