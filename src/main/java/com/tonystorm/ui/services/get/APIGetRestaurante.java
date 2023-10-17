package com.tonystorm.ui.services.get;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tonystorm.ui.models.Restaurante;
import com.tonystorm.ui.utils.APIGetObjectsUtil;

import java.util.List;

public class APIGetRestaurante {
    public List<Restaurante> getAll() throws Exception {
        TypeReference<List<Restaurante>> restauranteType = new TypeReference<List<Restaurante>>() {};
        APIGetObjectsUtil<List<Restaurante>> restaurantesAPI = new APIGetObjectsUtil<>("/restaurantes", restauranteType);

        return restaurantesAPI.getObject();
    }

    public Restaurante getOne(String idRestaurante) throws Exception {
        TypeReference<Restaurante> restauranteTypeone = new TypeReference<Restaurante>() {};
        APIGetObjectsUtil<Restaurante> restauranteAPI = new APIGetObjectsUtil<>("/restaurantes/" + idRestaurante, restauranteTypeone);

        return restauranteAPI.getObject();
    }
}
