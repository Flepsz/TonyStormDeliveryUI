package com.tonystorm.ui.gui.telas.login;

import com.tonystorm.ui.gui.telas.TelaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUsuario extends JPanel {
    public SignUsuario(TelaPrincipal telaPrincipal) {
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());

        JButton registrarButton = new JButton("Registrar");
        registrarButton.setFont(new Font("Arial", Font.BOLD, 16));
        registrarButton.setBackground(Color.WHITE);
        registrarButton.setForeground(Color.BLACK);
        registrarButton.setMargin(new Insets(10, 20, 10, 20));

        JButton loginButton = new JButton("Logar");
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setBackground(Color.WHITE);
        loginButton.setForeground(Color.BLACK);
        loginButton.setMargin(new Insets(10, 20, 10, 20));

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
                telaPrincipal.mostrarTela("RegistrarUsuarioT");
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaPrincipal.mostrarTela("LoginUsuarioT");
            }
        });

        JPanel backButtonPanel = telaPrincipal.getBackButton("TelaInicial");
        add(backButtonPanel, BorderLayout.NORTH);
    }
}
