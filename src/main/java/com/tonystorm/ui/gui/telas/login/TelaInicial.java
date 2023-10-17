package com.tonystorm.ui.gui.telas.login;

import com.tonystorm.ui.gui.telas.TelaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JPanel {
    public TelaInicial(TelaPrincipal telaPrincipal) {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("TonyStormDelivery");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        JLabel quemVoceELabel = new JLabel("Quem você é?");
        quemVoceELabel.setFont(new Font("Arial", Font.PLAIN, 16));
        quemVoceELabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(quemVoceELabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());

        JButton usuarioButton = new JButton("Usuário");
        JButton restauranteButton = new JButton("Restaurante");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        buttonPanel.add(usuarioButton, gbc);
        gbc.gridy = 1;
        buttonPanel.add(restauranteButton, gbc);

        add(buttonPanel, BorderLayout.CENTER);

        usuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaPrincipal.mostrarTela("TelaUsuario");
            }
        });

        restauranteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaPrincipal.mostrarTela("TelaRestaurante");
            }
        });

//        JButton backButton = new JButton("Voltar");
//        backButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                telaPrincipal.mostrarTela("TelaInicial");
//            }
//        });
//        add(backButton, BorderLayout.NORTH);
    }
}
