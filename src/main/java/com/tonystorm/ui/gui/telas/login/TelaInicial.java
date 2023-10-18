package com.tonystorm.ui.gui.telas.login;

import com.tonystorm.ui.gui.telas.TelaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JPanel {
    public TelaInicial(TelaPrincipal telaPrincipal) {
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 40, 10);

        JLabel titleLabel = new JLabel("TonyStorm Delivery");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        JLabel quemVoceELabel = new JLabel("Quem você é?");
        quemVoceELabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(quemVoceELabel, gbc);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcBtn = new GridBagConstraints();
        gbcBtn.insets = new Insets(10, 10, 10, 10);

        JButton usuarioButton = new JButton("Usuário");
        usuarioButton.setFont(new Font("Arial", Font.BOLD, 16));
        usuarioButton.setBackground(Color.WHITE);
        usuarioButton.setForeground(Color.BLACK);
        usuarioButton.setMargin(new Insets(10, 20, 10, 20));

        JButton restauranteButton = new JButton("Restaurante");
        restauranteButton.setFont(new Font("Arial", Font.BOLD, 16));
        restauranteButton.setBackground(Color.WHITE);
        restauranteButton.setForeground(Color.BLACK);
        restauranteButton.setMargin(new Insets(10, 20, 10, 20));


        gbcBtn.gridx = 0;
        gbcBtn.gridy = 0;
        gbcBtn.gridwidth = 1;
        buttonPanel.add(usuarioButton, gbcBtn);

        gbcBtn.gridx = 1;
        buttonPanel.add(restauranteButton, gbcBtn);

        usuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaPrincipal.mostrarTela("SignUsuarioT");
            }
        });

        restauranteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaPrincipal.mostrarTela("SignRestauranteT");
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(buttonPanel, gbc);

        add(panel, BorderLayout.CENTER);
    }
}
