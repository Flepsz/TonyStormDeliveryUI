package com.tonystorm.ui.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class APIGetObjectsUtil<T> {

    private final String endpoint;
    private final TypeReference<T> responseType;

    public APIGetObjectsUtil(String endpoint, TypeReference<T> responseType) {
        this.endpoint = endpoint;
        this.responseType = responseType;
    }

    public T getObject() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String responseJson = new APIRequestUtil(endpoint).sendGetRequest();
        return objectMapper.readValue(responseJson, responseType);
    }
}
