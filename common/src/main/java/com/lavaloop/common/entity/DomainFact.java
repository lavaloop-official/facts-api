package com.lavaloop.common.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class DomainFact {
    public String fact;
    public Date savedAt;
}
