package com.tonystorm.ui.services.get;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tonystorm.ui.models.Usuario;
import com.tonystorm.ui.utils.APIGetObjectsUtil;

import java.util.List;

public class APIGetUsuario {
    public List<Usuario> getAll() throws Exception {
        TypeReference<List<Usuario>> usuarioType = new TypeReference<List<Usuario>>() {};
        APIGetObjectsUtil<List<Usuario>> usuariosAPI = new APIGetObjectsUtil<>("/usuarios", usuarioType);

        return usuariosAPI.getObject();
    }

    public Usuario getOne(String idUsuario) throws Exception {
        TypeReference<Usuario> usuarioTypeone = new TypeReference<Usuario>() {};
        APIGetObjectsUtil<Usuario> usuarioAPI = new APIGetObjectsUtil<>("/usuarios/" + idUsuario, usuarioTypeone);

        return usuarioAPI.getObject();
    }
}
