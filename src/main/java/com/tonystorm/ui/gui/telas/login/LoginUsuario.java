package com.tonystorm.ui.gui.telas.login;

import com.tonystorm.ui.gui.telas.TelaPrincipal;
import com.tonystorm.ui.gui.telas.usuario.HomeUsuario;
import com.tonystorm.ui.models.Usuario;
import com.tonystorm.ui.services.auth.AuthServiceUsuario;
import com.tonystorm.ui.services.get.APIGetUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LoginUsuario extends JPanel {
    private final JTextField nomeField;
    private final JPasswordField senhaField;

    public LoginUsuario(TelaPrincipal telaPrincipal) {
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Login de Usuário");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\ct67ca\\Documents\\TonyStormDeliveryUI\\src\\main\\resources\\tonylogin.png");
        JLabel imageLabel = new JLabel(imageIcon);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(imageLabel, gbc);

        nomeField = new JTextField(20);
        nomeField.setPreferredSize(new Dimension(200, 30));
        senhaField = new JPasswordField(20);
        senhaField.setPreferredSize(new Dimension(200, 30));

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setBackground(Color.WHITE);
        loginButton.setForeground(Color.BLACK);
        loginButton.setMargin(new Insets(10, 20, 10, 20));
        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Nome: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(nomeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Senha: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(senhaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 4;
        panel.add(loginButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                char[] senhaChars = senhaField.getPassword();
                String senha = new String(senhaChars);

                try {
                    List<Usuario> usuarios = new APIGetUsuario().getAll();

                    AuthServiceUsuario authService = new AuthServiceUsuario(usuarios);
                    Usuario authenticatedUsuario = authService.authenticate(nome, senha);

                    if (authenticatedUsuario != null) {
                        telaPrincipal.setUsuarioLogado(authenticatedUsuario);

                        HomeUsuario homeUsuario = new HomeUsuario(telaPrincipal);
                        telaPrincipal.cardPanel.add(homeUsuario, "HomeUsuarioT");
                        JOptionPane.showMessageDialog(LoginUsuario.this, "Logado com sucesso!");
                        telaPrincipal.mostrarTela("HomeUsuarioT");
                    } else {
                        JOptionPane.showMessageDialog(LoginUsuario.this, "Login falhou. Por favor revise suas credenciais.");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        add(panel, BorderLayout.CENTER);

        JPanel backButtonPanel = telaPrincipal.getBackButton("SignUsuarioT");
        add(backButtonPanel, BorderLayout.NORTH);
    }

}
