package com.tonystorm.ui.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.UUID;

public class APIGetID {
    public UUID get(String endpoint) throws Exception {
        String postRestaurante = new APIRequestUtil("/restaurantes").sendGetRequest();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseNode = objectMapper.readTree(postRestaurante);
        String restauranteIdStr = responseNode.get("id").asText();

        return UUID.fromString(restauranteIdStr);
    }
}
