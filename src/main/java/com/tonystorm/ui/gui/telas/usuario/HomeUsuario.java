package com.tonystorm.ui.gui.telas.usuario;

import com.tonystorm.ui.gui.telas.TelaPrincipal;
import com.tonystorm.ui.gui.telas.restaurante.HomeRestaurante;
import com.tonystorm.ui.gui.telas.restaurante.ShowUsuariosPedido;
import com.tonystorm.ui.models.Pedido;
import com.tonystorm.ui.models.Restaurante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class HomeUsuario extends JPanel {
    public HomeUsuario(TelaPrincipal telaPrincipal) {
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 40, 10);

        JLabel titleLabel = new JLabel("Bem vindo, " + telaPrincipal.getUsuarioLogado().getNome());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcBtn = new GridBagConstraints();
        gbcBtn.insets = new Insets(10, 10, 10, 10);

        JButton postPedidoBotao = new JButton("Fazer Pedido");
        postPedidoBotao.setFont(new Font("Arial", Font.BOLD, 16));
        postPedidoBotao.setBackground(Color.WHITE);
        postPedidoBotao.setForeground(Color.BLACK);
        postPedidoBotao.setMargin(new Insets(10, 20, 10, 20));

        JButton pedidoButton = new JButton("Ver Meus Pedidos");
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
                try {
                    ShowRestaurantes showRestaurantes = new ShowRestaurantes(telaPrincipal);
                    List<Restaurante> restaurantes = showRestaurantes.getRestaurantes(telaPrincipal);

                    if (!restaurantes.isEmpty()) {
                        telaPrincipal.getCardPanel().add(showRestaurantes, "ShowRestaurantesT");
                        telaPrincipal.mostrarTela("ShowRestaurantesT");
                    } else {
                        JOptionPane.showMessageDialog(HomeUsuario.this, "Não há restaurantes disponíveis!");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        pedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ShowPedidos showPedidos = new ShowPedidos(telaPrincipal);
                    List<Pedido> pedidos = showPedidos.getPedido(telaPrincipal);

                    if (!pedidos.isEmpty()) {
                        telaPrincipal.getCardPanel().add(showPedidos, "ShowPedidosT");
                        telaPrincipal.mostrarTela("ShowPedidosT");
                    } else {
                        JOptionPane.showMessageDialog(HomeUsuario.this, "Não há pedidos seus!");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(buttonPanel, gbc);

        add(panel, BorderLayout.CENTER);

        JPanel backButtonPanel = telaPrincipal.getLogoutButton("TelaInicial", () -> telaPrincipal.setUsuarioLogado(null));
        add(backButtonPanel, BorderLayout.NORTH);
    }
}
