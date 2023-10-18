package com.tonystorm.ui.gui.telas.restaurante;

import com.tonystorm.ui.gui.telas.TelaPrincipal;
import com.tonystorm.ui.models.Comida;
import com.tonystorm.ui.services.get.APIGetComida;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ShowCardapio extends JPanel {
    public ShowCardapio(TelaPrincipal telaRestauranteP) throws Exception {
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 40, 10);

        JLabel titleLabel = new JLabel("Cardápio");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        List<Comida> comidas = getComidas(telaRestauranteP);

        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);

        tableModel.addColumn("Nome");
        tableModel.addColumn("Preço");

        for (Comida comida : comidas) {
            tableModel.addRow(new Object[]{comida.getNome(), comida.getPreco()});
        }

        JScrollPane scrollPane = new JScrollPane(table);

        gbc.gridy = 1;
        gbc.gridwidth = 0;
        add(scrollPane, gbc);
    }

    public List<Comida> getComidas(TelaPrincipal telaRestauranteP) throws Exception {
        return new APIGetComida(telaRestauranteP.getRestauranteLogado().getId().toString()).getAll();
    }
}
