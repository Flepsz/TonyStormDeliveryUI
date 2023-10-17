package com.tonystorm.ui.services.auth;

import com.tonystorm.ui.models.Usuario;

import java.util.List;

public class AuthServiceUsuario {
    private final List<Usuario> usuarios;

    public AuthServiceUsuario(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario authenticate(String username, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(username) && usuario.getSenha().equals(password)) {
                return usuario;
            }
        }
        return null;
    }
}