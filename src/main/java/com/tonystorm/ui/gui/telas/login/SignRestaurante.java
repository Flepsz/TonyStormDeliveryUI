package com.tonystorm.ui.gui.telas.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignRestaurante extends JPanel {
    public SignRestaurante(TelaPrincipal telaPrincipal) {
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());

        JButton registrarButton = new JButton("Registrar");
        JButton loginButton = new JButton("Logar");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        buttonPanel.add(registrarButton, gbc);
        gbc.gridy = 1;
        buttonPanel.add(loginButton, gbc);

        add(buttonPanel, BorderLayout.CENTER);

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para abrir a tela de registro de restaurante
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaPrincipal.mostrarTela("LoginRestauranteT");
            }
        });

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaPrincipal.mostrarTela("TelaInicial");
            }
        });
        add(backButton, BorderLayout.NORTH);
    }
}