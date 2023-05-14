package com.lavaloop.persistance.persistance;

import com.lavaloop.common.entity.DomainFact;
import com.lavaloop.common.persistance.DomainFactRepository;
import com.lavaloop.persistance.entity.Fact;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FactRepositoryWrapper implements DomainFactRepository {

    private final FactRepository factRepository;

    @Override
    public List<DomainFact> getAll() {
        List<Fact> all = factRepository.findAll();
        return map(all);
    }

    @Override
    public boolean store(DomainFact fact) {
        Fact save = factRepository.save(map(fact));

        return save != null;
    }

    @Override
    public List<DomainFact> getSavedFacts(int maxFacts) {
        Pageable pageable = PageRequest.of(0, maxFacts);
        List<Fact> all = factRepository.findAllByOrderBySavedAtDesc(pageable);
        return map(all);
    }

    private static List<DomainFact> map(List<Fact> facts){
        List<DomainFact> domainFacts = new ArrayList<>();
        for(Fact fact: facts){
            domainFacts.add(map(fact));
        }
        return domainFacts;
    }

    private static DomainFact map(Fact fact){
        return DomainFact
                .builder()
                .savedAt(fact.getSavedAt())
                .fact(fact.getFact())
                .build();
    }

    private static Fact map(DomainFact fact){
        return Fact
                .builder()
                .savedAt(fact.getSavedAt())
                .fact(fact.getFact())
                .build();
    }
}
