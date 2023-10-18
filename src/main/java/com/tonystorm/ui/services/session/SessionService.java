package com.tonystorm.ui.services.session;

import com.tonystorm.ui.models.Endereco;
import com.tonystorm.ui.models.Localizacao;
import com.tonystorm.ui.models.Restaurante;
import com.tonystorm.ui.models.Usuario;

import java.util.UUID;

public class SessionService {
    public static Restaurante setRestauranteTemp() {
        Restaurante restaurante = new Restaurante();
        restaurante.setId(UUID.randomUUID());
        restaurante.setNome("tempRestaurante");
        restaurante.setSenha("0000");
        restaurante.setCNPJ("14308080000151");
        restaurante.setLocalizacao(new Localizacao(0, 0));

        return restaurante;
    }

    public static Usuario setUsuarioTemp() {
        Usuario usuario = new Usuario();
        usuario.setId(UUID.randomUUID());
        usuario.setNome("tempUsuario");
        usuario.setSenha("0000");
        usuario.setCPF("14981221088");
        usuario.setEndereco(new Endereco(0, 0));

        return usuario;
    }
}
