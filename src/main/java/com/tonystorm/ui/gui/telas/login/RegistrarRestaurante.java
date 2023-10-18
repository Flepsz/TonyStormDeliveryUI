package com.tonystorm.ui.gui.telas.login;

import com.tonystorm.ui.gui.telas.TelaPrincipal;
import com.tonystorm.ui.models.Localizacao;
import com.tonystorm.ui.models.Restaurante;
import com.tonystorm.ui.utils.APIRequestUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarRestaurante extends JPanel {
    private final JTextField nomeField;
    private final JPasswordField senhaField;
    private final JTextField cnpjField;
    private final JTextField locX;
    private final JTextField locY;

    public RegistrarRestaurante(TelaPrincipal telaPrincipal) {
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Registro de Restaurante");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\53196583899\\Documents\\Dev\\TonyStormDeliveryUI\\src\\main\\resources\\tony2.png");
        JLabel imageLabel = new JLabel(imageIcon);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(imageLabel, gbc);

        nomeField = new JTextField(20);
        nomeField.setPreferredSize(new Dimension(200, 30));
        senhaField = new JPasswordField(20);
        senhaField.setPreferredSize(new Dimension(200, 30));
        cnpjField = new JTextField(20);
        cnpjField.setPreferredSize(new Dimension(200, 30));
        locX = new JTextField(20);
        locX.setPreferredSize(new Dimension(200, 30));
        locY = new JTextField(20);
        locY.setPreferredSize(new Dimension(200, 30));

        JButton registerButton = new JButton("Registrar");
        registerButton.setFont(new Font("Arial", Font.BOLD, 16));
        registerButton.setBackground(Color.WHITE);
        registerButton.setForeground(Color.BLACK);
        registerButton.setMargin(new Insets(10, 20, 10, 20));
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
        panel.add(new JLabel("CNPJ: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(cnpjField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new Label("Localização X:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(locX, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new Label("Localização Y:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(locY, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 4;
        panel.add(registerButton, gbc);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                char[] senhaChars = senhaField.getPassword();
                String senha = new String(senhaChars);
                String cnpj = cnpjField.getText();
                Localizacao localizacao = new Localizacao(Double.parseDouble(locX.getText()), Double.parseDouble(locY.getText()));

                Restaurante usuario = new Restaurante();
                usuario.setNome(nome);
                usuario.setSenha(senha);
                usuario.setCNPJ(cnpj);
                usuario.setLocalizacao(localizacao);

                try {
                    new APIRequestUtil("/restaurantes").sendPostRequest(usuario);
                    JOptionPane.showMessageDialog(RegistrarRestaurante.this, "Restaurante criado com sucesso!");
                    telaPrincipal.mostrarTela("LoginRestauranteT");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        add(panel, BorderLayout.CENTER);

        JPanel backButtonPanel = telaPrincipal.getBackButton("SignRestauranteT");
        add(backButtonPanel, BorderLayout.NORTH);
    }
}
