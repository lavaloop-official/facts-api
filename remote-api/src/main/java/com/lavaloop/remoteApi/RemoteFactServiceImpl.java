package com.lavaloop.remoteApi;

import com.lavaloop.common.entity.DomainFact;
import com.lavaloop.common.remoteFacts.RemoteFactService;
import com.lavaloop.remoteApi.wsto.FactWsTo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RemoteFactServiceImpl implements RemoteFactService {

    private final RestTemplate restTemplate;

    @Override
    public DomainFact loadFact() {

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Api-Key", "iivI6jrNvTNTA8yrlA6rzlZlrLNa4SzwEwwPXJlT");
        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<Object> response
                = restTemplate
                .exchange(
                        "https://api.api-ninjas.com/v1/facts?limit={length}",
                        HttpMethod.GET,
                        entity,
                        Object.class,
                        1
                );

        ArrayList<LinkedHashMap<String, String>> body = (ArrayList<LinkedHashMap<String, String>>) response.getBody();
        return DomainFact
                .builder()
                .fact(body.get(0).get("fact"))
                .build();
    }
}
