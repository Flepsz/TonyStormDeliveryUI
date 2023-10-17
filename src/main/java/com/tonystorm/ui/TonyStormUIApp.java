package com.tonystorm.ui;

import com.tonystorm.ui.models.Restaurante;
import com.tonystorm.ui.services.get.APIGetRestaurante;
import com.tonystorm.ui.utils.APIRequestUtil;

import java.util.List;

public class TonyStormUIApp {
    public static void main(String[] args) throws Exception {
//        String resp = new APIRequestUtil("/restaurantes").sendGetRequest();
//        System.out.println(resp);
//        Restaurante restaurante1 = new Restaurante();
//        restaurante1.setNome("Caga Tronco's Bar");
//        restaurante1.setCNPJ("55183848000195");
//        restaurante1.setSenha("96969");
//        restaurante1.setLocalizacao(new Localizacao(22.2, 77.33));
//
//        String postRestaurante = new APIRequestUtil("/restaurantes").sendPostRequest(restaurante1);
//        System.out.println(postRestaurante);
        List<Restaurante> restaurantes = new APIGetRestaurante().getAll();
        Restaurante cgtronco = restaurantes.get(1);

        String endpoint = "/restaurantes/" + cgtronco.getId();
        System.out.println(endpoint);

        new APIRequestUtil(endpoint).sendDeleteRequest();
    }
}
