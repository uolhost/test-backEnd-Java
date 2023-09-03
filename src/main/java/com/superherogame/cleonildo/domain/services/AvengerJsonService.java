package com.superherogame.cleonildo.domain.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.superherogame.cleonildo.api.dto.response.AvengerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvengerJsonService {
    private final RestTemplate template;
    private static final String URL = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json";

    public AvengerJsonService(RestTemplate template) {
        this.template = template;
    }

    public List<AvengerResponse> getAvengersCodeNames() throws JsonProcessingException {
        ResponseEntity<String> response = template.getForEntity(URL, String.class);
        String responseBody = response.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(responseBody);
        JsonNode avengersNode = rootNode.get("vingadores");

        List<AvengerResponse> avengersList = new ArrayList<>();
        if (avengersNode != null && avengersNode.isArray()) {
            for (JsonNode avengerNode : avengersNode) {
                String codinome = avengerNode.get("codinome").asText();
                AvengerResponse avengerResponse = new AvengerResponse(codinome);
                avengersList.add(avengerResponse);
            }
        }

        return avengersList;
    }
}
