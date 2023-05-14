package com.lavaloop.remoteApi.wsto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record FactWsTo (List<String> fact){

}
