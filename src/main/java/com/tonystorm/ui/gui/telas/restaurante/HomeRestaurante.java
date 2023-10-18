package com.tonystorm.ui.gui.telas.restaurante;

import com.tonystorm.ui.gui.telas.TelaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeRestaurante extends JPanel {
    public HomeRestaurante(TelaPrincipal telaPrincipal) throws Exception {
        setLayout(new BorderLayout());

        FormComida formComida = new FormComida(telaPrincipal);

        telaPrincipal.getCardPanel().add(formComida, "FormComidaT");

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

        JButton postComidaBotao = new JButton("Registrar Comida");
        postComidaBotao.setFont(new Font("Arial", Font.BOLD, 16));
        postComidaBotao.setBackground(Color.WHITE);
        postComidaBotao.setForeground(Color.BLACK);
        postComidaBotao.setMargin(new Insets(10, 20, 10, 20));

        JButton seeComidasButton = new JButton("Comidas");
        seeComidasButton.setFont(new Font("Arial", Font.BOLD, 16));
        seeComidasButton.setBackground(Color.WHITE);
        seeComidasButton.setForeground(Color.BLACK);
        seeComidasButton.setMargin(new Insets(10, 20, 10, 20));

        JButton pedidoButton = new JButton("Pedidos");
        pedidoButton.setFont(new Font("Arial", Font.BOLD, 16));
        pedidoButton.setBackground(Color.WHITE);
        pedidoButton.setForeground(Color.BLACK);
        pedidoButton.setMargin(new Insets(10, 20, 10, 20));


        gbcBtn.gridx = 0;
        gbcBtn.gridy = 0;
        gbcBtn.gridwidth = 1;
        buttonPanel.add(postComidaBotao, gbcBtn);

        gbcBtn.gridy = 1;
        buttonPanel.add(seeComidasButton, gbcBtn);

        gbcBtn.gridy = 2;
        buttonPanel.add(pedidoButton, gbcBtn);

        postComidaBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaPrincipal.mostrarTela("FormComidaT");
            }
        });

        seeComidasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ShowCardapio showCardapio = new ShowCardapio(telaPrincipal);
                    telaPrincipal.getCardPanel().add(showCardapio, "ShowCardapioT");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }


                telaPrincipal.mostrarTela("ShowCardapioT");
            }
        });

        pedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ShowUsuariosPedido showUsuariosPedido = new ShowUsuariosPedido(telaPrincipal);
                    telaPrincipal.getCardPanel().add(showUsuariosPedido, "ShowUsuariosPedidoT");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                telaPrincipal.mostrarTela("ShowUsuariosPedidoT");
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
