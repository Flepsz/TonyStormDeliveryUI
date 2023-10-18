package com.tonystorm.ui.services.get;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tonystorm.ui.models.Pedido;
import com.tonystorm.ui.utils.APIGetObjectsUtil;

import java.util.List;

public class APIGetPedido {
    private final String idUsuario;

    public APIGetPedido(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    public List<Pedido> getAll() throws Exception {
        TypeReference<List<Pedido>> pedidoType = new TypeReference<List<Pedido>>() {};
        String endpoint = "/usuarios/" + idUsuario + "/pedidos";
        APIGetObjectsUtil<List<Pedido>> pedidoAPI = new APIGetObjectsUtil<>(endpoint, pedidoType);

        return pedidoAPI.getObject();
    }

    public Pedido getOne(String idPedido) throws Exception {
        TypeReference<Pedido> pedidoTypeone = new TypeReference<Pedido>() {};
        String endpoint = "/usuarios/" + idUsuario + "/pedidos/" + idPedido;
        APIGetObjectsUtil<Pedido> pedidoAPI = new APIGetObjectsUtil<>(endpoint, pedidoTypeone);

        return pedidoAPI.getObject();
    }

    public List<Pedido> getAllFromRestaurante() throws Exception {
        TypeReference<List<Pedido>> pedidoType = new TypeReference<List<Pedido>>() {};
        String endpoint = "/restaurantes/" + idUsuario + "/pedidos";
        APIGetObjectsUtil<List<Pedido>> pedidoAPI = new APIGetObjectsUtil<>(endpoint, pedidoType);

        return pedidoAPI.getObject();
    }
}
