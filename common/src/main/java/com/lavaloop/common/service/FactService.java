package com.lavaloop.common.service;

import com.lavaloop.common.entity.DomainFact;
import com.lavaloop.common.persistance.DomainFactRepository;
import com.lavaloop.common.remoteFacts.RemoteFactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FactService {

    //private final DomainFactRepository domainFactRepository;
    private final RemoteFactService remoteFactService;

    public String getFact(){
        return remoteFactService.loadFact().getFact();
    }

    public List<DomainFact> getStoredFacts(int maxFacts){
        return new ArrayList<>();
        //return domainFactRepository.getSavedFacts(maxFacts);
    }

    public boolean storeFact(DomainFact domainFact) {
        return true;
        //if ( !isValid(domainFact) ){
        //    return false;
        //}

        //domainFact.setSavedAt(new Date());

        //return domainFactRepository.store(domainFact);
    }

    private static boolean isValid(DomainFact domainFact){
        return domainFact != null || domainFact.getFact() == null || domainFact.getFact().isBlank();
    }
}
