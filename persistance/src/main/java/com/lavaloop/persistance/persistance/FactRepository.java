package com.lavaloop.persistance.persistance;


import com.lavaloop.persistance.entity.Fact;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FactRepository extends JpaRepository<Fact, Long> {
    List<Fact> findAll();

    List<Fact> findAllByOrderBySavedAtDesc(Pageable pageable);
}
