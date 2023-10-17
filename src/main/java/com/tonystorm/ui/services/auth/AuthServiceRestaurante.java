package com.tonystorm.ui.services.auth;

import com.tonystorm.ui.models.Restaurante;

import java.util.List;

public class AuthServiceRestaurante {
    private final List<Restaurante> restaurantes;

    public AuthServiceRestaurante(List<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
    }

    public Restaurante authenticate(String nome, String senha) {
        for (Restaurante restaurante : restaurantes) {
            if (restaurante.getNome().equals(nome) && restaurante.getSenha().equals(senha)) {
                return restaurante;
            }
        }
        return null;
    }
}
