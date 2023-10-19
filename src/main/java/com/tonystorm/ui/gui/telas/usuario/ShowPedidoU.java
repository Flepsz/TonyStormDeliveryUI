package com.tonystorm.ui.gui.telas.usuario;

import com.tonystorm.ui.gui.telas.TelaPrincipal;
import com.tonystorm.ui.models.Comida;
import com.tonystorm.ui.models.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ShowPedidoU extends JPanel {
    public ShowPedidoU(TelaPrincipal telaRestauranteP, Pedido pedido) throws Exception {
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(2, 1));
        GridBagConstraints gbcT = new GridBagConstraints();
        gbcT.insets = new Insets(10, 10, 40, 10);

        String nomeUsuarioField = pedido.getUsuario().getNome();
        String endereco = String.valueOf(pedido.getUsuario().getEndereco().getX()) + " | " + String.valueOf(pedido.getUsuario().getEndereco().getY());
        String precoTotal = pedido.getPrecoTotal().toString();
        String distancia = pedido.getDistancia().toString();
        String status = pedido.getStatus();

        JPanel fieldsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Pedido");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        fieldsPanel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        fieldsPanel.add(new JLabel("Nome: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        fieldsPanel.add(new JLabel(nomeUsuarioField), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        fieldsPanel.add(new JLabel("Endereco: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        fieldsPanel.add(new JLabel(endereco), gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        fieldsPanel.add(new JLabel("Preço Total: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        fieldsPanel.add(new JLabel(precoTotal), gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        fieldsPanel.add(new Label("Distância:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        fieldsPanel.add(new JLabel(distancia), gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        fieldsPanel.add(new Label("Status:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        fieldsPanel.add(new JLabel(status), gbc);

        List<Comida> comidas = pedido.getComidas();

        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);

        tableModel.addColumn("Nome");
        tableModel.addColumn("Preço");

        for (Comida comida : comidas) {
            tableModel.addRow(new Object[]{comida.getNome(), comida.getPreco()});
        }

        JScrollPane scrollPane = new JScrollPane(table);

        add(fieldsPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        JPanel backButtonPanel = telaRestauranteP.getBackButton("ShowPedidosT");
        add(backButtonPanel, BorderLayout.NORTH);
    }
}
