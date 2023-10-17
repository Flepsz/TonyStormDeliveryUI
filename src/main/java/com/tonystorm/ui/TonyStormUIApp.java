package com.tonystorm.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tonystorm.ui.models.Localizacao;
import com.tonystorm.ui.models.Restaurante;
import com.tonystorm.ui.utils.APIRequestUtil;

public class TonyStormUIApp {
    public static void main(String[] args) throws Exception {
        String resp = new APIRequestUtil("/restaurantes").sendGetRequest();
        System.out.println(resp);
        Restaurante restaurante1 = new Restaurante();
        restaurante1.setNome("Cagaa Tronco's Bar");
        restaurante1.setCNPJ("55183848000195");
        restaurante1.setSenha("96969");
        restaurante1.setLocalizacao(new Localizacao(22.2, 77.33));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String restauranteJson = objectWriter.writeValueAsString(restaurante1);

        System.out.println(restauranteJson);

        String postRestaurante = new APIRequestUtil("/restaurantes").sendPostRequest(restauranteJson);
        System.out.println(postRestaurante);
    }
}
