package com.tonystorm.ui.gui.telas.restaurante;

import com.tonystorm.ui.gui.telas.TelaPrincipal;
import com.tonystorm.ui.models.Comida;
import com.tonystorm.ui.utils.APIRequestUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormComida extends JPanel {
    private final JTextField nomeField;
    private final JTextField precoField;

    public FormComida(TelaPrincipal telaPrincipal) {
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Registro de Comida");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\53196583899\\Documents\\Dev\\TonyStormDeliveryUI\\src\\main\\resources\\tonylogin.png");
        JLabel imageLabel = new JLabel(imageIcon);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(imageLabel, gbc);

        nomeField = new JTextField(20);
        nomeField.setPreferredSize(new Dimension(200, 30));
        precoField = new JTextField(20);
        precoField.setPreferredSize(new Dimension(200, 30));

        JButton registerButton = new JButton("Registrar");
        registerButton.setPreferredSize(new Dimension(100, 40));
        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Nome: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(nomeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Preco: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(precoField, gbc);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                Double preco = Double.parseDouble(precoField.getText());

                Comida comida = new Comida();
                comida.setNome(nome);
                comida.setPreco(preco);

                try {
                    new APIRequestUtil("/restaurantes/%s/comidas").sendPostRequest(comida);
                    JOptionPane.showMessageDialog(FormComida.this, "Comida registrada com sucesso!");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        add(panel, BorderLayout.CENTER);
    }
}
