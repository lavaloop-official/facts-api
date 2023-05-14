package com.lavaloop.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String fact;
    public Date savedAt;
}
