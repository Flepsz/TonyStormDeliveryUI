package com.tonystorm.ui.gui.telas.login;

import com.tonystorm.ui.gui.telas.TelaPrincipal;
import com.tonystorm.ui.models.Endereco;
import com.tonystorm.ui.models.Usuario;
import com.tonystorm.ui.utils.APIRequestUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarUsuario extends JPanel{
    private final JTextField nomeField;
    private final JPasswordField senhaField;
    private final JTextField cpfField;
    private final JTextField endX;
    private final JTextField endY;

    public RegistrarUsuario(TelaPrincipal telaPrincipal) {
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Registro de Usuário");
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
        cpfField = new JTextField(20);
        cpfField.setPreferredSize(new Dimension(200, 30));
        endX = new JTextField(20);
        endX.setPreferredSize(new Dimension(200, 30));
        endY = new JTextField(20);
        endY.setPreferredSize(new Dimension(200, 30));

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
        panel.add(new JLabel("CPF: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(cpfField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new Label("Localização X:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(endX, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new Label("Localização Y:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(endY, gbc);

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
                String cpf = cpfField.getText();
                Endereco endereco = new Endereco(Double.parseDouble(endX.getText()), Double.parseDouble(endY.getText()));

                Usuario usuario = new Usuario();
                usuario.setNome(nome);
                usuario.setSenha(senha);
                usuario.setCPF(cpf);
                usuario.setEndereco(endereco);

                try {
                    new APIRequestUtil("/usuarios").sendPostRequest(usuario);
                    JOptionPane.showMessageDialog(RegistrarUsuario.this, "Usuário criado com sucesso!");
                    telaPrincipal.mostrarTela("LoginUsuarioT");
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
