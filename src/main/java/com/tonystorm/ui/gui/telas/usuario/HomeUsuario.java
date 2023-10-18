package com.tonystorm.ui.gui.telas.usuario;

import com.tonystorm.ui.gui.telas.TelaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeUsuario extends JPanel {
    public HomeUsuario(TelaPrincipal telaPrincipal) {
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 40, 10);

        JLabel titleLabel = new JLabel("Restaurante Admin");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcBtn = new GridBagConstraints();
        gbcBtn.insets = new Insets(10, 10, 10, 10);

        JButton postPedidoBotao = new JButton("Restaurantes");
        postPedidoBotao.setFont(new Font("Arial", Font.BOLD, 16));
        postPedidoBotao.setBackground(Color.WHITE);
        postPedidoBotao.setForeground(Color.BLACK);
        postPedidoBotao.setMargin(new Insets(10, 20, 10, 20));

        JButton pedidoButton = new JButton("Ver Pedidos");
        pedidoButton.setFont(new Font("Arial", Font.BOLD, 16));
        pedidoButton.setBackground(Color.WHITE);
        pedidoButton.setForeground(Color.BLACK);
        pedidoButton.setMargin(new Insets(10, 20, 10, 20));

        gbcBtn.gridx = 0;
        gbcBtn.gridy = 0;
        gbcBtn.gridwidth = 1;
        buttonPanel.add(postPedidoBotao, gbcBtn);

        gbcBtn.gridy = 1;
        buttonPanel.add(pedidoButton, gbcBtn);

        postPedidoBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaPrincipal.mostrarTela("FormComidaT");
            }
        });

        pedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaPrincipal.mostrarTela("");
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(buttonPanel, gbc);

        add(panel, BorderLayout.CENTER);

        JPanel backButtonPanel = telaPrincipal.getLogoutButton("TelaInicial");
        add(backButtonPanel, BorderLayout.NORTH);
    }
}
