package com.tonystorm.ui.services.get;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tonystorm.ui.models.Comida;
import com.tonystorm.ui.utils.APIGetObjectsUtil;

import java.util.List;

public class APIGetPedido {
    private final String idUsuario;

    public APIGetPedido(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    public List<Comida> getAll() throws Exception {
        TypeReference<List<Comida>> comidaType = new TypeReference<List<Comida>>() {};
        String endpoint = "/usuarios/" + idUsuario + "/pedidos";
        APIGetObjectsUtil<List<Comida>> comidaAPI = new APIGetObjectsUtil<>(endpoint, comidaType);

        return comidaAPI.getObject();
    }

    public Comida getOne(String idComida) throws Exception {
        TypeReference<Comida> comidaTypeone = new TypeReference<Comida>() {};
        String endpoint = "/usuarios/" + idUsuario + "/pedidos/" + idComida;
        APIGetObjectsUtil<Comida> comidaAPI = new APIGetObjectsUtil<>(endpoint, comidaTypeone);

        return comidaAPI.getObject();
    }
}
