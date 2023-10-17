package com.tonystorm.ui.gui.telas.login;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public TelaPrincipal() {
        setTitle("TonyStormDelivery");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(430, 932);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        TelaInicial telaInicial = new TelaInicial(this);
        SignUsuario telaUsuario = new SignUsuario(this);
        SignRestaurante telaRestaurante = new SignRestaurante(this);
        LoginUsuario loginUsuarioT = new LoginUsuario();
        LoginRestaurante loginRestauranteT = new LoginRestaurante();

        cardPanel.add(telaInicial, "TelaInicial");
        cardPanel.add(telaUsuario, "TelaUsuario");
        cardPanel.add(telaRestaurante, "TelaRestaurante");
        cardPanel.add(loginUsuarioT, "LoginUsuarioT");
        cardPanel.add(loginRestauranteT, "LoginRestauranteT");

        add(cardPanel);
        setLocationRelativeTo(null);
    }

    public void mostrarTela(String nomeTela) {
        cardLayout.show(cardPanel, nomeTela);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaPrincipal telaPrincipal = new TelaPrincipal();
            telaPrincipal.setVisible(true);
        });
    }
}
