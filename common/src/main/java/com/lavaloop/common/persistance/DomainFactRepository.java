package com.lavaloop.common.persistance;

import com.lavaloop.common.entity.DomainFact;

import java.util.List;

public interface DomainFactRepository {
    List<DomainFact> getAll();
    boolean store(DomainFact fact);

    List<DomainFact> getSavedFacts(int maxFacts);
}
