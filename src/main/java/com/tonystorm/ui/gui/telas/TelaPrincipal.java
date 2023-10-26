package com.tonystorm.ui.gui.telas;

import com.tonystorm.ui.gui.telas.login.*;
import com.tonystorm.ui.models.Restaurante;
import com.tonystorm.ui.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
@Setter
@AllArgsConstructor
public class TelaPrincipal extends JFrame {
    private CardLayout cardLayout;
    public JPanel cardPanel;

    private Usuario usuarioLogado;
    private Restaurante restauranteLogado;

    public TelaPrincipal() throws Exception {
        setTitle("TonyStormDelivery");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(430, 932);
        setResizable(false);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        TelaInicial telaInicial = new TelaInicial(this);
        SignUsuario signUsuarioT = new SignUsuario(this);
        SignRestaurante signRestauranteT = new SignRestaurante(this);

        LoginUsuario loginUsuarioT = new LoginUsuario(this);
        LoginRestaurante loginRestauranteT = new LoginRestaurante(this);

        RegistrarUsuario registrarUsuario = new RegistrarUsuario(this);
        RegistrarRestaurante registrarRestaurante = new RegistrarRestaurante(this);


        cardPanel.add(telaInicial, "TelaInicial");
        cardPanel.add(signUsuarioT, "SignUsuarioT");
        cardPanel.add(signRestauranteT, "SignRestauranteT");
        cardPanel.add(loginUsuarioT, "LoginUsuarioT");
        cardPanel.add(loginRestauranteT, "LoginRestauranteT");
        cardPanel.add(registrarUsuario, "RegistrarUsuarioT");
        cardPanel.add(registrarRestaurante, "RegistrarRestauranteT");


        add(cardPanel);
        setLocationRelativeTo(null);
    }

    public void mostrarTela(String nomeTela) {
        cardLayout.show(cardPanel, nomeTela);
    }

    public JPanel getBackButton(String nomeDaTela) {
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton();
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.BLACK);
        ImageIcon arrowIcon = new ImageIcon("C:\\Users\\ct67ca\\Documents\\TonyStormDeliveryUI\\src\\main\\resources\\arrow.png");
        backButton.setIcon(arrowIcon);
        backButton.setPreferredSize(new Dimension(40, 40));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTela(nomeDaTela);
            }
        });
        backButtonPanel.add(backButton);
        return backButtonPanel;
    }

    public JPanel getLogoutButton(String nomeDaTela, Runnable action) {
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton();
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.BLACK);
        ImageIcon arrowIcon = new ImageIcon("C:\\Users\\ct67ca\\Documents\\TonyStormDeliveryUI\\src\\main\\resources\\logout.png");
        backButton.setIcon(arrowIcon);
        backButton.setPreferredSize(new Dimension(40, 40));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.run();
                mostrarTela(nomeDaTela);
            }
        });
        backButtonPanel.add(backButton);
        return backButtonPanel;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaPrincipal telaPrincipal = null;
            try {
                telaPrincipal = new TelaPrincipal();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            telaPrincipal.setVisible(true);
        });
    }
}
